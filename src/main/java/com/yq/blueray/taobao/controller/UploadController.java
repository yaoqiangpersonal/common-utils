package com.yq.blueray.taobao.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther: yq
 * @Date: 2018-09-27 15:46
 * @Description:
 */
@RestController
public class UploadController {

    @RequestMapping("/upload")
    public void upload(MultipartFile file){
        System.out.println(file.getOriginalFilename());
    }
}
