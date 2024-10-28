package com.example.employee_management.repositoryImpl;

import com.example.employee_management.dto.DepartmentDto;
import com.example.employee_management.dto.EmployeeDto;
import com.example.employee_management.dto.ProjectDto;
import com.example.employee_management.model.*;
import com.example.employee_management.repository.DepartmentRepository;
import com.example.employee_management.repository.EmployeeRepository;
import com.example.employee_management.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(ProjectDto project) {
        String sql="INSERT INTO project_data (name,description) VALUES (?,?)";
        jdbcTemplate.update(sql,project.getName(),project.getDescription());
    }

    @Override
    public Optional<ProjectModel> findById(Long id) {
        String sql="SELECT * FROM project_data WHERE id = ?";
        return jdbcTemplate.query(sql,new ProjectRowMapper(),id).stream().findFirst();
//        return jdbcTemplate.query(sql, new Object[]{id}, new DepartmentRowMapper()).stream().findFirst();
    }

    @Override
    public List<ProjectModel> findAll() {
        String sql = "SELECT * FROM project_data";
        return jdbcTemplate.query(sql,new ProjectRowMapper());
    }

    @Override
    public void update(Long id,ProjectDto project) {
        String sql ="UPDATE project_data SET name = ?,description = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                project.getName(),
                project.getDescription(),
                id);
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM project_data WHERE id = ?";
    jdbcTemplate.update(sql,id);
    }
}
