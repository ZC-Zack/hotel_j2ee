package com.xmut.hotel.serviceimp;

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

    //获取所有房间信息的方法实现
    @Override
    public List<Room> getAllRoom() {
        return roomMapper.getAllRoom();
    }
}
