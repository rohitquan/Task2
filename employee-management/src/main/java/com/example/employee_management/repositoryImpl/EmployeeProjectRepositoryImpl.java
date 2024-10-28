package com.example.employee_management.repositoryImpl;

import com.example.employee_management.model.EmployeeProjectModel;
import com.example.employee_management.model.EmployeeProjectRowMapper;
import com.example.employee_management.model.EmployeeRowMapper;
import com.example.employee_management.repository.EmployeeProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeProjectRepositoryImpl implements EmployeeProjectRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void assignEmployeeToProject(Long employeeId, Long projectId) {
        String sql = "INSERT INTO employee_projects (employee_id,project_id) VALUES (?,?) ";
        jdbcTemplate.update(sql,employeeId,projectId);
    }

    @Override
    public void removeEmployeeFromProject(Long employeeId, Long projectId) {
        String sql = "DELETE FROM employee_projects WHERE employee_id = ? and project_id = ?";
        jdbcTemplate.update(sql,employeeId,projectId);
    }

    @Override
    public List<EmployeeProjectModel> getProjectsByEmployeeId(Long employeeId) {
        String sql ="SELECT * FROM employee_projects WHERE employee_id = ? ";
        return jdbcTemplate.query(sql,new EmployeeProjectRowMapper(),employeeId);
    }

    @Override
    public List<EmployeeProjectModel> getEmployeesByProjectId(Long projectId) {
        String sql = "SELECT * FROM employee_projects WHERE project_id = ? ";
        return jdbcTemplate.query(sql,new EmployeeProjectRowMapper(),projectId);
    }
}
