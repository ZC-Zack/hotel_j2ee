package com.xmut.hotel.controller;

import com.xmut.hotel.entity.Room;
import com.xmut.hotel.service.CommentService;
import com.xmut.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private RoomService roomService;

    @RequestMapping("/comment")
    public String comment(ModelMap map){
        map.addAttribute("commentList", commentService.getListComment());
        return "user/comment";
    }

    //跳转预订房间页面
    @RequestMapping("/roomOrder")
    public String roomOrder(ModelMap map){
        List<Room> list =  roomService.getListRoom();
        map.addAttribute("roomList", list);
        return "user/roomOrder";
    }

    //跳转订单页面
    @RequestMapping("orderSet")
    public String orderSet(){
        return "user/orderSet";
    }
}
