package com.epam.dao;

import org.hibernate.SessionFactory;

public abstract class AbstractDao {
    protected SessionFactory sessionFactory;

    public AbstractDao() {
    }

    public AbstractDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
