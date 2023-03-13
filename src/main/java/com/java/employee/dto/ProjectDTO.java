package com.java.employee.dto;

import com.java.employee.Entity.Employee;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ProjectDTO {
    @NotNull
    private int project_id;
    @NotNull
    private String project_name;
    @NotNull
    private String project_report;
}
