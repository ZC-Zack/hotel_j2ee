package com.xmut.hotel.serviceimp;

import com.xmut.hotel.entity.User;
import com.xmut.hotel.mapper.UserMapper;
import com.xmut.hotel.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImp implements LoginService {

    @Autowired
    private UserMapper userMapper;

    //用户登录
    public User userLogin(String username,String password){
        User user=userMapper.userlogin(username,password);
        return user;
    }

    //注册新用户
    public int adduser(String username,String password){
        return userMapper.adduser(username,password);
    }

}
