package com.xmut.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/")
public class AdminController {


    /*
    * 首页的控制层
    * */
    @RequestMapping("/roomInformation")
    public String roomInformation(){
        return "roomInformation";
    }
}
