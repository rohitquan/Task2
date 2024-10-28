package com.example.employee_management.service;

import com.example.employee_management.dto.EmployeeDto;
import com.example.employee_management.model.EmployeeModel;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    void saveEmployee(EmployeeDto employee);
    Optional<EmployeeModel> getEmployeeById(Long id);
    List<EmployeeModel> getAllEmployees();
    void updateEmployee(Long id,EmployeeDto employee);
    void deleteEmployeeById(Long id);
    List<EmployeeModel> getPaginatedAndSortedEmployees(int page,int size,String sortBy, String sortDir);
    List<EmployeeModel> getEmployeesByDepartmentId(Long departmentId);
}
