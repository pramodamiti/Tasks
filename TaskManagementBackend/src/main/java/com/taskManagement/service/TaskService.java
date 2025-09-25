package com.taskManagement.service;

import java.util.List;

import com.taskManagement.dao.TaskDao;
import com.taskManagement.model.Task;


public class TaskService {

	private TaskDao taskDao;

	public void setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
	}

	public void addTask(Task task) {
		taskDao.save(task);
	}

	public void updateTask(Task task) {
		taskDao.save(task);
	}

	public void deleteTask(Task task) {
		taskDao.delete(task);
	}

	public Task getTask(Long id) {
		return taskDao.getById(id);
	}

	public List<Task> getAllTasks() {
		return taskDao.getAll();
	}
}
