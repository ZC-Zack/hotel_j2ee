package com.xmut.hotel.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xmut.hotel.entity.Order;

import java.util.List;

public interface OrderService {
    //生成季度报表
    JSONObject getJSONObjectMonth();

    //通过Exit查找订单,返回List
    List<Order> getListOrderByExit(Integer usedExit);

    //通过exit来返回JSONObject
    JSONObject getJSONObjectOrderByExit(Integer usedExit);

    //生成订单
    int setOrder(JSONObject jsonObject);

    //取消订单
    int cancelOrder(JSONObject jsonObject);

    //确认订单
    int confirmOrder(JSONObject jsonObject);

    //通过用户名查找未完成或已完成的订单
    JSONObject getRoomByUsername(Integer usedExit);

    //格式转换，格式转换成layui表格要求的格式
    void formatJSON(JSONArray jsonArray);
}
