package com.xmut.hotel.mapper;

import com.xmut.hotel.entity.Room;

import java.util.List;

public interface RoomMapper {
    //获取所有房间的Map
    List<Room> selectAllRoom();
}