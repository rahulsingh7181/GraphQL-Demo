package com.rahul.graphqldemo.dto;

import com.rahul.graphqldemo.model.Department;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {
    private Long id;
    private String name;
    private Integer age;
    private Integer salary;
    private String joiningDate;
    private boolean status;
    @Enumerated(EnumType.STRING)
    private Department department;
}
