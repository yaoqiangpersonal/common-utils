package com.yq.blueray.dingding.service.abstractImpl;


import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiMessageSendToConversationRequest;
import com.dingtalk.api.response.OapiMessageSendToConversationResponse;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.taobao.api.ApiException;
import com.yq.blueray.dingding.utils.HttpGet;

import com.yq.blueray.dingding.po.Params;
import com.yq.blueray.dingding.service.DingdingService;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * @Auther: yq
 * @Date: 2018-09-24 14:42
 * @Description:
 */

public abstract class AbstractDingdingService implements DingdingService {

    private long time;
    private String token;

    private void getAccessToken() {
        Params.addCorpIdAndCorpSecret(CORP_ID, CORP_SECRET);

        String jsonResult = HttpGet.get(TOKEN_URL, Params.build());
        DocumentContext jc = JsonPath.parse(jsonResult);
        token = jc.read("$.access_token");
    }

    private void checkToken() {
        if(System.currentTimeMillis() - time > 7100000){
            time = System.currentTimeMillis();
            getAccessToken();
        }
    }

    @Override
    public String sendMessageToOne(String sender, String cid, OapiMessageSendToConversationRequest.Msg msg){
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/message/send_to_conversation");

        OapiMessageSendToConversationRequest req = new OapiMessageSendToConversationRequest();
        req.setSender(sender);
        req.setCid(cid);
        req.setMsg(msg);

        checkToken();

        try {
            OapiMessageSendToConversationResponse response = client.execute(req, token);
            return response.getMsg();
        } catch (ApiException e) {
            e.printStackTrace();
            return "发送失败";
        }
    }

    @Override
    public String sendMessageToProgram(String context,String phone,boolean atAll){
        try {
            return dingdingnotice(ROBOT_URL + PROGRAM_TOKEN,context,phone,atAll);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 钉钉发送通知的方法
     * @param url
     * @param context
     * @param phone
     * @param boolstr
     * @throws Exception
     */
    private String dingdingnotice(String url,String context,String phone,boolean boolstr)
            throws Exception{

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);

        post.addHeader("Content-Type", "application/json; charset=utf-8");
        String textMsg = "{\"msgtype\": \"text\",\"text\": {\"content\": \""
                +context
                + "\"},\"at\": {\"atMobiles\": [\""+phone+"\"],\"isAtAll\": "+boolstr+"}}";
        StringEntity se = new StringEntity(textMsg, "utf-8");
        post.setEntity(se);
        org.apache.http.HttpResponse response = client.execute(post);
        if(response.getStatusLine().getStatusCode() == 200)
            return "success";
        return "fail";
    }
}
