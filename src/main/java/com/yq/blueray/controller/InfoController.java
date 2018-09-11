package com.yq.blueray.controller;

import com.yq.blueray.entity.Info;
import com.yq.blueray.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: yq
 * @Date: 2018-09-11 11:14
 * @Description:
 */
@RestController
public class InfoController {

    @Autowired
    private InfoService infoService;

    @RequestMapping(value = "hello")
    public void hello(){
        System.out.println("123");

        Info i = new Info();
        i.setId(1);
        i.setName("one");
        infoService.insert(i);
    }

}
