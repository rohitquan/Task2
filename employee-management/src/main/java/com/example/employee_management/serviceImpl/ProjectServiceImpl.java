package com.example.employee_management.serviceImpl;

import com.example.employee_management.dto.DepartmentDto;
import com.example.employee_management.dto.EmployeeDto;
import com.example.employee_management.dto.ProjectDto;
import com.example.employee_management.model.DepartmentModel;
import com.example.employee_management.model.EmployeeModel;
import com.example.employee_management.model.ProjectModel;
import com.example.employee_management.repository.DepartmentRepository;
import com.example.employee_management.repository.EmployeeRepository;
import com.example.employee_management.repository.ProjectRepository;
import com.example.employee_management.service.DepartmentService;
import com.example.employee_management.service.EmployeeService;
import com.example.employee_management.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void saveProject(ProjectDto projectDto) {
        projectRepository.save(projectDto);
    }

    @Override
    public Optional<ProjectModel> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public List<ProjectModel> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public void updateProject(Long id, ProjectDto project) {
        projectRepository.update(id ,project);
    }

    @Override
    public void deleteProjectById(Long id) {
        projectRepository.deleteById(id);
    }
}
