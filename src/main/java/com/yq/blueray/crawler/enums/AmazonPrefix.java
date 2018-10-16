package com.yq.blueray.crawler.enums;

import lombok.Getter;

import java.util.Arrays;

/**
 * @Auther: yq
 * @Date: 2018-10-11 14:46
 * @Description:  亚马逊前缀枚举
 */

public enum AmazonPrefix {


    GERMANY(1,"Germany", "de.","德国"),
    UNITED_STATES(2,"United States","","美国"),
    UNITED_KINGDOM(3,"United Kingdom","uk.","英国"),
    FRANCE(4,"France","fr.","法国"),
    ITALY(5,"Italy","it.","意大利"),
    SPAIN(6,"Spain","es.","西班牙"),
    CANADA(7,"Canada","ca.","加拿大"),
    JAPAN(8,"Japan","jp.","日本");

    private final static String _prefix = "https://";
    private final static String _suffix = "camelcamelcamel.com/product/";

    private final int id;
    private final String state;
    private final String prefix;
    private final String chinese;

    AmazonPrefix(final int id,final String state,final String prefix,final String chinese){
        this.id = id;
        this.state = state;
        this.prefix = _prefix + prefix + _suffix;
        this.chinese = chinese;
    }

    public int getId() {
        return id;
    }

    public String getState() {
        return state;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getChinese(){return chinese;}

    public static AmazonPrefix fromState(String s){
        for(AmazonPrefix a:values()){
            if(a.state.equals(s))
                return a;
        }
        return null;
    }

}
