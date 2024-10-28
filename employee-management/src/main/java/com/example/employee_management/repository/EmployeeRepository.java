package com.example.employee_management.repository;

import com.example.employee_management.dto.EmployeeDto;
import com.example.employee_management.model.EmployeeModel;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    void save(EmployeeDto employeeDto);
    Optional<EmployeeModel> findById(Long id);
    List<EmployeeModel>  findAll();
    void update(Long id ,EmployeeDto employeeDto);
    void deleteById(Long id);

    List<EmployeeModel> findPaginatedAndSortedEmployees(int page,int size,String sortBy,String sortDir);
    List<EmployeeModel> findEmployeesByDepartmentId(Long departmentId);
}
