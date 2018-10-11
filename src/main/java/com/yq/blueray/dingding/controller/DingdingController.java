package com.yq.blueray.dingding.controller;

import com.yq.blueray.crawler.service.CamelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: yq
 * @Date: 2018-09-24 17:48
 * @Description:
 */
@Controller
@RequestMapping("/dingding")
public class DingdingController {

    @Autowired
    private CamelService camelService;

    @RequestMapping("/crawlerDe")
    public void crawlerDe() throws Exception{
        camelService.crawlerImportant();
    }

}
