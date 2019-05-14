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
}