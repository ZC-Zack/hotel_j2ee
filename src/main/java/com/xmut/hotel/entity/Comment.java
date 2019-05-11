package com.xmut.hotel.entity;

public class Comment {
    private String orderId;

    private String username;

    private String commentTime;

    private String content;

    private Double starNumber;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime == null ? null : commentTime.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Double getStarNumber() {
        return starNumber;
    }

    public void setStarNumber(Double starNumber) {
        this.starNumber = starNumber;
    }
}