package com.java.employee.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "project")
public class Project {
    @Id
    private int project_id;

    @NotNull
    private String project_name;
    @NotNull
    private String project_report;

}
