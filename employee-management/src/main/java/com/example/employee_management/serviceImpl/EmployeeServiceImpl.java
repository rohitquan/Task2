package com.example.employee_management.serviceImpl;

import com.example.employee_management.dto.EmployeeDto;
import com.example.employee_management.model.EmployeeModel;
import com.example.employee_management.repository.EmployeeRepository;
import com.example.employee_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void saveEmployee(EmployeeDto employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Optional<EmployeeModel> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<EmployeeModel> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void updateEmployee(Long id, EmployeeDto employee) {
        employeeRepository.update(id ,employee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
}
