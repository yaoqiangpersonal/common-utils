package com.yq.blueray.entity;


/**
 * @Auther: yq
 * @Date: 2018-09-11 10:52
 * @Description:
 */
public class Info {
    private Integer id;
    private String name;

    public Info() {
    }

    public Info(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
