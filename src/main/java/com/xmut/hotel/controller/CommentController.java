package com.xmut.hotel.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xmut.hotel.service.CommentService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class CommentController {

    @Autowired
    private CommentService commentService;

    //返回所有评价
    @RequestMapping("/getAllComment")
    @ResponseBody
    public JSONArray getAllComment(){
        return commentService.getAllComment();
    }

    //返回未评价
    @RequestMapping("/getNoEvaluation")
    @ResponseBody
    public JSONObject getNoEvaluation(){
        return commentService.getJSONObjectCommentByExit(0);
    }

    @RequestMapping("/updateComment")
    public void updateComment(@RequestBody JSONObject value){
        System.out.println(value.toJSONString());
    }

}
