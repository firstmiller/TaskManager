package org.example.app.config;

import org.example.app.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

class PropertiesSessionFactoryProvider implements SessionFactoryProvider {
    @Override
    public SessionFactory getSessionFactory() {
        return new Configuration()
                .addAnnotatedClass(Board.class)
                .addAnnotatedClass(BoardStyle.class)
                .addAnnotatedClass(Role.class)
                .addAnnotatedClass(Task.class)
                .addAnnotatedClass(TaskList.class)
                .addAnnotatedClass(TaskStyle.class)
                .addAnnotatedClass(Urgency.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }
}
