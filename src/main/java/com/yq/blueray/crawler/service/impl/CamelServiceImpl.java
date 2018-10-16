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
        crawlerList(list);
    }

    public void crawlerUK() throws Exception{
        List<Bluray> list = camelMapper.selectList(createWrapper());
        crawlerList(list);
    }

    public void crawlerAll() throws Exception{
        List<Bluray> list = camelMapper.selectList(null);
        crawlerList(list);
    }

    private void crawlerList(List<Bluray> list) throws Exception{
        Map<String,Bluray> blurayMap = readyBlurayUrls(list);
        Map<String,List<Bluray>> shouldBuy = crawler(blurayMap);
        StringBuilder sb = new StringBuilder(1000);
        sb.append("这是测试");
        Set<String> set = shouldBuy.keySet();

        set.forEach(s->{
            sb.append("\r\n" + s + ":\r\n");
            shouldBuy.get(s).forEach(b->{
                sb.append("国家:" + AmazonPrefix.fromState(b.getState()).getChinese() + " asin:" + b.getAsin() + " 现在价格:" + b.getCurrentPrice() + " 最低价格: " + b.getLowestPrice()+ " 接受价格:" + b.getAcceptablePrice()  +"\r\n");
            });
        });
        atEmployee(sb.toString());
    }


    private Map<String,List<Bluray>> crawler(Map<String,Bluray> blurayMap){
        System.setProperty("https.protocols", "TLSv1.2");
        long startTime, endTime;
        System.out.println("开始爬取...");
        startTime = System.currentTimeMillis();
        CamelProcessor camelProcessor = new CamelProcessor(camelMapper,blurayMap);
        Spider.create(camelProcessor).thread(5).startUrls(new ArrayList<>(blurayMap.keySet())).run();
        Map<String,List<Bluray>> map = new HashMap<>();
        map.put("到达接受价格",camelProcessor.getAcceptablePrice());
        map.put("符合(最低价*1.05>现价)",camelProcessor.getProportionatelist());
        endTime = System.currentTimeMillis();
        String msg = "爬取结束，耗时约" + ((endTime - startTime) / 1000) + "秒，抓取了"+blurayMap.size()+"条记录";
        System.out.println(msg);
        return map;
    }

    /**
     * 根据前缀生成相对应的urls
     *
     * @param list 集合
     * @return 返回urls
     */
    private Map<String,Bluray> readyBlurayUrls(List<? extends Bluray> list){
        Map<String,Bluray> urlsAndPrice = new HashMap<>();
        list.forEach(b-> urlsAndPrice.put(AmazonPrefix.fromState(b.getState()).getPrefix() + b.getAsin(),b));
        return urlsAndPrice;
    }

    /**
     * 调用相对应的方法发送消息
     */
    private void atEmployee(String msg){
        dingdingService.priceAlarm(msg);
    }


    /**
     *
     * 创造条件
     *
     * @return
     */
    private Wrapper<Bluray> createWrapper(){
        QueryWrapper<Bluray> camelQueryWrapper = new QueryWrapper<>();
        camelQueryWrapper.eq("state","United Kingdom");
        camelQueryWrapper.isNotNull("asin");
        camelQueryWrapper.orderByDesc("update_time");
        return camelQueryWrapper;
    }
}
