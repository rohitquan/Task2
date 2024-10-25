package com.example.employee_management.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EmployeeModel {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long departmentId;

}
