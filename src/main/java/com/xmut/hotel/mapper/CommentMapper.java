package com.xmut.hotel.mapper;

import com.xmut.hotel.entity.Comment;

public interface CommentMapper {
    int insert(Comment record);

    int insertSelective(Comment record);
}