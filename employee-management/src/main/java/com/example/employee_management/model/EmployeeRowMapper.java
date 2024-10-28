package com.example.employee_management.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<EmployeeModel> {
    @Override
    public EmployeeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmployeeModel employee =new EmployeeModel();
        employee.setId(rs.getLong("id"));
        employee.setFirstName(rs.getString("first_name"));
        employee.setLastName(rs.getString("last_name"));
        employee.setEmail(rs.getString("email"));
        employee.setDepartmentId(rs.getLong("department_id"));
        return employee;
    }
}
