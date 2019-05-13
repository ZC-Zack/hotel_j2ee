package com.xmut.hotel.mapper;

import com.xmut.hotel.entity.Order;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    //通过exit查找订单信息
    List<Order> selectOrderByExit(Integer usedExit);
}