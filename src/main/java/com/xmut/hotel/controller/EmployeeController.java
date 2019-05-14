package com.xmut.hotel.controller;

import com.alibaba.fastjson.JSONObject;
import com.xmut.hotel.entity.Employee;
import com.xmut.hotel.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    //得到员工申请表格
    @RequestMapping("/getApply")
    @ResponseBody
    public JSONObject getApply(){
        return employeeService.getJSONObjectApplyByPass(0);
    }

    //得到员工表格
    @RequestMapping("/getEmployee")
    @ResponseBody
    public JSONObject getEmployee(){
        return employeeService.getJSONObjectEmployee();
    }

    //处理员工审核结果
    @RequestMapping("/setApply")
    @ResponseBody
    public int setApply(@RequestBody JSONObject jsonObject){
        return employeeService.updateApply(jsonObject);
    }

    //删除员工
    @RequestMapping("/delEmployee")
    @ResponseBody
    public int delEmployee(@RequestBody JSONObject jsonObject){
        return employeeService.deleteEmployeeById(jsonObject.getString("employeeId"));
    }
}
