package com.fse.taskmanager.service;

import java.util.List;

import com.fse.taskmanager.model.Task;

public interface TaskService {

    Task finishTask(int id);

    List<Task> getTaskdetails();

    Task findByTaskId(int id);

    Task updateTask(Task task);

    Task deleteTask(int id);

    Task createTask(Task task);
}
