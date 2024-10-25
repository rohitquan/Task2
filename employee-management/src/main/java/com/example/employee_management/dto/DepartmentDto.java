package com.example.employee_management.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EmployeeDto {
    private String firstName;
    private String lastName;
    private String email;
    private Long departmentId;
}
