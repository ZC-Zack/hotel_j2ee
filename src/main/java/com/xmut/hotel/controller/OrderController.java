package com.xmut.hotel.controller;

import com.alibaba.fastjson.JSONObject;
import com.xmut.hotel.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //返回已经完成的订单
    @RequestMapping("/completeOrder")
    @ResponseBody
    public JSONObject getCompleteOrder(){

        return orderService.getJSONObjectOrderByExit(1);
    }

    //返回未完成的订单
    @RequestMapping("/unCompleteOrder")
    @ResponseBody
    public JSONObject getUnCompleteOrder(){
        System.out.println(orderService.getJSONObjectOrderByExit(0).toJSONString());
        return orderService.getJSONObjectOrderByExit(0);
    }
}
