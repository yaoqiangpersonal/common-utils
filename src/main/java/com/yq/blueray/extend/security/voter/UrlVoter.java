package com.yq.blueray.extend.security.voter;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;

import java.util.Collection;

/**
 * @Auther: yq
 * @Date: 2018-10-18 16:49
 * @Description:
 */
public class UrlVoter implements AccessDecisionVoter<Object> {

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return false;
    }

    @Override
    public boolean supports(Class aClass) {
        return false;
    }

    @Override
    public int vote(Authentication authentication, Object o, Collection<ConfigAttribute> collection) {
        return 0;
    }
}
