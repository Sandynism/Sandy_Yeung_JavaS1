package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdserverClient;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

public class TaskerServiceLayerTest {

    TaskerDao taskerDao;
    AdserverClient adserverClient;
    TaskerServiceLayer taskerServiceLayer;

    @Before
    public void setUp() throws Exception {
        setUpTaskerDaoMocks();
        setUpAdserverClientMocks();
        taskerServiceLayer = new TaskerServiceLayer(taskerDao, adserverClient);
    }

    private void setUpTaskerDaoMocks() {
        taskerDao = mock(TaskerDaoJdbcTemplateImpl.class);

        Task task = new Task();
        task.setId(1);
        task.setDescription("Do coding bats");
        task.setCreateDate(LocalDate.of(2019, 9, 18));
        task.setDueDate(LocalDate.of(2019, 9, 20));
        task.setCategory("Homework");

        Task task1 = new Task();
        task1.setDescription("Do coding bats");
        task1.setCreateDate(LocalDate.of(2019, 9, 18));
        task1.setDueDate(LocalDate.of(2019, 9, 20));
        task1.setCategory("Homework");

        List<Task> taskList = new ArrayList<>();
        taskList.add(task);

        Task updatedTask = new Task();
        updatedTask.setId(2);
        updatedTask.setDescription("Do coding bats and watch youtube tutorials");
        updatedTask.setCreateDate(LocalDate.of(2019, 9, 18));
        updatedTask.setDueDate(LocalDate.of(2019, 9, 20));
        updatedTask.setCategory("Homework");

        Task task3 = new Task();
        task3.setId(3);
        task3.setDescription("Do laundry");
        task3.setCreateDate(LocalDate.of(2019, 9, 22));
        task3.setDueDate(LocalDate.of(2019, 9, 22));
        task3.setCategory("Chores");

        taskList.add(task3);

        List<Task> categoryList = new ArrayList<>();
        categoryList.add(task);

        doReturn(task).when(taskerDao).createTask(task1);
        doReturn(task).when(taskerDao).getTask(1);
        doReturn(taskList).when(taskerDao).getAllTasks();
        doNothing().when(taskerDao).updateTask(updatedTask);
        doReturn(updatedTask).when(taskerDao).getTask(2);
        doNothing().when(taskerDao).deleteTask(3);
        doReturn(null).when(taskerDao).getTask(3);
        doReturn(categoryList).when(taskerDao).getTasksByCategory("Homework");
    }

    private void setUpAdserverClientMocks() {
        adserverClient = mock(AdserverClient.class);

        doReturn("Super Sale on summer clothes!").when(adserverClient).getAd();
    }

    @Test
    public void newFetchUpdateDeleteTask() {
        TaskViewModel task = new TaskViewModel();
        task.setDescription("Do coding bats");
        task.setCreateDate(LocalDate.of(2019, 9, 18));
        task.setDueDate(LocalDate.of(2019, 9, 20));
        task.setCategory("Homework");
        task.setAdvertisement(adserverClient.getAd());

        task = taskerServiceLayer.newTask(task);
        TaskViewModel fromService = taskerServiceLayer.fetchTask(task.getId());
        assertEquals(task, fromService);

        task = new TaskViewModel();

        Task updatedTask = new Task();
        updatedTask.setId(2);
        updatedTask.setDescription("Do coding bats and watch youtube tutorials");
        updatedTask.setCreateDate(LocalDate.of(2019, 9, 18));
        updatedTask.setDueDate(LocalDate.of(2019, 9, 20));
        updatedTask.setCategory("Homework");

        task.setId(updatedTask.getId());
        task.setDescription(updatedTask.getDescription());
        task.setCreateDate(updatedTask.getCreateDate());
        task.setDueDate(updatedTask.getDueDate());
        task.setCategory(updatedTask.getCategory());

        taskerServiceLayer.updateTask(task);

        fromService = taskerServiceLayer.fetchTask(2);

        Task task3 = new Task();
        task3.setId(fromService.getId());
        task3.setDescription(fromService.getDescription());
        task3.setCreateDate(fromService.getCreateDate());
        task3.setDueDate(fromService.getDueDate());
        task3.setCategory(fromService.getCategory());

        assertEquals(updatedTask, task3);

        taskerServiceLayer.deleteTask(3);
        fromService = taskerServiceLayer.fetchTask(3);
        assertNull(fromService);
    }


    @Test
    public void fetchTasksByCategory() {
        TaskViewModel task = new TaskViewModel();
        task.setDescription("Do coding bats");
        task.setCreateDate(LocalDate.of(2019, 9, 18));
        task.setDueDate(LocalDate.of(2019, 9, 20));
        task.setCategory("Homework");
        task.setAdvertisement(adserverClient.getAd());

        task = taskerServiceLayer.newTask(task);
        List<TaskViewModel> fromService = taskerServiceLayer.fetchTasksByCategory("Homework");
        assertEquals(fromService.size(), 1);

        fromService = taskerServiceLayer.fetchTasksByCategory("Groceries");
        assertEquals(fromService.size(), 0);
    }

}