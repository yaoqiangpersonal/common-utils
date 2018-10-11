package com.yq.blueray.crawler.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yq.blueray.crawler.enums.AmazonPrefix;
import com.yq.blueray.crawler.mapper.CamelMapper;
import com.yq.blueray.crawler.po.Bluray;
import com.yq.blueray.crawler.processor.CamelProcessor;
import com.yq.blueray.crawler.service.CamelService;
import com.yq.blueray.dingding.service.DingdingService;
import com.yq.blueray.taobao.entity.blueray.TItem;
import com.yq.blueray.taobao.mapper.blueray.TItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import us.codecraft.webmagic.Spider;

import java.math.BigDecimal;
import java.util.*;

/**
 *
 * @Auther: yq
 *
 * @Date: 2018-09-21 11:50
 *
 * @Description:
 *
 */
@Service
public class CamelServiceImpl extends ServiceImpl<CamelMapper, Bluray> implements CamelService {

    @Autowired
    private CamelMapper camelMapper;

    @Autowired
    private DingdingService dingdingService;

    public void crawlerImportant() throws Exception{
        List<Bluray> list = camelMapper.selectList(createWrapper());
        Map<String,BigDecimal> acceptablePrice = readyBlurayUrls(list);
        List<String> shouldBuy = crawler(acceptablePrice);
    }


    private List<String> crawler(Map<String,BigDecimal> acceptablePrice){
        System.setProperty("https.protocols", "TLSv1.2");
        long startTime, endTime;
        System.out.println("开始爬取...");
        startTime = System.currentTimeMillis();
        CamelProcessor camelProcessor = new CamelProcessor(camelMapper,acceptablePrice);
        Spider.create(camelProcessor).thread(5).startUrls(new ArrayList<>(acceptablePrice.keySet())).run();
        System.out.println(camelProcessor.getList());
        endTime = System.currentTimeMillis();
        String msg = "爬取结束，耗时约" + ((endTime - startTime) / 1000) + "秒，抓取了"+acceptablePrice.size()+"条记录";
        System.out.println(msg);
        return camelProcessor.getList();
    }

    /**
     * 根据前缀生成相对应的urls
     *
     * @param list 集合
     * @return 返回urls
     */
    private Map<String,BigDecimal> readyBlurayUrls(List<? extends Bluray> list){
        Map<String,BigDecimal> urlsAndPrice = new HashMap<>();
        list.forEach(b-> urlsAndPrice.put(AmazonPrefix.fromState(b.getState()).getPrefix() + b.getAsin(),b.getAcceptablePrice()));
        return urlsAndPrice;
    }
    /**
     * 通知龙姐姐，爬取完成
     */
    private void atEmployee(String msg){
        dingdingService.sendMessageToProgram(msg,"15281143071",false);
    }


    /**
     *
     * 创造条件
     *
     * @return
     */
    private Wrapper<Bluray> createWrapper(){
        QueryWrapper<Bluray> camelQueryWrapper = new QueryWrapper<>();
        camelQueryWrapper.eq("important",1);
        camelQueryWrapper.isNotNull("asin");
        camelQueryWrapper.orderByDesc("update_time");
        return camelQueryWrapper;
    }

}
