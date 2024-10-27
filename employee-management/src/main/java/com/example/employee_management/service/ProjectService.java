package com.example.employee_management.service;

import com.example.employee_management.dto.DepartmentDto;
import com.example.employee_management.dto.EmployeeDto;
import com.example.employee_management.dto.ProjectDto;
import com.example.employee_management.model.DepartmentModel;
import com.example.employee_management.model.EmployeeModel;
import com.example.employee_management.model.ProjectModel;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    void saveProject(ProjectDto project);
    Optional<DepartmentModel> getProjectById(Long id);
    List<ProjectModel> getAllProjects();
    void updateProject(Long id,ProjectDto project);
    void deleteProjectById(Long id);

}
