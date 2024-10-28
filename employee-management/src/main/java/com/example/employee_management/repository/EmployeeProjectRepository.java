package com.example.employee_management.repository;

import com.example.employee_management.model.EmployeeProjectModel;

import java.util.List;

public interface EmployeeProjectRepository {
    void assignEmployeeToProject(Long employeeId,Long projectId);
    void removeEmployeeFromProject(Long employeeId,Long projectId);
    List<EmployeeProjectModel> getProjectsByEmployeeId(Long employeeId);
    List<EmployeeProjectModel> getEmployeesByProjectId(Long projectId);
}
