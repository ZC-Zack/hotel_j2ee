package com.xmut.hotel.serviceimp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.xmut.hotel.entity.Comment;
import com.xmut.hotel.mapper.CommentMapper;
import com.xmut.hotel.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImp implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    //获取所有评价
    @Override
    public JSONArray getAllComment() {
        return JSONArray.parseArray(JSON.toJSONString(commentMapper.selectAllComment()));
    }

    //获取所有评价用List封装
    public List<Comment> getListComment(){
        return commentMapper.selectAllComment();
    }
}
