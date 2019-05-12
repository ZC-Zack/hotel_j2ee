package com.xmut.hotel.mapper;

import com.xmut.hotel.entity.Comment;

import java.util.List;

public interface CommentMapper {
    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectAllComment();
}