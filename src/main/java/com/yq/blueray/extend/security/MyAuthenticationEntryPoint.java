package com.yq.blueray.extend.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yq.blueray.common.utils.Msg;
import com.yq.blueray.common.utils.ResponseWriter;
import org.apache.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @Auther: yq
 * @Date: 2018-10-24 15:01
 * @Description: 授权出现异常，处理器
 */
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        ResponseWriter
                .custom(httpServletResponse)
                .setStatus(HttpStatus.SC_FORBIDDEN)
                .build()
                .writeJson(Msg.FORBIDDEN);
    }
}
