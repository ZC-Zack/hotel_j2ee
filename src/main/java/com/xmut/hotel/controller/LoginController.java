package com.xmut.hotel.controller;

import com.xmut.hotel.entity.User;
import com.xmut.hotel.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
@Controller

@RequestMapping("/")
public class LoginController {
    /**
     * 注入service
     */
    @Autowired
    private LoginService loginService;

    /**
     * 跳转到用户登录页面
     * @return 登录页面
     */
    @RequestMapping("/loginHtml")
    public String loginHtml(){
        return "login";
    }
    /**
     * 跳转到用户注册页面
     * @return 注册页面
     */
    @RequestMapping("/registerPage")
    public String registerpage(){
        return "register";
    }

    /**
     * 获取用户名与密码，用户登录
     * @return 登录成功页面
     */
    @RequestMapping("/userLogin")
    public String userLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request){

        User user = loginService.userLogin(username,password);

        if(user != null){                                                  //登录成功
            request.getSession().setAttribute("sessio" +
                    "n_user",user);     //将用户信息放入session
            return "user/admin";
        }
        return "loginError";
    }

    /**
     * 注册新用户
     * @return 注册结果
     */
    @ResponseBody
    @RequestMapping(value = {"/uregister"})
    public String addUser(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("password2") String password2){
        String judge="1";

        int res = loginService.adduser(username,password);
        if(res == 0){
            judge="0";
            System.out.println(judge);
            return "已被注册！";
        }else if(!password.equals(password2)){
            return "两次密码不相同，注册失败！！";
        }else {
                return "注册成功！";
            }
    }

}
