package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdserverClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskerServiceLayer {

    TaskerDao dao;
    AdserverClient adserverClient;

    @Autowired
    public TaskerServiceLayer(TaskerDao dao, AdserverClient adserverClient) {
        this.dao = dao;
        this.adserverClient = adserverClient;
    }

    public TaskViewModel fetchTask(int id) {
        Task task = dao.getTask(id);
        if (task == null) {
            return null;
        } else {
            String ad = adserverClient.getAd();
            TaskViewModel tvm = new TaskViewModel();
            tvm.setId(task.getId());
            tvm.setDescription(task.getDescription());
            tvm.setCreateDate(task.getCreateDate());
            tvm.setDueDate(task.getDueDate());
            tvm.setCategory(task.getCategory());
            tvm.setAdvertisement(ad);

            return tvm;
        }
//        Task task = dao.getTask(id);
//        String ad = adserverClient.getAd();
//
//        TaskViewModel tvm = new TaskViewModel();
//
//        tvm.setId(task.getId());
//        tvm.setDescription(task.getDescription());
//        tvm.setCreateDate(task.getCreateDate());
//        tvm.setDueDate(task.getDueDate());
//        tvm.setCategory(task.getCategory());
//        tvm.setAdvertisement(ad);
//
//        // TODO - get ad from Adserver and put in tvm
//
//        return tvm;
    }

    public List<TaskViewModel> fetchAllTasks() {
        List<Task> taskList = dao.getAllTasks();
        List<TaskViewModel> tvmList = new ArrayList<>();

        for(Task t: taskList) {
            tvmList.add(buildTaskViewModel(t));
        }
        return tvmList;
    }

    public List<TaskViewModel> fetchTasksByCategory(String category) {
        List<Task> taskList = dao.getTasksByCategory(category);
        List<TaskViewModel> tvmList = new ArrayList<>();

        for(Task t: taskList) {
            tvmList.add(buildTaskViewModel(t));
        }
        return tvmList;
    }

    @Transactional
    public TaskViewModel newTask(TaskViewModel taskViewModel) {

        Task task = new Task();
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        task = dao.createTask(task);

        taskViewModel.setId(task.getId());
        taskViewModel.setDescription(task.getDescription());
        taskViewModel.setCreateDate(task.getCreateDate());
        taskViewModel.setDueDate(task.getDueDate());
        taskViewModel.setCategory(task.getCategory());

        String ad = adserverClient.getAd();
        taskViewModel.setAdvertisement(ad);

        // TODO - get ad from Adserver and put in taskViewModel
        return taskViewModel;
    }

    public void deleteTask(int id) {
        dao.deleteTask(id);
    }

    public void updateTask(TaskViewModel taskViewModel) {
        Task task = new Task();
        task.setId(taskViewModel.getId());
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());
        dao.updateTask(task);
    }

    private TaskViewModel buildTaskViewModel(Task task) {
        TaskViewModel tvm = new TaskViewModel();
        tvm.setId(task.getId());
        tvm.setDescription(task.getDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());
//        tvm.setAdvertisement(ad.getAd());
        String ad = adserverClient.getAd();
        tvm.setAdvertisement(ad);

        return tvm;
    }

}
