package com.xmut.hotel.serviceimp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xmut.hotel.entity.Apply;
import com.xmut.hotel.entity.Employee;
import com.xmut.hotel.mapper.ApplyMapper;
import com.xmut.hotel.mapper.EmployeeMapper;
import com.xmut.hotel.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private JSONObject jsonObject;

    @Autowired
    private ApplyMapper applyMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Apply> getListApply() {
        return null;
    }

    @Override
    public List<Apply> getListApplyByPass(Integer pass) {
        return applyMapper.selectApplyByPass(pass);
    }

    @Override
    public List<Employee> getListEmployee() {
        return employeeMapper.selectAllEmployee();
    }

    @Override
    public JSONObject getJSONObjectApply() {
        return null;
    }

    @Override
    public JSONObject getJSONObjectApplyByPass(Integer pass) {
        List<Apply> list = getListApplyByPass(pass);
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(list));
        formatJSON(jsonArray);
        return jsonObject;
    }

    @Override
    public JSONObject getJSONObjectEmployee() {
        List<Employee> list = getListEmployee();
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(list));
        formatJSON(jsonArray);
        return jsonObject;
    }

    @Override
    public int updateApply(JSONObject jsonObject) {
        int result;
        Apply apply = JSON.toJavaObject(jsonObject, Apply.class);
        result = applyMapper.updateApplyPassById(apply);
        if(apply.getPass() == 1){
            Employee employee = JSON.toJavaObject(jsonObject, Employee.class);
            String employeeId = employeeMapper.selectLastId();
            employeeId = String.format("%02d", Integer.parseInt(employeeId) + 1);
            employee.setEmployeeId(employeeId);
            employee.setSalary(2000);
            result = employeeMapper.insertEmployee(employee);
        }
        return result;
    }

    //格式化信息
    @Override
    public void formatJSON(JSONArray jsonArray) {
        jsonObject = new JSONObject();
        jsonObject.put("data", jsonArray);
        jsonObject.put("code", 0);
        jsonObject.put("msg", "");
        jsonObject.put("count", jsonArray.size());
    }
}
