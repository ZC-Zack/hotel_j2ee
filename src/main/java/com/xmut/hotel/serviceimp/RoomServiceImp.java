package com.xmut.hotel.serviceimp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xmut.hotel.entity.Room;
import com.xmut.hotel.mapper.RoomMapper;
import com.xmut.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImp implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    private JSONObject jsonObject;

    @Override
    public List<Room> getListRoom() {
        return roomMapper.selectAllRoom();
    }

    //获取所有房间信息的方法实现
    @Override
    public JSONObject getJSONObjectRoom() {
        List<Room> list = getListRoom();
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(list));
        for(int i = 0; i < jsonArray.size(); i++){
           JSONObject jsonObject = jsonArray.getJSONObject(i);
           if("0".equals(jsonObject.getString("roomExit"))){
               jsonObject.put("roomExit", "否");
           }else {
               jsonObject.put("roomExit", "是");
           }
        }
        formatJSON(jsonArray);
        return jsonObject;
    }

    //格式化信息
    @Override
    public void formatJSON(JSONArray jsonArray) {
        jsonObject = new JSONObject();
        jsonObject.put("data", jsonArray);
        jsonObject.put("code", 0);
        jsonObject.put("msg", "");
        jsonObject.put("count", jsonArray.size());
    }

}
