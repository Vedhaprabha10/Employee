package com.java.employee.Service;

import com.java.employee.Entity.Project;
import com.java.employee.Repository.ProjectRepository;
import com.java.employee.dto.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    ProjectRepository projectRepo;
    @Override
    public Project create(ProjectDTO project) {
       Project project1 = new Project();
       project1.setProject_id(project.getProject_id());
       project1.setProject_name(project.getProject_name());
       project1.setProject_report(project.getProject_report());
       return projectRepo.save(project1);
    }

    @Override
    public Optional<Project> getById(Integer id) {
        return projectRepo.findById(id);
    }

    @Override
    public List<Project> getAll() {
        return projectRepo.findAll();
    }

    @Override
    public Project update(Project project,Integer project_id) {
        project.setProject_id(project_id);
        return projectRepo.save(project);
    }
}
