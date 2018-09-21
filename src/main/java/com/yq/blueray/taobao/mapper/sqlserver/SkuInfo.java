package com.yq.blueray.taobao.mapper.sqlserver;

import org.apache.ibatis.annotations.Mapper;
import po.Bluray;

import java.util.List;

/**
 * @Auther: yq
 * @Date: 2018-09-19 15:58
 * @Description:
 */
@Mapper
public interface SkuInfo {
    List<Bluray> selectGermany() throws Exception;
}
