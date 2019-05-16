package com.xmut.hotel.mapper;

import com.xmut.hotel.entity.Comment;

import java.util.List;

public interface CommentMapper {

    List<Comment> selectAllComment();

    List<Comment> selectCommentByExit(Comment comment);

    //更新评价内容
    int updateCommentById(Comment comment);
}