package com.java.employee.Controller;

import com.java.employee.Entity.Project;
import com.java.employee.Service.ProjectService;
import com.java.employee.dto.ProjectDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@Valid @RequestBody ProjectDTO projectDTO){
      Project project = projectService.create(projectDTO);
      return ResponseEntity.status(HttpStatus.CREATED).body(project);
    }

    @GetMapping(value = "/{project_id}")
    public ResponseEntity<?> getById(@PathVariable("project_id") Integer id){
        Optional<Project> project=projectService.getById(id);
        if (project.isPresent()){
            projectService.getById(id);
            return ResponseEntity.status(HttpStatus.FOUND).body(project);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body("Please enter the valid ID");
    }
    @GetMapping(value = "/list")
    public ResponseEntity<?> getAll(){
        List<Project> projectList = projectService.getAll();
        return ResponseEntity.status(HttpStatus.FOUND).body(projectList);
    }

    @PutMapping(value = "/update/{project_id}")
    public ResponseEntity<?> updateId(@Valid @RequestBody Project project,@PathVariable("project_id")Integer project_id){
       Optional<Project> project1 =projectService.getById(project_id);
       if (!project1.isEmpty()){
           projectService.update(project,project_id);
           return ResponseEntity.status(HttpStatus.ACCEPTED).body("Project details updated successfully");
       }
       return ResponseEntity.status(HttpStatus.ACCEPTED).body("Please enter a valid ID");
    }
}
