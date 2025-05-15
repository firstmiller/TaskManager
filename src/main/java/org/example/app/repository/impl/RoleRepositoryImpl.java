package org.example.app.repository.impl;

import org.example.app.config.HibernateUtils;
import org.example.app.entity.Role;
import org.example.app.repository.RoleRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class RoleRepositoryImpl extends AbstractRepository implements RoleRepository {

    public void create(Role role) {
        try (Session session = openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(role);
            transaction.commit();
        }
    }
    public void update(Role role) {
        try (Session session = openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(role);
            transaction.commit();
        }
    }

    @Override
    public Optional<Role> findById(long id) {
        try (Session session = openSession()) {
            Role role = session.get(Role.class, id);
            return Optional.ofNullable(role);
        }
    }

    @Override
    public List<Role> findAll() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("from Role", Role.class).list();
        }
    }

    @Override
    public boolean delete(Role role) {
        if (role == null)
            return false;

        try (Session session = openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(role);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
