package com.epam.dao;

import com.epam.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends AbstractDao<User> {

    public UserDao(Class<User> clazz) {
        super(clazz);
    }
}
