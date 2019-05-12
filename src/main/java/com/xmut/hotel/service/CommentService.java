package com.xmut.hotel.service;

import com.alibaba.fastjson.JSONArray;
import com.xmut.hotel.entity.Comment;

import java.util.List;

public interface CommentService {
    JSONArray getAllComment();

    List<Comment> getListComment();
}
