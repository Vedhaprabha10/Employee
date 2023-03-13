package com.java.employee.dto;

import com.java.employee.Entity.Project;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class EmployeeDTO {
    @NotNull
    private int emp_id;
    @NotEmpty
    private String emp_name;
    @Email
    private String email;
    private String company;
    @OneToMany(targetEntity = ProjectDTO.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "emp-id", referencedColumnName = "emp_id")
    private List<Project> project;
}
