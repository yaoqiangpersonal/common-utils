package com.yq.blueray.taobao.service.impl;


import com.yq.blueray.common.base.impl.vo.AbstractVo;
import com.yq.blueray.taobao.dao.blueray.ItemMapper;
import com.yq.blueray.taobao.entity.blueray.Item;
import com.yq.blueray.taobao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @Auther: yq
 * @Date: 2018-09-12 17:50
 * @Description:
 *
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public int add(Item item) throws Exception {
        return 0;
    }

    @Override
    public int addBatch(List<Item> list) throws Exception {
        return 0;
    }

    @Override
    public int delete(Item item) throws Exception {
        return 0;
    }

    @Override
    public int update(Item item) throws Exception {
        return 0;
    }

    @Override
    public int addSelective(Item item) throws Exception {
        return 0;
    }

    @Override
    public int updateSelective(Item item) throws Exception {
        return 0;
    }

    @Override
    public Item findById(int id) throws Exception {
        return null;
    }

    @Override
    public List<Item> findByVo(AbstractVo<? extends Item> vo) throws Exception {
        return null;
    }
}
