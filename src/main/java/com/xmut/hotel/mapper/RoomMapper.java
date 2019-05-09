package com.xmut.hotel.mapper;

import com.xmut.hotel.entity.Room;

public interface RoomMapper {
    int insert(Room record);

    int insertSelective(Room record);
}