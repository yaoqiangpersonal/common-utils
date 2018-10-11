package com.yq.blueray.crawler.enums;

import lombok.Getter;

import java.util.Arrays;

/**
 * @Auther: yq
 * @Date: 2018-10-11 14:46
 * @Description:  亚马逊前缀枚举
 */

public enum AmazonPrefix {


    GERMANY(1,"Germany", "de."),
    UNITED_STATES(2,"United States",""),
    UNITED_KINGDOM(3,"United Kingdom","uk."),
    FRANCE(4,"France","fr."),
    ITALY(5,"Italy","it."),
    SPAIN(6,"Spain","es."),
    CANADA(7,"Canada","ca."),
    JAPAN(8,"Japan","jp.");

    private final static String _prefix = "https://";
    private final static String _suffix = "camelcamelcamel.com/product/";

    private final int id;
    private final String state;
    private final String prefix;

    AmazonPrefix(final int id,final String state,final String prefix){
        this.id = id;
        this.state = state;
        this.prefix = _prefix + prefix + _suffix;
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

    public static AmazonPrefix fromState(String s){
        for(AmazonPrefix a:values()){
            if(a.state.equals(s))
                return a;
        }
        return null;
    }
}
