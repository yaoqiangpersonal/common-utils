package com.yq.blueray.crawler.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yq.blueray.crawler.mapper.CamelMapper;
import com.yq.blueray.crawler.service.CamelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.Bluray;
import processor.CamelProcessor;
import us.codecraft.webmagic.Spider;

import java.util.ArrayList;
import java.util.List;

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
public class CamelServiceImpl implements CamelService {

    @Autowired
    private CamelMapper camelMapper;

    public List<Bluray> crawlerAll(){
        List<Bluray> list = camelMapper.selectList(createWrapper());
        List<String> urls = new ArrayList<>();
        list.forEach(c-> urls.add("https://de.camelcamelcamel.com/product/" + c.getAsin()));
        System.setProperty("https.protocols", "TLSv1.2");
        long startTime, endTime;
        System.out.println("开始爬取...");
        startTime = System.currentTimeMillis();
        Spider.create(new CamelProcessor(camelMapper)).thread(5).startUrls(urls).run();
        endTime = System.currentTimeMillis();
        System.out.println("爬取结束，耗时约" + ((endTime - startTime) / 1000) + "秒，抓取了"+list.size()+"条记录");
        return list;
    }

    private Wrapper<Bluray> createWrapper(){
        QueryWrapper<Bluray> camelQueryWrapper = new QueryWrapper<>();
        camelQueryWrapper.eq("state","Germany");
        camelQueryWrapper.isNotNull("asin");
        camelQueryWrapper.orderByDesc("update_time");
        return camelQueryWrapper;
    }

}
