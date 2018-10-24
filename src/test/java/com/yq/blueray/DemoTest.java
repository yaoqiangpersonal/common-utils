package com.yq.blueray;


import com.yq.blueray.crawler.po.Bluray;
import com.yq.blueray.extend.security.MyPasswordEncoder;
import com.yq.blueray.security.po.User;
import com.yq.blueray.taobao.entity.blueray.TOrder;
import com.yq.blueray.utils.ImageUtil;
import com.yq.blueray.utils.MD5Util;
import org.apache.naming.factory.BeanFactory;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * @Auther: yq
 * @Date: 2018-09-14 15:18
 * @Description:
 */
public class DemoTest {

    @Test
    public void run(){
        File sorce = new File("C:\\Users\\Administrator\\Desktop\\DVD截图\\");
        File dest = new File("C:\\Users\\Administrator\\Desktop\\1\\");
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
        //LoginUrlAuthenticationEntryPoint
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
    }

    private int select(List<Integer> list){
        return q(5,list);
    }

    private int q(int size,List<Integer> list){
        List<Integer> arrayList = new ArrayList<>();
        return 0;
    }
    private void add(int size,List<Integer> list,List<String> arrayList,Integer count){
    }
    private Integer o(){
        return new Integer(20);
    }
}
