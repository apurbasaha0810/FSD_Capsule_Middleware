package com.fse.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fse.taskmanager.model.Project;
import com.fse.taskmanager.service.ProjectService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/projects"})
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;

	@PostMapping
	public Project addProject(@RequestBody Project project){
		return projectService.addProject(project);
	}
	
	@GetMapping(path ={"/{sortBy}"})
	public List<Project> getAllProjectDetails(@PathVariable("sortBy") String sortBy) {
		return projectService.getAllProjectDetails(sortBy);
	}
	
	@GetMapping("/suspendProject/{projectId}")
    public Project suspendProject(@PathVariable("projectId") long projectId) {
        return projectService.updateProjectStatus(projectId, "SUSPENDED");
    }

    @GetMapping("/activateProject/{projectId}")
    public Project activateProject(@PathVariable("projectId") long projectId) {
        return projectService.updateProjectStatus(projectId, "ACTIVE");
    }
}
