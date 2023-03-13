package com.java.employee.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "employee")
public class Employee {
    @Id
    private int emp_id;
    @NotEmpty
    private String emp_name;
    @Email(message = "Please enter a valid email!!!")
    private String email;
    private String company;
    @OneToMany(targetEntity = Project.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "emp-id", referencedColumnName = "emp_id")
    private List<Project> project;
}