package com.yq.blueray.taobao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: yq
 * @Date: 2018-09-13 18:10
 * @Description:
 */
@Controller
public class HomeController {

    @RequestMapping("gotoUpload")
    public String upload(){
        return "upload";
    }
}
