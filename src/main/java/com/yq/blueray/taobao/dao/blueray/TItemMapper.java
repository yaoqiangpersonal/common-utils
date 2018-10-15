package com.yq.blueray.taobao.dao.blueray;

import com.yq.blueray.taobao.entity.blueray.TItem;

public interface TItemMapper {
    int deleteByPrimaryKey(Integer bid);

    int insert(TItem record);

    int insertSelective(TItem record);

    TItem selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(TItem record);

    int updateByPrimaryKey(TItem record);
}