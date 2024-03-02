package com.rahul.graphqldemo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employee", schema = "graphql")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private Integer salary;
    private String joiningDate;
    private boolean status;
    @Enumerated(EnumType.STRING)
    private Department department;
}
