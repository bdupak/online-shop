package com.epam.database.dao;

import com.epam.database.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends AbstractDao<User> {

    {
        clazz = User.class;
    }
}
