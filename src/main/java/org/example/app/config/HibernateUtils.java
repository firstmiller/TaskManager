package org.example.app.config;

import org.hibernate.SessionFactory;

public class HibernateUtils {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private HibernateUtils() {
    }

    private static SessionFactory buildSessionFactory() {
        SessionFactoryProvider provider = new PropertiesSessionFactoryProvider();
        return provider.getSessionFactory();
    }

    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
