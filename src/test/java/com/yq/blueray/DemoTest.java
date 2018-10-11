package com.yq.blueray;


import com.yq.blueray.crawler.po.Bluray;
import com.yq.blueray.taobao.entity.blueray.TOrder;
import org.junit.Test;

/**
 * @Auther: yq
 * @Date: 2018-09-14 15:18
 * @Description:
 */
public class DemoTest {

    @Test
    public void run(){
        Integer a = 1,b = 2;
        System.out.println(a == (a = b));
    }

}
