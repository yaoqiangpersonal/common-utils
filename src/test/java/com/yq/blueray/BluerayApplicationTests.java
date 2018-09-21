package com.yq.blueray;

import com.yq.blueray.crawler.service.impl.CamelServiceImpl;
import com.yq.blueray.taobao.entity.blueray.TItem;
import com.yq.blueray.taobao.mapper.blueray.TItemMapper;
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
    private CamelServiceImpl camelService;

    @Test
    public void contextLoads() {
        camelService.crawlerAll();
    }

}
