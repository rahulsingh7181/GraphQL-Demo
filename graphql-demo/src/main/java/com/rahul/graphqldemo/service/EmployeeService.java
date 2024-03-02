package com.rahul.graphqldemo.service;

import com.rahul.graphqldemo.dto.EmployeeDto;
import com.rahul.graphqldemo.model.Department;

import java.util.Date;
import java.util.List;

public interface EmployeeService {

    // getting data
    List<EmployeeDto> getAllEmployee();
    EmployeeDto getOneEmployee(Long id);
    // create data
    EmployeeDto createEmployee(String name,
                               Integer age,
                               Integer salary,
                               String joiningDate,
                               boolean status,
                               Department department);
}
