package org.example.app.repository.impl;

import org.example.app.config.HibernateUtils;
import org.example.app.entity.User;
import org.example.app.repository.UserRepository;
import org.example.app.repository.query.HqlQueries;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl extends AbstractRepository implements UserRepository {
    public void create(User user) {
        try (Session session = openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
        }
    }
    public void update(User user) {
        try (Session session = openSession()) {
            Transaction transaction = session.beginTransaction();

            User existingUser = session.get(User.class, user.getId());

            if (existingUser != null) {

                if (user.getUsername() != null) {
                    existingUser.setUsername(user.getUsername());
                }
                if (user.getEmail() != null) {
                    existingUser.setEmail(user.getEmail());
                }
                if (user.getPassword() != null && !user.getPassword().isEmpty()) {
                    existingUser.setPassword(user.getPassword());
                }
                session.merge(existingUser);
            }
            transaction.commit();
        }
    }

    @Override
    public Optional<User> findById(long id) {
        try (Session session = openSession()) {
            User user = session.get(User.class, id);
            return Optional.ofNullable(user);
        }
    }

    @Override
    public List<User> findAll() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery(HqlQueries.getAllUsers, User.class).list();
        }
    }

    @Override
    public boolean deleteById(long id) {
        try (Session session = openSession()) {
            User user = session.get(User.class, id);
            if(user == null)
                return false;
            Transaction transaction = session.beginTransaction();
            session.remove(user);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
