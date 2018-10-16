package com.yq.blueray.security.po;

import lombok.Data;

@Data
public class Permission {
    private Integer id;
    private String name;
    private String permissionUrl;
    private String method;
    private String description;

}