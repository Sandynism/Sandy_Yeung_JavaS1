package com.trilogyed.tasker.dao;

import com.trilogyed.tasker.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskerDaoTest {

    @Autowired
    TaskerDao dao;

    @Before
    public void setUp() throws Exception {
        List<Task> taskList = dao.getAllTasks();
        for (Task t : taskList) {
            dao.deleteTask(t.getId());
        }
    }

    @Test
    public void createGetDeleteTask() {
        Task task = new Task();
        task.setDescription("Do coding bats");
        task.setCreateDate(LocalDate.of(2019, 9, 18));
        task.setDueDate(LocalDate.of(2019, 9, 20));
        task.setCategory("Homework");
        dao.createTask(task);

        Task task1 = dao.getTask(task.getId());
        assertEquals(task, task1);

        dao.deleteTask(task.getId());
        task1 = dao.getTask(task.getId());
        assertNull(task1);
    }


    @Test
    public void getAllTasks() {
        Task task = new Task();
        task.setDescription("Do coding bats");
        task.setCreateDate(LocalDate.of(2019, 9, 18));
        task.setDueDate(LocalDate.of(2019, 9, 20));
        task.setCategory("Homework");
        dao.createTask(task);

        task = new Task();
        task.setDescription("Do laundry");
        task.setCreateDate(LocalDate.of(2019, 9, 22));
        task.setDueDate(LocalDate.of(2019, 9, 22));
        task.setCategory("Chores");
        dao.createTask(task);

        List<Task> taskList = dao.getAllTasks();
        assertEquals(taskList.size(), 2);
    }

    @Test
    public void getTasksByCategory() {
        Task task = new Task();
        task.setDescription("Do coding bats");
        task.setCreateDate(LocalDate.of(2019, 9, 18));
        task.setDueDate(LocalDate.of(2019, 9, 20));
        task.setCategory("Homework");
        dao.createTask(task);

        task = new Task();
        task.setDescription("Do laundry");
        task.setCreateDate(LocalDate.of(2019, 9, 22));
        task.setDueDate(LocalDate.of(2019, 9, 22));
        task.setCategory("Chores");
        dao.createTask(task);

        List<Task> taskList = dao.getTasksByCategory("Homework");
        assertEquals(taskList.size(), 1);

        taskList = dao.getTasksByCategory("Chores");
        assertEquals(taskList.size(), 1);

        taskList = dao.getTasksByCategory("Fitness");
        assertEquals(taskList.size(), 0);
    }

    @Test
    public void updateTask() {
        Task updatedTask = new Task();
        updatedTask.setDescription("Do coding bats");
        updatedTask.setCreateDate(LocalDate.of(2019, 9, 18));
        updatedTask.setDueDate(LocalDate.of(2019, 9, 20));
        updatedTask.setCategory("Homework");
        dao.createTask(updatedTask);

        updatedTask.setDescription("Do coding bats and watch youtube tutorials");

        dao.updateTask(updatedTask);

        Task taskUpdated = dao.getTask(updatedTask.getId());
        assertEquals(updatedTask, taskUpdated);
    }

}