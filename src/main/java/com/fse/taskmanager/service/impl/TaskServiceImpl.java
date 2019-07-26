package com.fse.taskmanager.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fse.taskmanager.model.ParentTask;
import com.fse.taskmanager.model.Task;
import com.fse.taskmanager.service.TaskService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

	Logger logger= LoggerFactory.getLogger(TaskServiceImpl.class);

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Task finishTask(int id) {
		Task finishTask=null;
		try{
			finishTask = manager.createNamedQuery("callFinishTask", Task.class).setParameter(1, id).getSingleResult();
			return finishTask;}
		catch(Exception ex){
			logger.error("Issue in TaskServiceImpl: "+ex.getMessage());
		}
		return finishTask;
	}

	@Override
	public List<Task> getTaskdetails() {
		List<Task> taskDetails=null;
		try{
			taskDetails = manager.createNamedQuery("callGetAllTasks", Task.class).getResultList();
			return taskDetails;
		}
		catch(Exception ex){
			logger.error("Issue while retrieveing all Task details in TaskServiceImpl: "+ex.getMessage());
		}
		return taskDetails;
	}

	@Override
	public Task findByTaskId(int id) {
		Task taskDetails=null;
		try{
			taskDetails = manager.createNamedQuery("callSpecificTask", Task.class).setParameter(1, id).getSingleResult();
			return taskDetails;}

		catch(Exception ex){
			logger.error("Issue in TaskServiceImpl: "+ex.getMessage());
		}
		return taskDetails;
	}

	@Override
	public Task updateTask(Task task) {
		Task taskDetails=null;
		try{ taskDetails = manager.createNamedQuery("callUpdateSpecificTask", Task.class).setParameter(1, task.getTask_id())
				.setParameter(2, task.getTask())
				.setParameter(3, task.getStart_date())
				.setParameter(4, task.getEnd_date())
				.setParameter(5, task.getPriority())
				.setParameter(6, task.getParent_task())
				.getSingleResult();
		return taskDetails;}
		catch(Exception ex){
			logger.error("Issue while updating Task details in TaskServiceImpl: "+ex.getMessage());
		}
		return taskDetails;
	}

	@Override
	public Task createTask(Task task) {
		Task taskDetails=null;
		try{
			logger.debug("Task Details ::: "+task.getPriority() +" ::: "+ task.getStart_date() +" ::: "+ task.getEnd_date());
			taskDetails = manager.createNamedQuery("callAddTask", Task.class)
					.setParameter(1, task.getTask())
					.setParameter(2, task.getStart_date())
					.setParameter(3, task.getEnd_date())
					.setParameter(4, task.getPriority())
					.setParameter(5, task.getProject_id())
					.setParameter(6, task.getParent_id())
					.setParameter(7, task.getUser_id())
					.getSingleResult();
			return taskDetails;
		}
		catch(Exception ex){
			logger.error("Issue while creating Task in TaskServiceImpl: "+ex.getMessage());
		}
		return taskDetails;
	}

	@Override
	public List<ParentTask> getAllParentTasks(){
		List<ParentTask> parentTaskList=null;
		try{
			parentTaskList = manager.createNamedQuery("callGetAllParentTasks", ParentTask.class).getResultList();
			return parentTaskList;
		}
		catch(Exception ex){
			logger.error("Issue while retrieveing all Parent Tasks in TaskServiceImpl: "+ex.getMessage());
		}
		return parentTaskList;
	}
}
