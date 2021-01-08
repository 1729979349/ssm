package com.zking.ssm.service.Impl;

import com.zking.ssm.mapper.OrderMapper;
import com.zking.ssm.model.Order;
import com.zking.ssm.service.IOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {


    @Resource
    private OrderMapper OrderMapper;

    @Override
    public List<Order> queryOrderList(){
        return OrderMapper.queryOrderList();
    }
}
