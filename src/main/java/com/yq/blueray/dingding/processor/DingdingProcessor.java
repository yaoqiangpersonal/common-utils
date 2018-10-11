package com.yq.blueray.dingding.processor;

import com.yq.blueray.dingding.service.DingdingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: yq
 * @Date: 2018-09-24 16:12
 * @Description:
 */
@Component
public class DingdingProcessor {

    @Autowired
    private DingdingService dingdingService;

    public String crawlerFinished(){
        String phone = "15281143071";
        String context = "测试";
        return dingdingService.sendMessageToProgram(context,phone,false);
    }
}
