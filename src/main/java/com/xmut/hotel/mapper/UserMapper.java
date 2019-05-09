package com.xmut.hotel.mapper;

import com.xmut.hotel.entity.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}