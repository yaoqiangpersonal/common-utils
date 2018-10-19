package com.yq.blueray.extend.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * 权限实体
 */
@Data
@AllArgsConstructor
public class UrlGrantedAuthority implements GrantedAuthority {

    private String permissionUrl;
    private String method;
    private String authority;

    /**
     * 获取角色权限
     *
     * @return
     */
    @Override
    public String getAuthority() {
        return authority;
    }
}
