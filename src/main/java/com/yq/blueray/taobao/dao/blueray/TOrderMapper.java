package com.yq.blueray.taobao.dao.blueray;

import com.yq.blueray.taobao.entity.blueray.TOrder;

public interface TOrderMapper {
    int deleteByPrimaryKey(Integer oid);

    int insert(TOrder record);

    int insertSelective(TOrder record);

    TOrder selectByPrimaryKey(Integer oid);

    int updateByPrimaryKeySelective(TOrder record);

    int updateByPrimaryKey(TOrder record);
}