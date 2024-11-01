package com.example.employee_management.controller;

import com.example.employee_management.dto.DepartmentDto;
import com.example.employee_management.dto.EmployeeDto;
import com.example.employee_management.model.DepartmentModel;
import com.example.employee_management.model.EmployeeModel;
import com.example.employee_management.service.DepartmentService;
import com.example.employee_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deparments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public void createDepartment(@RequestBody DepartmentDto departmentDto){
        departmentService.saveDepartment(departmentDto);
    }

    @GetMapping("/{id}")
    public DepartmentModel getDepartment(@PathVariable Long id){
        return departmentService.getDepartmentById(id).orElse(null);
    }

    @GetMapping
    public List<DepartmentModel> getAllDepartments(){
        return  departmentService.getAllDepartments();
    }

    @PutMapping("/{id}")
    public void updateDepartment(@PathVariable Long id,@RequestBody DepartmentDto departmentDto){
        departmentService.updateDepartment(id,departmentDto);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id ){

        departmentService.deleteDepartmentById(id);
    }
}
