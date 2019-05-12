package com.xmut.hotel.service;

import com.xmut.hotel.entity.User;

public interface LoginService {
    //用户登录
    User userLogin(String username, String password);

    //注册新用户
    int adduser(String username, String password);

}
