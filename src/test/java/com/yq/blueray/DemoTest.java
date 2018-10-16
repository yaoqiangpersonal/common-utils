package com.yq.blueray;


import com.yq.blueray.crawler.po.Bluray;
import com.yq.blueray.taobao.entity.blueray.TOrder;
import com.yq.blueray.utils.ImageUtil;
import com.yq.blueray.utils.MD5Util;
import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.math.BigDecimal;

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
        System.out.println(MD5Util.encode("user"));


    }

}
