package com.xmut.hotel.controller;

import com.alibaba.fastjson.JSONObject;
import com.xmut.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private RoomService roomService;
    /*
    * 首页的控制层
    * */
    @RequestMapping("/roomInformation")
    public String roomInformation(){
        return "admin/roomInformation";
    }

    @RequestMapping(value = "/getAllRoom", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getAllRoom(){
        return roomService.getJSONObjectRoom();
    }

    //已用房间
    @RequestMapping("/roomUsed")
    public String roomUsed(){
        return "admin/roomUsed";
    }

    //已用房间信息查询
    @RequestMapping("/used")
    @ResponseBody
    public JSONObject getRoomUsed(){
        return roomService.getListJSONObjectRoomByExit(1);
    }

    //空房间查询
    @RequestMapping("/roomEmpty")
    public String roomEmpty(){
        return "admin/roomEmpty";
    }

    //空房间信息查询
    @RequestMapping("empty")
    @ResponseBody
    public JSONObject getRoomEmpty(){
        return roomService.getListJSONObjectRoomByExit(0);
    }

    //完成订单页面
    @RequestMapping("/completeOrder")
    public String completeOrder(){
        return "admin/completeOrder";
    }

    //未完成订单页面
    @RequestMapping("/unCompleteOrder")
    public String unCompleteOrder(){
        return "admin/unCompleteOrder";
    }

    //员工页面
    @RequestMapping("/employee")
    public String employee(){
        return "admin/employee";
    }

    //员工申请页面
    @RequestMapping("/apply")
    public String apply(){
        return "admin/apply";
    }

    //季度报表
    @RequestMapping("/chartSeason")
    public String chartSeason(){
        return "admin/chartSeason";
    }

    //年度报表
    @RequestMapping("/chartYear")
    public String chartMonth(){
        return "admin/chartYear";
    }
}
