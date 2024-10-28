package com.example.employee_management.controller;

import com.example.employee_management.dto.EmployeeDto;
import com.example.employee_management.model.EmployeeModel;
import com.example.employee_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public void createEmployee(@RequestBody EmployeeDto employeeDto){
        employeeService.saveEmployee(employeeDto);
    }

    @GetMapping("/{id}")
    public EmployeeModel getEmployee(@PathVariable Long id){
        return employeeService.getEmployeeById(id).orElse(null);
    }

    @GetMapping
    public List<EmployeeModel> getAllEmployee(){
        return  employeeService.getAllEmployees();
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable Long id,@RequestBody EmployeeDto employeeDto){
        employeeService.updateEmployee(id,employeeDto);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id ){
        employeeService.deleteEmployeeById(id);
    }

    @GetMapping("/paginated-sorted")
    public List<EmployeeModel> getpaginatedAndSortedEmployees(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "first_name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir){
     return employeeService.getPaginatedAndSortedEmployees(page, size, sortBy, sortDir);
    }

    @GetMapping("/by-department/{departmentId}")
    public  List<EmployeeModel> getEmployeesByDepartment(@PathVariable Long departmentId) {
        return  employeeService.getEmployeesByDepartmentId(departmentId);
    }

}
