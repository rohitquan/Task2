package com.example.employee_management.model;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeProjectRowMapper implements RowMapper<EmployeeProjectModel> {
    @Override
    public EmployeeProjectModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmployeeProjectModel employeeProjectModel =new EmployeeProjectModel();
        employeeProjectModel.setEmployeeId(rs.getLong("employee_id"));
        employeeProjectModel.setProjectId(rs.getLong("project_id"));
        return employeeProjectModel;
    }
}
