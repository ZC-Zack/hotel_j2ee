package com.xmut.hotel.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xmut.hotel.entity.Comment;

import java.util.List;

public interface CommentService {
    JSONArray getAllComment();

    List<Comment> getListComment();

    //通过exit来返回list合集
    List<Comment> getListCommentByExit(Integer exit);

    //通过exit来返回JSONObject
    JSONObject getJSONObjectCommentByExit(Integer exit);

    //更新评价内容
    int setCommentContent(JSONObject jsonObject);

    //格式转换，格式转换成layui表格要求的格式
    void formatJSON(JSONArray jsonArray);
}
