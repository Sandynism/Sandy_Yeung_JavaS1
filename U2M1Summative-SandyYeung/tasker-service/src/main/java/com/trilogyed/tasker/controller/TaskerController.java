package com.trilogyed.tasker.controller;

import com.trilogyed.tasker.exception.NotFoundException;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RefreshScope
public class TaskerController {

    @Autowired
    TaskerServiceLayer service;

    public TaskerController(TaskerServiceLayer service) {
        this.service = service;
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public TaskViewModel createTask(@RequestBody @Valid TaskViewModel task) {
        TaskViewModel existing = service.fetchTask(task.getId());
        if (existing != null)
            throw new IllegalArgumentException("Task " + task.getId() + " already exists!");
        service.newTask(task);
        return task;
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateTask(@RequestBody @Valid TaskViewModel task) {
        TaskViewModel notExist = service.fetchTask(task.getId());
        if (notExist == null)
            throw new IllegalArgumentException("Task " + task.getId() + " does not exist.");
        service.updateTask(task);
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public TaskViewModel getTaskById(@PathVariable int id) {
        TaskViewModel task = service.fetchTask(id);
        if (task == null)
            throw new NotFoundException("Task could not be retrieved for id " + id);
        return task;
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TaskViewModel> getAllTasks() {
        return service.fetchAllTasks();
    }

    @RequestMapping(value = "/tasks/category/{category}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TaskViewModel> getTasksByCategory(@PathVariable String category) {
        List<TaskViewModel> tasksList = service.fetchTasksByCategory(category);
        if (tasksList != null && tasksList.size() == 0)
            throw new NotFoundException("Tasks by " + category + " could not be found.");
        return tasksList;
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable int id) {
        service.deleteTask(id);
    }
}
