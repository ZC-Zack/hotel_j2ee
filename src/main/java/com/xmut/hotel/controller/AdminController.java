package com.xmut.hotel.controller;

import com.alibaba.fastjson.JSONObject;
import com.xmut.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    //空房间查询
    @RequestMapping("/roomEmpty")
    public String roomEmpty(){
        return "admin/roomEmpty";
    }
}
