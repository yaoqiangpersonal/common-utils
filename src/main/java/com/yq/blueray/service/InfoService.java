package com.yq.blueray.service;

import base.BaseService;
import base.impl.vo.AbstractVo;
import com.yq.blueray.dao.InfoMapper;
import com.yq.blueray.entity.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: yq
 * @Date: 2018-09-11 11:12
 * @Description:
 */
@Service
public class InfoService implements BaseService<Info> {

    @Autowired
    private InfoMapper infoMapper;

    public void insert(Info i){
        infoMapper.insert(i);
    }

    @Override
    public int add(Info info) throws Exception {
        return 0;
    }

    @Override
    public int delete(Info info) throws Exception {
        return 0;
    }

    @Override
    public int update(Info info) throws Exception {
        return 0;
    }

    @Override
    public int addSelective(Info info) throws Exception {
        return 0;
    }

    @Override
    public int updateSelective(Info info) throws Exception {
        return 0;
    }

    @Override
    public Info findById(int id) throws Exception {
        return null;
    }

    @Override
    public List<Info> findByVo(AbstractVo<? extends Info> vo) throws Exception {
        return null;
    }

}
