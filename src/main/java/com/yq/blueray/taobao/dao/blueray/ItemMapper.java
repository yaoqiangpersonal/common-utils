package com.yq.blueray.taobao.dao.blueray;

import com.yq.blueray.taobao.entity.blueray.Item;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemMapper {
    int deleteByPrimaryKey(Integer bid);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);
}