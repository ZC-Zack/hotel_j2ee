package com.xmut.hotel.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xmut.hotel.service.CommentService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private HttpSession session;

    //返回所有评价
    @RequestMapping("/getAllComment")
    public JSONObject getAllComment(){
        return commentService.getJSONObjectCommentByExit(1);
    }

    //返回未评价
    @RequestMapping("/getNoEvaluation")
    public JSONObject getNoEvaluation(){
        return commentService.getJSONObjectCommentByExit(0);
    }

    @RequestMapping("/updateComment")
    public int updateComment(@RequestBody JSONObject jsonObject){
        return commentService.setCommentContent(jsonObject);
    }

}
