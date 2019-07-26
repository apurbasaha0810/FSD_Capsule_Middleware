package com.fse.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fse.taskmanager.model.ParentTask;
import com.fse.taskmanager.model.Task;
import com.fse.taskmanager.service.TaskService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/tasks"})
public class TaskController {

	@Autowired
	private TaskService taskService;

	@PostMapping
	public Task create(@RequestBody Task task) {
		return taskService.createTask(task);
	}

	@GetMapping(path = {"/{id}"})
	public Task findOne(@PathVariable("id") int id) {
		return taskService.findByTaskId(id);
	}

	@PutMapping(path = {"/{id}"})
	public Task update(@PathVariable("id") int id, @RequestBody Task task) {
		return taskService.updateTask(task);
	}

	@DeleteMapping(path ={"finish/{id}"})
	public Task finishTask (@PathVariable("id") int id)	{
		return taskService.finishTask(id);
	}

	@GetMapping()
	public List<Task> findAll() {
		return taskService.getTaskdetails();
	}
	
	@GetMapping(path = {"/getAllParentTasks"})
	public List<ParentTask> getAllParentTasks() {
		return taskService.getAllParentTasks();
	}
}
