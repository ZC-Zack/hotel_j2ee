package com.xmut.hotel.controller;

import com.alibaba.fastjson.JSONObject;
import com.xmut.hotel.service.OrderService;
import com.xmut.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RoomService roomService;


    //返回每月收入
    @RequestMapping("/monthOrder")
    @ResponseBody
    public JSONObject getMonthOrder(){
        return orderService.getJSONObjectMonth();
    }


    //返回已经完成的订单
    @RequestMapping("/adminCompleteOrder")
    @ResponseBody
    public JSONObject adminCompleteOrder(){
        return orderService.getJSONObjectOrderByExit(1);
    }

    //返回未完成的订单
    @RequestMapping("/adminUnCompleteOrder")
    @ResponseBody
    public JSONObject adminUnCompleteOrder(){
        return orderService.getJSONObjectOrderByExit(0);
    }

    //返回已经完成的订单
    @RequestMapping("/completeOrder")
    @ResponseBody
    public JSONObject getCompleteOrder(){
        return orderService.getRoomByUsername(1);
    }

    //返回未完成的订单
    @RequestMapping("/unCompleteOrder")
    @ResponseBody
    public JSONObject getUnCompleteOrder(){
        return orderService.getRoomByUsername(0);
    }

    @RequestMapping("/getRoomByName")
    @ResponseBody
    public int getRoomByName(@RequestBody JSONObject jsonObject){
        if(0 == roomService.getRoomByName(jsonObject.getString("roomName")).size()) {
            return 0;
        }else {
            return 1;
        }
    }

    //生成订单
    @RequestMapping(value = "/setOrderTable", method =RequestMethod.POST)
    @ResponseBody
    public int setOrderTable(@RequestBody JSONObject jsonObject){
        System.out.println(jsonObject.toJSONString());
        System.out.println(orderService.setOrder(jsonObject));
        return 1;
    }

    //取消订单
    @RequestMapping(value = "/cancelOrder",method = RequestMethod.POST)
    @ResponseBody
    public int cancelOrder(@RequestBody JSONObject jsonObject){
        return orderService.cancelOrder(jsonObject);
    }

    //确认订单
    @RequestMapping("/confirmOrder")
    @ResponseBody
    public int confirmOrder(@RequestBody JSONObject jsonObject){
        return orderService.confirmOrder(jsonObject);
    }
}
