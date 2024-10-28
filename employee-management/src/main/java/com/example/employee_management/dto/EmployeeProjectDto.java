package com.example.employee_management.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EmployeeProjectDto {
    private Long employeeId;
    private Long projectId;
}
