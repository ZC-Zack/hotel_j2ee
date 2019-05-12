package com.xmut.hotel.mapper;

import com.xmut.hotel.entity.Comment;

import java.util.List;

public interface CommentMapper {

    List<Comment> selectAllComment();

    List<Comment> selectCommentByExit(Integer commentExit);

}