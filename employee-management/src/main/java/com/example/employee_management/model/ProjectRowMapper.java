package com.example.employee_management.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectRowMapper implements RowMapper<ProjectModel> {
    @Override
    public ProjectModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProjectModel project =new ProjectModel();
        project.setId(rs.getLong("id"));
        project.setName(rs.getString("name"));
        project.setDescription(rs.getString("description"));
        return project;
    }
}
