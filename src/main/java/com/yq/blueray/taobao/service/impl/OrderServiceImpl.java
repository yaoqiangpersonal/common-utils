package com.yq.blueray.taobao.service.impl;

import com.yq.blueray.common.base.impl.vo.AbstractVo;
import com.yq.blueray.taobao.dao.blueray.OrderMapper;
import com.yq.blueray.taobao.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: yq
 * @Date: 2018-09-12 17:50
 * @Description:
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int add(Order order) throws Exception {
        return 0;
    }

    @Override
    public int addBatch(List<Order> list) throws Exception {
        return 0;
    }

    @Override
    public int delete(Order order) throws Exception {
        return 0;
    }

    @Override
    public int update(Order order) throws Exception {
        return 0;
    }

    @Override
    public int addSelective(Order order) throws Exception {
        return 0;
    }

    @Override
    public int updateSelective(Order order) throws Exception {
        return 0;
    }

    @Override
    public Order findById(int id) throws Exception {
        return null;
    }

    @Override
    public List<Order> findByVo(AbstractVo<? extends Order> vo) throws Exception {
        return null;
    }

}
