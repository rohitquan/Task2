package com.example.employee_management.serviceImpl;

import com.example.employee_management.dto.DepartmentDto;
import com.example.employee_management.dto.EmployeeDto;
import com.example.employee_management.model.DepartmentModel;
import com.example.employee_management.model.EmployeeModel;
import com.example.employee_management.repository.DepartmentRepository;
import com.example.employee_management.repository.EmployeeRepository;
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
    private DepartmentRepository detailRepository;

    @Override
    public void saveDepartment(DepartmentDto department) {
        detailRepository.save(department);
    }

    @Override
    public Optional<DepartmentModel> getDepartmentById(Long id) {
        return detailRepository.findById(id);
    }

    @Override
    public List<DepartmentModel> getAllDepartments() {
        return detailRepository.findAll();
    }

    @Override
    public void updateDepartment(Long id, DepartmentDto department) {
        detailRepository.update(id ,department);
    }

    @Override
    public void deleteDepartmentById(Long id) {
        detailRepository.deleteById(id);
    }
}
