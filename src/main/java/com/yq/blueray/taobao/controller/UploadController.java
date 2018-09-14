package com.yq.blueray.taobao.controller;

import com.yq.blueray.common.utils.Msg;
import com.yq.blueray.taobao.entity.blueray.Item;
import com.yq.blueray.taobao.entity.blueray.Order;
import com.yq.blueray.taobao.enums.ConfigProperties;
import com.yq.blueray.taobao.service.ItemService;
import com.yq.blueray.taobao.service.OrderService;
import com.yq.blueray.utils.CSVUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @Auther: yq
 * @Date: 2018-09-13 18:06
 * @Description:
 */
@RestController
@RequestMapping(value = "/upload")
public class UploadController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/csvupload")
    public Msg upload(@RequestParam(value="file",required=false) MultipartFile file) throws Exception{
        ConfigProperties c = ConfigProperties.fromName(file.getName());

        if(c == ConfigProperties.ORDER){
            List<Order> list = CSVUtil.csvToList(Order.class,file.getInputStream(),c.getProperties());
        }else if(c == ConfigProperties.ITEM){
            List<Item> list = CSVUtil.csvToList(Item.class,file.getInputStream(),c.getProperties());
        }
        return Msg.success().add("msg","success");
    }

}
