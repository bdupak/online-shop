package com.epam.database.dao;

import com.epam.database.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDetailsDao extends AbstractDao {

    public User getUserByUsername(String username) {
        return (User) getSession().createQuery("from User where login like '" + username + "'").list().get(0);
    }
}
