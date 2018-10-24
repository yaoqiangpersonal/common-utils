package com.yq.blueray.extend.security.Handler;

import static com.yq.blueray.common.utils.Msg.*;

import com.yq.blueray.common.utils.Msg;
import com.yq.blueray.common.utils.ResponseWriter;
import com.yq.blueray.security.exception.PasswordException;
import org.apache.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @Auther: yq
 * @Date: 2018-10-18 10:06
 * @Description: 认证失败处理器
 */
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        ResponseWriter
                .custom(httpServletResponse)
                .setStatus(HttpStatus.SC_UNAUTHORIZED)
                .build()
                .writeJson(getMsgByException(e));
    }

    private Msg getMsgByException(AuthenticationException e){
        if(e instanceof UsernameNotFoundException){
            return USERNAME_ERROR;
        }else if(e instanceof PasswordException){
            return PASSWORD_ERROR;
        }else{
            return FAIL;
        }
    }

}
