package com.example.employee_management.serviceImpl;

import com.example.employee_management.dto.EmployeeDto;
import com.example.employee_management.dto.EmployeeProjectDto;
import com.example.employee_management.model.EmployeeProjectModel;
import com.example.employee_management.repository.EmployeeProjectRepository;
import com.example.employee_management.service.EmployeeProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeProjectServiceImpl implements EmployeeProjectService {

    @Autowired
    private EmployeeProjectRepository employeeProjectRepository;

    @Override
    public void assignEmployeeToProject(EmployeeProjectDto employeeProjectDto) {
        employeeProjectRepository.assignEmployeeToProject(employeeProjectDto.getEmployeeId(),employeeProjectDto.getProjectId());
    }

    @Override
    public void removeEmployeeFromProject(EmployeeProjectDto employeeProjectDto) {
        employeeProjectRepository.removeEmployeeFromProject(employeeProjectDto.getEmployeeId(),employeeProjectDto.getProjectId());
    }

    @Override
    public List<EmployeeProjectModel> getProjectsByEmployeeId(Long employeeId) {
        return employeeProjectRepository.getProjectsByEmployeeId(employeeId);
    }

    @Override
    public List<EmployeeProjectModel> getEmployeesByProject(Long projectId) {
        return employeeProjectRepository.getEmployeesByProjectId(projectId);
    }
}
