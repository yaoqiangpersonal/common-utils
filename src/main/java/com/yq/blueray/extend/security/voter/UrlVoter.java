package com.yq.blueray.extend.security.voter;

import com.yq.blueray.extend.security.UrlGrantedAuthority;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * @Auther: yq
 * @Date: 2018-10-18 16:49
 * @Description: url投票器
 */
public class UrlVoter implements AccessDecisionVoter<Object> {

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class aClass) {
        return true;
    }

    @Override
    public int vote(Authentication authentication, Object o, Collection<ConfigAttribute> collection) {
        if(authentication == null)
            return ACCESS_DENIED;

        HttpServletRequest request = ((FilterInvocation) o).getHttpRequest();
        String url;
        for (GrantedAuthority ga : authentication.getAuthorities()) {
            if (ga instanceof UrlGrantedAuthority) {
                UrlGrantedAuthority urlGrantedAuthority = (UrlGrantedAuthority) ga;
                url = urlGrantedAuthority.getPermissionUrl();
                if (matchers(url, request)) {
                    return ACCESS_GRANTED;
                }
            }
        }
        return ACCESS_DENIED;
    }

    private boolean matchers(String url, HttpServletRequest request) {
        AntPathRequestMatcher matcher = new AntPathRequestMatcher(url);
        if (matcher.matches(request)) {
            return true;
        }
        return false;
    }
}
