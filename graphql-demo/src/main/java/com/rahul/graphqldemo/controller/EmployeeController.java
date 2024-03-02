package com.rahul.graphqldemo.controller;

import com.rahul.graphqldemo.dto.EmployeeDto;
import com.rahul.graphqldemo.model.Department;
import com.rahul.graphqldemo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @MutationMapping
    public EmployeeDto createEmployee(@Argument String name,
                                      @Argument Integer age,
                                      @Argument Integer salary,
                                      @Argument String joiningDate,
                                      @Argument boolean status,
                                      @Argument Department department){
        return employeeService.createEmployee(name, age, salary, joiningDate, status, department);
    }

    @QueryMapping
    public EmployeeDto getOneEmployee(@Argument Long id){
        return employeeService.getOneEmployee(id);
    }

    @QueryMapping
    public List<EmployeeDto> getAllEmployee(){
        return employeeService.getAllEmployee();
    }
}
