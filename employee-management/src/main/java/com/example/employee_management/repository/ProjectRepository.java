package com.example.employee_management.repository;

import com.example.employee_management.dto.DepartmentDto;
import com.example.employee_management.dto.EmployeeDto;
import com.example.employee_management.dto.ProjectDto;
import com.example.employee_management.model.DepartmentModel;
import com.example.employee_management.model.EmployeeModel;
import com.example.employee_management.model.ProjectModel;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository {
    void save(ProjectDto project);
    Optional<ProjectModel> findById(Long id);
    List<ProjectModel>  findAll();
    void update(Long id ,ProjectDto project);
    void deleteById(Long id);
}
