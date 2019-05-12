package com.xmut.hotel.controller;

import com.xmut.hotel.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/comment")
    public String comment(ModelMap map){
        map.addAttribute("commentList", commentService.getListComment());
        return "user/comment";
    }

    @RequestMapping("/roomOrder")
    public String roomOrder(ModelMap map){
        return "user/roomOrder";
    }

}
