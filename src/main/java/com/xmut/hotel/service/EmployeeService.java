package com.xmut.hotel.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xmut.hotel.entity.Apply;
import com.xmut.hotel.entity.Employee;

import java.util.List;

public interface EmployeeService {

    //获取所有申请表通过list封装
    List<Apply> getListApply();

    //获取by pass申请表通过list封装
    List<Apply> getListApplyByPass(Integer pass);

    //获取所有的员工表通过List封装
    List<Employee> getListEmployee();

    //获取所有的申请表通过JSON封装
    JSONObject getJSONObjectApply();

    //获取by pass的申请表通过JSON封装
    JSONObject getJSONObjectApplyByPass(Integer pass);

    //获取所有的员工表通过JSON封装
    JSONObject getJSONObjectEmployee();

    //插入员工数据
    int updateApply(JSONObject jsonObject);

    //格式转换，格式转换成layui表格要求的格式
    void formatJSON(JSONArray jsonArray);

}
