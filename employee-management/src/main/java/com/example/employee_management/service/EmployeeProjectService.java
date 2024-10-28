package com.example.employee_management.service;

import com.example.employee_management.dto.EmployeeProjectDto;
import com.example.employee_management.model.EmployeeProjectModel;

import java.util.List;

public interface EmployeeProjectService {
    void assignEmployeeToProject(EmployeeProjectDto employeeProjectDto);
    void removeEmployeeFromProject(EmployeeProjectDto employeeProjectDto);
    List<EmployeeProjectModel> getProjectsByEmployeeId(Long employeeId);
    List<EmployeeProjectModel> getEmployeesByProject(Long projectId);
}
