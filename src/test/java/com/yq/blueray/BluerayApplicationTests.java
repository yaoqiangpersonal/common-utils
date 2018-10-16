package com.yq.blueray;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.yq.blueray.crawler.po.Bluray;

import com.yq.blueray.crawler.service.CamelService;
import com.yq.blueray.security.dao.UserDao;
import com.yq.blueray.security.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BluerayApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void contextLoads() {

        try {
            User u = userDao.getByUserName("admin");
            System.out.println(u);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * 创造条件
     *
     * @return
     */
    private Wrapper<Bluray> createWrapper(){
        QueryWrapper<Bluray> camelQueryWrapper = new QueryWrapper<>();
        camelQueryWrapper.eq("state","Germany");
        camelQueryWrapper.isNotNull("asin");
        camelQueryWrapper.orderByDesc("update_time");
        return camelQueryWrapper;
    }

}
