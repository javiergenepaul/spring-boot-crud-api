package com.crudpractice.crud.controller;

import com.crudpractice.crud.model.Project;
import com.crudpractice.crud.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Project> getAll() {
        return projectService.getAll();
    }

    @PostMapping
    public Project create(@RequestBody Project project) {
        return projectService.create(project);
    }
}
