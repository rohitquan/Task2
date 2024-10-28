package com.example.employee_management.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class EmployeeProjectModel {
    private Long employeeId;
    private Long projectId;
}
