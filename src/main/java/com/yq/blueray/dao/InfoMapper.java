package com.yq.blueray.dao;

import com.yq.blueray.entity.Info;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: yq
 * @Date: 2018-09-11 11:11
 * @Description:
 */
@Mapper
public interface InfoMapper {
    void insert(Info i);
}
