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
@RestController
public class HomeController {

    @RequestMapping("gotoUpload")
    public String upload(){
        return "upload";
    }

    @RequestMapping("/hello")
    public Bluray hello(){
        Bluray b = new Bluray();
        b.setAsin("123");
        b.setAudio("456");
        return b;
    }

    @RequestMapping("/login")
    public void login(@RequestBody User user){
        System.out.println(user);
    }
}
