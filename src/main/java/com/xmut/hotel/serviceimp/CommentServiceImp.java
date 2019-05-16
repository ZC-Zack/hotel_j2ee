package com.xmut.hotel.serviceimp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xmut.hotel.entity.Comment;
import com.xmut.hotel.mapper.CommentMapper;
import com.xmut.hotel.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class CommentServiceImp implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private HttpSession session;

    private JSONObject jsonObject;

    //获取所有评价
    @Override
    public JSONArray getAllComment() {
        return JSONArray.parseArray(JSON.toJSONString(commentMapper.selectAllComment()));
    }

    //获取所有评价用List封装
    public List<Comment> getListComment(){
        return commentMapper.selectAllComment();
    }

    @Override
    public List<Comment> getListCommentByExit(Integer exit) {
        Comment comment = new Comment();
        comment.setCommentExit(exit);
        comment.setUsername((String) session.getAttribute("username"));
        return commentMapper.selectCommentByExit(comment);
    }

    @Override
    public JSONObject getJSONObjectCommentByExit(Integer exit) {
        List <Comment> list = getListCommentByExit(exit);
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(list));
        formatJSON(jsonArray);
        return jsonObject;
    }

    @Override
    public int setCommentContent(JSONObject jsonObject) {
        Comment comment = JSON.toJavaObject(jsonObject, Comment.class);
        comment.setCommentExit(1);
        return commentMapper.updateCommentById(comment);
    }

    //格式化信息
    @Override
    public void formatJSON(JSONArray jsonArray) {
        jsonObject = new JSONObject();
        jsonObject.put("data", jsonArray);
        jsonObject.put("code", 0);
        jsonObject.put("msg", "");
        jsonObject.put("count", jsonArray.size());
    }
}
