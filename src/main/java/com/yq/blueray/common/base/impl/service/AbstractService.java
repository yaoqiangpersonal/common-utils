package com.yq.blueray.common.base.impl.service;

import com.yq.blueray.common.base.BaseService;
import com.yq.blueray.common.base.impl.vo.AbstractVo;

import java.util.List;

/**
 * @Auther: yq
 * @Date: 2018-09-12 17:57
 * @Description:
 */
public class AbstractService<T> implements BaseService<T> {

    @Override
    public int add(T t) throws Exception {
        return 0;
    }

    @Override
    public int delete(T t) throws Exception {
        return 0;
    }

    @Override
    public int update(T t) throws Exception {
        return 0;
    }

    @Override
    public int addSelective(T t) throws Exception {
        return 0;
    }

    @Override
    public int updateSelective(T t) throws Exception {
        return 0;
    }

    @Override
    public T findById(int id) throws Exception {
        return null;
    }

    @Override
    public List<T> findByVo(AbstractVo<? extends T> vo) throws Exception {
        return null;
    }
}
