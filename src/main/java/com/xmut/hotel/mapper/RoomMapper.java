package com.xmut.hotel.mapper;

import com.xmut.hotel.entity.Room;

import java.util.HashMap;
import java.util.List;

public interface RoomMapper {
    //获取所有房间的Map
    List<Room> selectAllRoom();

    //通过group by获取房间
    List<Room> selectAllRoomByGroup();

    //通过房间是否被预订进行查询
    List<Room> selectRoomByExit(Integer commentExit);

    //通过房间Id查找房间
    Room selectRoomById(String roomId);

    //通过roomId修改房间exit
    int updateRoomUsedById(Room room);

    //查找空房间号
    List<String> selectRoomByName(String roomName);

    //查找房价
    String selectPriceById(String roomId);
}