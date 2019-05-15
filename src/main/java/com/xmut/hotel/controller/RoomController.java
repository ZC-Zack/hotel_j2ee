package com.xmut.hotel.controller;

import com.alibaba.fastjson.JSONObject;
import com.xmut.hotel.entity.Room;
import com.xmut.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/admin/updateRoom", method = RequestMethod.POST)
    @ResponseBody
    public void updateRoom(@RequestBody JSONObject jsonObject){
        roomService.updateRoomUsedById(jsonObject);
    }
}
