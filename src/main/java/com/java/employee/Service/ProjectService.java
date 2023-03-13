package com.java.employee.Service;

import com.java.employee.Entity.Project;
import com.java.employee.dto.ProjectDTO;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    Project create(ProjectDTO project);
    Optional<Project> getById(Integer id);
    List<Project> getAll();
    Project update(Project project,Integer project_id);
}
