package com.example.employee_management.controller;

import com.example.employee_management.dto.EmployeeProjectDto;
import com.example.employee_management.model.EmployeeProjectModel;
import com.example.employee_management.service.EmployeeProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee-projects")
public class EmployeeProjectController {

    @Autowired
    private EmployeeProjectService employeeProjectService;

    @PostMapping("/assign")
    public String assignEmployeeToProject(@RequestBody EmployeeProjectDto employeeProjectDto){
        employeeProjectService.assignEmployeeToProject(employeeProjectDto);
        return "Employee assigned to project successfully";
    }

    @DeleteMapping("/remove")
    public String removeEmployeeFromProject(@RequestBody EmployeeProjectDto employeeProjectDto){
        employeeProjectService.removeEmployeeFromProject(employeeProjectDto);
        return "Employee removed from project successfully";
    }

    @GetMapping("/projects/{employeeId}")
    public List<EmployeeProjectModel> getProjectsByEmployeeId(@PathVariable Long employeeId){
        return employeeProjectService.getProjectsByEmployeeId(employeeId);
    }

    @GetMapping("/employees/{projectId}")
    public List<EmployeeProjectModel> getEmployeesByProjectId(@PathVariable Long projectId){
        return employeeProjectService.getEmployeesByProject(projectId);
    }

}
