package com.xmut.hotel.mapper;

import com.xmut.hotel.entity.Room;
import com.xmut.hotel.entity.User;

import java.util.List;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);


}