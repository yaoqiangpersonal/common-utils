package com.yq.blueray.crawler.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yq.blueray.crawler.po.Bluray;

import java.util.List;

/**
 * @Auther: yq
 * @Date: 2018-09-21 11:47
 * @Description:
 */
public interface CamelService extends IService<Bluray> {
    void crawlerImportant() throws Exception;
    void crawlerAll() throws Exception;
}
