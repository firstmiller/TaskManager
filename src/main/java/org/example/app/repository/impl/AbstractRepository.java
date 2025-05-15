package org.example.app.repository.impl;

import org.example.app.config.HibernateUtils;
import org.hibernate.Session;

public abstract class AbstractRepository {
    public Session openSession() {
        return HibernateUtils.getSessionFactory().openSession();
    }
}
