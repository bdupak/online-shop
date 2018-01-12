package com.epam.dao;

import com.epam.entity.User;
import org.hibernate.SessionFactory;

public class UserDao extends AbstractDao<User> {

    public UserDao() {
    }

    public UserDao(SessionFactory sessionFactory, Class<User> clazz) {
        super(sessionFactory, clazz);
    }
}
