package com.xmut.hotel.entity;

public class Room {
    private String roomId;

    private String roomName;

    private Integer roomPrice;

    private Integer roomExit;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId == null ? null : roomId.trim();
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName == null ? null : roomName.trim();
    }

    public Integer getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(Integer roomPrice) {
        this.roomPrice = roomPrice;
    }

    public Integer getRoomExit() {
        return roomExit;
    }

    public void setRoomExit(Integer roomExit) {
        this.roomExit = roomExit;
    }
}