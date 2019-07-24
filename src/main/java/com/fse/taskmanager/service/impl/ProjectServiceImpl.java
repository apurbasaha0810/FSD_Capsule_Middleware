package com.fse.taskmanager.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fse.taskmanager.model.Project;
import com.fse.taskmanager.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{

	Logger logger= LoggerFactory.getLogger(ProjectServiceImpl.class);

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Project addProject(Project project) {
		Project projectDetails=null;
		try{
			logger.info("Project Details ::: "+project.getProject_name()+" ::: "+project.getPriority()+" ::: "+project.getStart_date()+" ::: "+project.getManager_id());
			projectDetails = manager.createNamedQuery("callAddProject", Project.class)
					.setParameter(1, project.getProject_name())
					.setParameter(2, project.getStart_date())
					.setParameter(3, project.getEnd_date())
					.setParameter(4, project.getPriority())
					.setParameter(5, project.getManager_id())
					.getSingleResult();
			return projectDetails;
		}
		catch(Exception ex){
			logger.error("Issue while adding project in ProjectServiceImpl: "+ex.getMessage());
		}
		return projectDetails;
	}

	@Override
	public List<Project> getAllProjectDetails(String sortBy) {
		List<Project> projectDetails=null;
		try{
			logger.info("sortBy:: "+sortBy);
			projectDetails = manager.createNamedQuery("callGetAllProjectDetails", Project.class)
					.setParameter(1, sortBy)
					.getResultList();
			logger.info("projectDetails size::: "+projectDetails.size());
			return projectDetails;
		}
		catch(Exception ex){
			logger.error("Issue while retrieveing all project details in ProjectServiceImpl: "+ex.getMessage());
		}
		return projectDetails;
	}
	
	@Override
	public Project updateProjectStatus(long projectId, String status) {
		Project projectDetails=null;
		try{
			logger.info("Update Project Details ::: "+projectId+" ::: "+status);
			projectDetails = manager.createNamedQuery("callUpdateProjectStatus", Project.class)
					.setParameter(1, projectId)
					.setParameter(2, status)
					.getSingleResult();
			return projectDetails;
		}
		catch(Exception ex){
			logger.error("Issue while updating project status in ProjectServiceImpl: "+ex.getMessage());
		}
		return projectDetails;
	}
}