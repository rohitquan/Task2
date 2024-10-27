package com.example.employee_management.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentRowMapper implements RowMapper<DepartmentModel> {
    @Override
    public DepartmentModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        DepartmentModel department =new DepartmentModel();
        department.setId(rs.getLong("id"));
        department.setName(rs.getString("name"));
        department.setDescription(rs.getString("description"));
        return department;
    }
}
