package com.yq.blueray.crawler.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.yq.blueray.common.utils.Msg;
import com.yq.blueray.crawler.po.Bluray;
import com.yq.blueray.crawler.service.CamelService;
import com.yq.blueray.crawler.vo.CamelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: yq
 * @Date: 2018-10-08 10:15
 * @Description:
 */
@RestController
@RequestMapping("/camel")
public class CamelController {

    @Autowired
    private CamelService camelService;

    @PostMapping("/findCamelByVo")
    public Msg findCamelByVo(@RequestBody CamelVo vo){
        PageHelper.startPage(vo.getPage(), vo.getLimit());
        Wrapper<Bluray> wrapper = createWrapper(vo.getInstance().getAsin());
        List<Bluray> list  = camelService.list(wrapper);
        PageInfo<Bluray> pageInfo= new PageInfo<Bluray>(list);
        return Msg.success().add("info",pageInfo);
    }


    @PostMapping("/updateAcceptablePrice")
    public Msg updateAcceptablePrice(@RequestBody Bluray bluray){
        Boolean b  = camelService.updateById(bluray);
        if(b)
            return Msg.success();
        return Msg.fail();
    }

    /**
     *
     * 创造条件
     *
     * @return
     */
    private Wrapper<Bluray> createWrapper(String asin){
        QueryWrapper<Bluray> camelQueryWrapper = new QueryWrapper<>();
        //camelQueryWrapper.eq("state","Germany");
        if(StringUtils.isNotEmpty(asin))
            camelQueryWrapper.eq("asin",asin);
        camelQueryWrapper.isNotNull("asin");
        camelQueryWrapper.orderByDesc("update_time");

        return camelQueryWrapper;
    }
}
