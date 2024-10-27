package com.example.employee_management.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class DepartmentModel {

    private Long id;
    private String name;
    private String description;

}
