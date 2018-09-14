package com.yq.blueray.taobao.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * @Auther: yq
 * @Date: 2018-09-14 17:23
 * @Description:
 */
public enum ConfigProperties {


    ORDER(0,"/object-excel/orderHeaders.properties","订单"),
    ITEM(1,"/object-excel/itemHeaders.properties","宝贝");

    private final static Logger log = LoggerFactory.getLogger(ConfigProperties.class);

    private final int id;

    private final String name;

    private final Properties pro = new Properties();

    ConfigProperties(int id,String path,String name){
        this.id = id;
        this.name = name;
        try {
            pro.load(this.getClass().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(path + "读取文件出现问题..");
        }
    }

    public int getId() {
        return id;
    }

    public Properties getProperties(){
        return (Properties)pro.clone();
    }

    public static ConfigProperties fromName(String name){
        for(ConfigProperties c:values()){
            if(name.contains(c.name))
                return c;
        }
        throw new RuntimeException(name + "找不到关键字，获取pro失败...");
    }
}
