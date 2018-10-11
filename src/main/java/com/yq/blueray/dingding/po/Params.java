package com.yq.blueray.dingding.po;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: yq
 * @Date: 2018-09-24 14:45
 * @Description:
 */
public class Params {

    private final static Map<String, Object> params = new HashMap<String, Object>();
    private static Params instance;

    Params(){}

    private Map<String, Object> getParams() {
        return params;
    }

    /**
     * 获取单例
     *
     * @return
     */
    private static Params getInstance(){

        if(instance == null){
            instance = new Params();
        }
        return instance;
    }

    /**
     * 添加访问令牌
     *
     * @param accessToken
     * @return
     */
    public static Params addAccessToken(String accessToken){
        instance.getParams().clear();
        instance.getParams().put("access_token", accessToken);
        return instance;
    }

    /**
     * 添加ID和密匙，获取访问令牌
     *
     * @param corpId
     * @param corpSecret
     * @return
     */
    public static Params addCorpIdAndCorpSecret(String corpId,String corpSecret){
        getInstance();
        instance.getParams().clear();
        instance.getParams().put("corpid", corpId);
        instance.getParams().put("corpsecret", corpSecret);
        return instance;
    }

    /**
     * 添加name 和 value
     *
     * @param key
     * @param param
     * @return
     */
    public static Params add(String key,Object param){
        instance.getParams().put(key, param);
        return instance;
    }

    /**
     * 创建条件
     *
     * @return
     */
    public static Map<String, Object> build(){
        return Collections.unmodifiableMap(instance.getParams());
    }

}
