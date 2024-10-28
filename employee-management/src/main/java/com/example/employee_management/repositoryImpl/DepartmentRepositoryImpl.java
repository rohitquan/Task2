package com.example.employee_management.repositoryImpl;

import com.example.employee_management.dto.DepartmentDto;
import com.example.employee_management.dto.EmployeeDto;
import com.example.employee_management.model.DepartmentModel;
import com.example.employee_management.model.DepartmentRowMapper;
import com.example.employee_management.model.EmployeeModel;
import com.example.employee_management.model.EmployeeRowMapper;
import com.example.employee_management.repository.DepartmentRepository;
import com.example.employee_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(DepartmentDto department) {
        String sql="INSERT INTO department_data (name,description) VALUES (?,?)";
        jdbcTemplate.update(sql,department.getName(),department.getDescription());
    }


    @Override
    public Optional<DepartmentModel> findById(Long id) {
        String sql="SELECT * FROM department_data WHERE id = ?";
        return jdbcTemplate.query(sql,new DepartmentRowMapper(),id).stream().findFirst();
//        return jdbcTemplate.query(sql, new Object[]{id}, new DepartmentRowMapper()).stream().findFirst();
    }

    @Override
    public List<DepartmentModel> findAll() {
        String sql = "SELECT * FROM department_data";
        return jdbcTemplate.query(sql,new DepartmentRowMapper());
    }

    @Override
    public void update(Long id,DepartmentDto department) {
        String sql ="UPDATE department_data SET name = ?,description = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                department.getName(),
                department.getDescription(),
                id);
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM department_data WHERE id = ?";
    jdbcTemplate.update(sql,id);
    }
}
