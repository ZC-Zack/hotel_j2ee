package com.xmut.hotel.mapper;

import com.xmut.hotel.entity.Employee;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(String employeeId);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(String employeeId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<Employee> selectAllEmployee();

    //插入员工数据
    int insertEmployee(Employee employee);

    //选择最后一个员工工号
    String selectLastId();

    //删除员工通过id
    int deleteEmployeeById(String employeeId);
}