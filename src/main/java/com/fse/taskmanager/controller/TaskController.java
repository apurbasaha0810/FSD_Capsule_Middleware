package com.fse.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fse.taskmanager.model.Task;
import com.fse.taskmanager.service.TaskService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/tasks"})
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public Task create(@RequestBody Task task){
        return taskService.createTask(task);
    }

    @GetMapping(path = {"/{id}"})
    public Task findOne(@PathVariable("id") int id){
        return taskService.findByTaskId(id);
    }

    @PutMapping(path = {"/{id}"})
    public Task update(@PathVariable("id") int id, @RequestBody Task task){
        return taskService.updateTask(task);
    }

    @DeleteMapping(path ={"finish/{id}"})
    public Task finishTask (@PathVariable("id") int id)
    {
        return taskService.finishTask(id);
    }

    @DeleteMapping(path ={"delete/{id}"})
    public Task deleteTask (@PathVariable("id") int id)
    {
        return taskService.deleteTask(id);
    }

    @GetMapping
    public List<Task> findAll(){
        return taskService.getTaskdetails();
    }
}
