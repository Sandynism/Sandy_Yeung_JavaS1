package com.trilogyed.tasker.dao;

import com.trilogyed.tasker.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TaskerDaoJdbcTemplateImpl implements TaskerDao {

    public static final String INSERT_TASK_SQL =
            "insert into task (task_description, create_date, due_date, category) values (?, ?, ?, ?)";
    public static final String SELECT_TASK_BY_ID_SQL =
            "select * from task where task_id = ?";
    public static final String SELECT_ALL_TASKS_SQL =
            "select * from task";
    public static final String SELECT_TASKS_BY_CATEGORY_SQL =
            "select * from task where category = ?";
    public static final String UPDATE_TASK_SQL =
            "update task set task_description = ?, create_date = ?, due_date = ?, category = ? where task_id = ?";
    public static final String DELETE_TASK_SQL =
            "delete from task where task_id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public TaskerDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Task mapRowToTask(ResultSet rs, int rowNum) throws SQLException {
        Task task = new Task();
        task.setId(rs.getInt("task_id"));
        task.setDescription(rs.getString("task_description"));
        task.setCreateDate(rs.getDate("create_date").toLocalDate());
        task.setDueDate(rs.getDate("due_date").toLocalDate());
        task.setCategory(rs.getString("category"));

        return task;
    }

    @Override
    public Task createTask(Task task) {
        return null;
    }

    @Override
    public Task getTask(int id) {
        return null;
    }

    @Override
    public List<Task> getAllTasks() {
        return null;
    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        return null;
    }

    @Override
    public void updateTask(Task task) {

    }

    @Override
    public void deleteTask(int id) {

    }
}