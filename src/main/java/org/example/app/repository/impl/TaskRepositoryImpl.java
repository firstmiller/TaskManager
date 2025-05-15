package org.example.app.repository.impl;

import org.example.app.config.HibernateUtils;
import org.example.app.entity.Task;
import org.example.app.repository.TaskRepository;
import org.example.app.repository.query.HqlQueries;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class TaskRepositoryImpl extends AbstractRepository implements TaskRepository {
    @Override
    public void create(Task task) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(task);
            transaction.commit();
        }
    }

    @Override
    public void update(Task task) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            transaction.commit();
        }
    }

    @Override
    public Optional<Task> findById(long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(Task.class, id));
        }
    }

    @Override
    public List<Task> getTasksByUserId(long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery(HqlQueries.GET_TASKS_BY_USER_ID, Task.class)
                    .setParameter("userId", id)
                    .getResultList();

        }
    }

    @Override
    public List<Task> getTasksByListId(long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery(HqlQueries.GET_TASKS_BY_LIST_ID, Task.class)
                    .setParameter("listId", id)
                    .getResultList();
        }
    }

    @Override
    public boolean delete(Task task) {
        return false;
    }
}
