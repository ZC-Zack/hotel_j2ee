package com.xmut.hotel.serviceimp;

import com.xmut.hotel.entity.User;
import com.xmut.hotel.mapper.UserMapper;
import com.xmut.hotel.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
        List<User> list = userMapper.getAllUser();
        int res=1;
        String name;
        for(int i = 0; i < list.size(); i++){
            name=(String) list.get(i).getUsername();
            if(name.equals(username)){
                res=0;
                return res;
            }
        }
        if(res==1){
            userMapper.adduser(username,password);
        }
        return res;

    }
}
