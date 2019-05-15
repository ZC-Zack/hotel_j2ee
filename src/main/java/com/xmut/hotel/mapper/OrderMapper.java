package com.xmut.hotel.mapper;

import com.xmut.hotel.entity.Apply;
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

    //插入订单
    int insertOrder(Order order);

    //查找最后一个订单号
    String selectLastId();

    //修改Exit 数据通过id
    int updateOrderUsedById(Order order);

}