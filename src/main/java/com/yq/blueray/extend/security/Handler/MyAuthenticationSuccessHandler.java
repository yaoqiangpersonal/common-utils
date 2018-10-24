package com.yq.blueray.extend.security.Handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yq.blueray.common.utils.Msg;
import com.yq.blueray.common.utils.ResponseWriter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Auther: yq
 * @Date: 2018-10-17 17:18
 * @Description: 认证成功处理器
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        ResponseWriter
                .custom(httpServletResponse)
                .build()
                .writeJson(Msg.SUCCESS.add("user",authentication));
    }
}
