package com.example.employee_management.service;

import com.example.employee_management.dto.DepartmentDto;
import com.example.employee_management.dto.EmployeeDto;
import com.example.employee_management.model.DepartmentModel;
import com.example.employee_management.model.EmployeeModel;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    void saveDepartment(DepartmentDto department);
    Optional<DepartmentModel> getDepartmentById(Long id);
    List<DepartmentModel> getAllDepartments();
    void updateDepartment(Long id,DepartmentDto department);
    void deleteDepartmentById(Long id);

}
