package com.xmut.hotel.controller;

import com.alibaba.fastjson.JSONObject;
import com.xmut.hotel.entity.Room;
import com.xmut.hotel.service.CommentService;
import com.xmut.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
        List<Room> list =  roomService.getListRoomByGroup();
        map.addAttribute("roomList", list);
        return "user/roomOrder";
    }

    //跳转订单页面
    @RequestMapping("/orderSet")
    public String orderSet(ModelMap map, @RequestParam String roomName){
        map.addAttribute("roomName", roomName);
        map.addAttribute("roomId", roomService.getRoomByName(roomName).get(0));
        //return new ModelAndView("redirect:/user/orderSet");
        return "/user/orderSet";
    }

    //房间详情
    @RequestMapping("/roomScan")
    public String roomScan(ModelMap map, @RequestParam String roomId){
        Room room = roomService.getRoomById(roomId);
        map.addAttribute("room", room);
        //System.out.println(room);
        return "user/roomScan";
    }

    @RequestMapping("/userOrder")
    public String userOrder(){
        return "user/userOrder";
    }

    @RequestMapping("/apply")
    public String apply(){
        return "user/apply";
    }

}
