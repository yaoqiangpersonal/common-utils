package com.yq.blueray.dingding.service;

import com.dingtalk.api.request.OapiMessageSendToConversationRequest;

/**
 * @Auther: yq
 * @Date: 2018-09-24 14:38
 * @Description:
 */
public interface DingdingService  {
    String CORP_ID = "dingf1fea84d3c43eb46";
    String CORP_SECRET="mlPenYEQG1abODbGSc0eARarjBivZQ5Fqnwkw4Gkw-NvmitvFjUsbcpUMNnq8ICt";

    String MAIN_URL = "https://oapi.dingtalk.com/";
    String TOKEN_URL = MAIN_URL + "gettoken";
    String REST_URL = "https://eco.taobao.com/router/rest";
    String ROBOT_URL = "https://oapi.dingtalk.com/robot/send?access_token=";
    String USER_URL= MAIN_URL + "user/get";
    String DEPARTMENTS_URL = MAIN_URL + "department/list_ids";
    String DEPARTMENT_USERS_URL=MAIN_URL + "user/list";
    String DEPARTMENT_URL = MAIN_URL + "department/list";

    String PROGRAM_TOKEN = "b64c176b2ffcd4570ca0ec20abd828ffc9d524aa74b8ee2e4462167c46f10a63";


    String sendMessageToOne(String sender, String cid, OapiMessageSendToConversationRequest.Msg msg);

    String sendMessageToProgram(String context, String phone, boolean atAll);

}
