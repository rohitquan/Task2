package com.example.employee_management.repositoryImpl;

import com.example.employee_management.dto.EmployeeDto;
import com.example.employee_management.model.EmployeeModel;
import com.example.employee_management.model.EmployeeRowMapper;
import com.example.employee_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(EmployeeDto employee) {
        String sql="INSERT INTO employees (first_name,last_name,email,department_id) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql,employee.getFirstName(),employee.getLastName(),employee.getEmail(),employee.getDepartmentId());
    }

    @Override
    public Optional<EmployeeModel> findById(Long id) {
        String sql="SELECT * FROM employees WHERE id = ?";
        return jdbcTemplate.query(sql,new EmployeeRowMapper(),id).stream().findFirst();
//        return jdbcTemplate.query(sql, new Object[]{id}, new EmployeeRowMapper()).stream().findFirst();
    }

    @Override
    public List<EmployeeModel> findAll() {
        String sql = "SELECT * FROM employees";
        return jdbcTemplate.query(sql,new EmployeeRowMapper());
    }

    @Override
    public void update(Long id,EmployeeDto employee) {
        String sql ="UPDATE employees SET first_name = ?,last_name = ?,email = ?, department_id = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentId(),
                id);
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM employees WHERE id = ?";
    jdbcTemplate.update(sql,id);
    }
}
