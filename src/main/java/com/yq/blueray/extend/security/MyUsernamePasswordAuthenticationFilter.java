package com.yq.blueray.extend.security;

import com.yq.blueray.common.utils.JsonLoginUtil;
import com.yq.blueray.extend.security.Handler.MyAuthenticationFailureHandler;
import com.yq.blueray.extend.security.Handler.MyAuthenticationSuccessHandler;
import com.yq.blueray.utils.JsonPathUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.*;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;


/**
 * @Auther: yq
 * @Date: 2018-10-16 18:44
 * @Description:  参数转换
 */
public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private String body;

    public MyUsernamePasswordAuthenticationFilter() {
    }

    @Override
    protected String obtainPassword(HttpServletRequest request) {
        return JsonLoginUtil.getParams(request,getPasswordParameter());
    }

    @Override
    protected String obtainUsername(HttpServletRequest request) {
        return JsonLoginUtil.getParams(request,getUsernameParameter());
    }

    /**
     * 获取参数方式
     *
     * @param key 关键词
     * @param request   请求体
     * @return 返回参数
     */
    private String get(String key,HttpServletRequest request){
        try {
            return JsonLoginUtil.getParams(request,key);
        } catch (Exception e) {
            logger.error("获取" + key + "出现问题，返回空");
            return "";
        }
    }

}
