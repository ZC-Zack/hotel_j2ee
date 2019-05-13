package com.xmut.hotel.mapper;

import com.xmut.hotel.entity.Room;

import java.util.List;

public interface RoomMapper {
    //获取所有房间的Map
    List<Room> selectAllRoom();

    //通过group by获取房间
    List<Room> selectAllRoomByGroup();
}