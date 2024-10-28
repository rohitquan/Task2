package com.example.employee_management.repositoryImpl;

import com.example.employee_management.dto.EmployeeDto;
import com.example.employee_management.model.EmployeeModel;
import com.example.employee_management.model.EmployeeRowMapper;
import com.example.employee_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(EmployeeDto employeeDto) {
        String sql="INSERT INTO employee_data (first_name,last_name,email,department_id) VALUES (?,?,?,?)";
        try {
            jdbcTemplate.update(sql,
                    employeeDto.getFirstName(),
                    employeeDto.getLastName(),
                    employeeDto.getEmail(),
                    employeeDto.getDepartmentId());
        }catch (DataAccessException e){
            System.err.println("Error saving Employee" + e.getMessage());
        }
    }

    @Override
    public Optional<EmployeeModel> findById(Long id) {
        String sql="SELECT * FROM employee_data WHERE id = ?";
        return jdbcTemplate.query(sql,new EmployeeRowMapper(),id).stream().findFirst();
//        return jdbcTemplate.query(sql, new Object[]{id}, new EmployeeRowMapper()).stream().findFirst();
    }

    @Override
    public List<EmployeeModel> findAll() {
        String sql = "SELECT * FROM employee_data";
        return jdbcTemplate.query(sql,new EmployeeRowMapper());
    }

    @Override
    public void update(Long id,EmployeeDto employee) {
        String sql ="UPDATE employee_data SET first_name = ?,last_name = ?,email = ?, department_id = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentId(),
                id);
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM employee_data WHERE id = ?";
    jdbcTemplate.update(sql,id);
    }

    @Override
    public List<EmployeeModel> findPaginatedAndSortedEmployees(int page, int size, String sortBy, String sortDir) {
        String sortOrder =sortDir.equalsIgnoreCase("asc")?"ASC":"DESC";
        String sql ="SELECT * FROM employee_data ORDER BY " + sortBy + " " + sortOrder
                + ", last_name "+ sortOrder +" LIMIT ? OFFSET ?";
        int offset = (page - 1 ) * size;
        return  jdbcTemplate.query(sql, (PreparedStatement ps) ->{
            ps.setInt(1,size);
            ps.setInt(2,offset);
        }, new EmployeeRowMapper());
    }

    @Override
    public List<EmployeeModel> findEmployeesByDepartmentId(Long departmentId) {
        String sql = "SELECT * FROM employee_data WHERE department_id = ? ";
        return jdbcTemplate.query(sql,ps->ps.setLong(1,departmentId),new EmployeeRowMapper());
    }
}
