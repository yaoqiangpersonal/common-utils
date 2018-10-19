package com.yq.blueray;


import com.yq.blueray.crawler.po.Bluray;
import com.yq.blueray.extend.security.MyPasswordEncoder;
import com.yq.blueray.security.po.User;
import com.yq.blueray.taobao.entity.blueray.TOrder;
import com.yq.blueray.utils.ImageUtil;
import com.yq.blueray.utils.MD5Util;
import org.junit.Test;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.awt.*;
import java.io.File;
import java.math.BigDecimal;
import java.util.Collection;

/**
 * @Auther: yq
 * @Date: 2018-09-14 15:18
 * @Description:
 */
public class DemoTest {

    @Test
    public void run(){
        File sorce = new File("F:\\1\\报名2\\");
        File dest = new File("F:\\png\\报名2\\");
        try {
            ImageUtil.to(sorce,
                    800,
                    800,
                    "png",
                    dest);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void demo(){
        AuthenticationManager au = new AuthenticationManager(){
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                //模拟查询
                User u = new User();
                u.setUsername("123");
                u.setPassword("456");
                MyPasswordEncoder mpe = new MyPasswordEncoder();
                String inputPassword = mpe.encode(authentication.getCredentials().toString());

                if (mpe.matches( u.getPassword(),inputPassword)) {
                    System.out.println("success");
                    return new UsernamePasswordAuthenticationToken(authentication, u.getPassword());
                }
                System.out.println("fail");
                return null;
            }
        };
        String username = "123";
        String passowrd = "456";
        UserDetails ud = new User();
        ((User) ud).setUsername(username);
        ((User) ud).setPassword(passowrd);
        Authentication ai = new UsernamePasswordAuthenticationToken(ud,ud.getPassword());

        au.authenticate(ai);

    }

    @Test
    public void demo1(){
        final Integer i;
        i = o();
    }

    private Integer o(){
        return new Integer(20);
    }
}
