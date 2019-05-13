package com.xmut.hotel.mapper;

import com.xmut.hotel.entity.Room;
import com.xmut.hotel.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    List<User> getAllUser();
    //用户登录
    User userlogin(@Param("username") String username, @Param("password") String password);

    //注册新用户
    int adduser(@Param("username") String username, @Param("password") String password);


}