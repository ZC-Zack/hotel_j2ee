package com.xmut.hotel.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xmut.hotel.entity.Order;

import java.util.List;

public interface OrderService {

    //通过Exit查找订单,返回List
    List<Order> getListOrderByExit(Integer usedExit);

    //通过exit来返回JSONObject
    JSONObject getJSONObjectOrderByExit(Integer usedExit);

    //格式转换，格式转换成layui表格要求的格式
    void formatJSON(JSONArray jsonArray);
}
