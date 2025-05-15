package org.example.app.config;

import org.hibernate.SessionFactory;

public interface SessionFactoryProvider {
    SessionFactory getSessionFactory();
}
