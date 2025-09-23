package com.taskManagement.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.taskManagement.model.Task;

@Repository
public class TaskDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void save(Task task) {
        sessionFactory.getCurrentSession().saveOrUpdate(task);
    }

    @Transactional
    public void delete(Task task) {
        sessionFactory.getCurrentSession().delete(task);
    }

    @Transactional(readOnly = true)
    public Task getById(Long id) {
        return sessionFactory.getCurrentSession().get(Task.class, id);
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Task> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Task").list();
    }
}
