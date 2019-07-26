package com.fse.taskmanager.service;

import java.util.List;

import com.fse.taskmanager.model.ParentTask;
import com.fse.taskmanager.model.Task;

public interface TaskService {

	public Task finishTask(int id);

	public List<Task> getTaskdetails();

	public Task findByTaskId(int id);

	public Task updateTask(Task task);

	public Task createTask(Task task);

	public List<ParentTask> getAllParentTasks();
}
