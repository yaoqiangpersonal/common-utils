package com.yq.blueray.dingding.service;

import com.yq.blueray.dingding.service.abstractImpl.AbstractDingdingService;
import org.springframework.stereotype.Service;

/**
 * @Auther: yq
 *
 * @Date: 2018-09-24 14:39
 *
 * @Description:
 */
@Service
public class DingdingServiceImpl extends AbstractDingdingService {

    public void priceAlarm(String msg){
        sendMessageByRobotToken(msg,"15281143071",false,PRICE_ALARM);
    }
}
