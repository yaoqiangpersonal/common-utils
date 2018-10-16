package com.yq.blueray.taobao.controller;

import com.yq.blueray.crawler.po.Bluray;
import com.yq.blueray.taobao.entity.blueray.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: yq
 * @Date: 2018-09-13 18:10
 * @Description:
 */
@Controller
public class HomeController {

    @RequestMapping("index")
    public String upload(){
        return "index";
    }

    @RequestMapping("/hello")
    public Bluray hello(){
        Bluray b = new Bluray();
        b.setAsin("123");
        b.setAudio("456");
        return b;
    }

}
