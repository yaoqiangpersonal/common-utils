package com.yq.blueray.extend.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.AbstractAccessDecisionManager;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;


/**
 * 决策管理器
 */
public class UrlAccessDecisionManager extends AbstractAccessDecisionManager {


    public UrlAccessDecisionManager(List<AccessDecisionVoter<? extends Object>> decisionVoters) {
        super(decisionVoters);
    }

    /**
     * 授权
     *
     * @param authentication 登录的用户信息
     * @param object    访问的资源
     * @param configAttributes  访问资源要求的权限配置ConfigAttributeDefinition。
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        String url, method;
        for (GrantedAuthority ga : authentication.getAuthorities()) {
            if (ga instanceof UrlGrantedAuthority) {
                UrlGrantedAuthority urlGrantedAuthority = (UrlGrantedAuthority) ga;
                url = urlGrantedAuthority.getPermissionUrl();
                method = urlGrantedAuthority.getMethod();
                if (matchers(url, request)) {
                    if (method.equals(request.getMethod()) || "ALL".equals(method)) {
                        return;
                    }
                }
            }
        }
        throw new AccessDeniedException("no right");
    }


    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }


    private boolean matchers(String url, HttpServletRequest request) {
        AntPathRequestMatcher matcher = new AntPathRequestMatcher(url);
        if (matcher.matches(request)) {
            return true;
        }
        return false;
    }
}
