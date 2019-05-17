package com.xmut.hotel.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xmut.hotel.entity.Room;

import java.util.List;

public interface RoomService {

    //获取所有房间信息
    JSONObject getJSONObjectRoom();

    //获取所有房间List存放
    List<Room> getListRoom();

    ///获取房间通过group by
    List<Room> getListRoomByGroup();

    //格式转换，格式转换成layui表格要求的格式
    void formatJSON(JSONArray jsonArray);

    //查找房间信息通过Exit,返回List合集
    List<Room> getListListRoomByExit(Integer exit);

    //查找房间信息通过Exit,返回JSON合集
    JSONObject getListJSONObjectRoomByExit(Integer exit);

    //通过房间Id查找房间
    Room getRoomById(String roomId);

    //查找空房间Id
    List<String> getRoomByName(String roomName);


    int updateRoomUsedById(JSONObject jsonObject);

    //查找房间价格
    String getRoomPrice(String roomPrice);
}
