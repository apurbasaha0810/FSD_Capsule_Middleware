package com.fse.taskmanager.service;

import java.util.List;

import com.fse.taskmanager.model.Project;

public interface ProjectService {
	
	public List<Project> getAllProjectDetails(String sortBy);
	
	public Project addProject(Project project);
	
	public Project updateProjectStatus(long projectId, String status);
}
