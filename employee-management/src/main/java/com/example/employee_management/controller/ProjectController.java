package com.example.employee_management.controller;

import com.example.employee_management.dto.DepartmentDto;
import com.example.employee_management.dto.EmployeeDto;
import com.example.employee_management.dto.ProjectDto;
import com.example.employee_management.model.DepartmentModel;
import com.example.employee_management.model.EmployeeModel;
import com.example.employee_management.model.ProjectModel;
import com.example.employee_management.service.DepartmentService;
import com.example.employee_management.service.EmployeeService;
import com.example.employee_management.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public void createProject(@RequestBody ProjectDto projectDto){
        projectService.saveProject(projectDto);
    }

    @GetMapping("/{id}")
    public ProjectModel getProject(@PathVariable Long id){
        return projectService.getProjectById(id).orElse(null);
    }

    @GetMapping
    public List<ProjectModel> getAllProjects(){
        return  projectService.getAllProjects();
    }

    @PutMapping("/{id}")
    public void updateProject(@PathVariable Long id,@RequestBody ProjectDto projectDto){
        projectService.updateProject(id,projectDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id ){
        projectService.deleteProjectById(id);
    }
}
