package com.rahul.graphqldemo.service;

import com.rahul.graphqldemo.dto.EmployeeDto;
import com.rahul.graphqldemo.model.Department;
import com.rahul.graphqldemo.model.Employee;
import com.rahul.graphqldemo.reporsitory.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    // get all employee
    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employeeList = employeeRepository.findAll();
        return (employeeList.stream().map(employee -> employeeToEmployeeDto(employee)).collect(Collectors.toList()));
    }

    // get employee by id
    @Override
    public EmployeeDto getOneEmployee(Long id) {
        return employeeToEmployeeDto(employeeRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Resource not found.")));
    }

    // save employee in database
    @Override
    public EmployeeDto createEmployee(String name,
                                      Integer age,
                                      Integer salary,
                                      String joiningDate,
                                      boolean status,
                                      Department department) {
        Employee employee = Employee.builder()
                .name(name)
                .age(age)
                .salary(salary)
                .joiningDate(joiningDate)
                .status(status)
                .department(department)
                .build();
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeToEmployeeDto(savedEmployee);
    }

    // covert Employee to EmployeeDto
    private EmployeeDto employeeToEmployeeDto(Employee employee){
        return EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .age(employee.getAge())
                .salary(employee.getSalary())
                .joiningDate(employee.getJoiningDate())
                .status(employee.isStatus())
                .department(employee.getDepartment())
                .build();
    }

    // covert EmployeeDto to Employee
    private Employee employeeDtoToEmployee(EmployeeDto employeeDto){
        return Employee.builder()
                .id(employeeDto.getId())
                .name(employeeDto.getName())
                .age(employeeDto.getAge())
                .salary(employeeDto.getSalary())
                .joiningDate(employeeDto.getJoiningDate())
                .status(employeeDto.isStatus())
                .department(employeeDto.getDepartment())
                .build();
    }
}
