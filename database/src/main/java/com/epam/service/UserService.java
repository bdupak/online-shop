package com.epam.service;

import com.epam.dao.UserDao;
import com.epam.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserService() {
        userDao = new UserDao(User.class);
    }

    public User getUserById(Integer id) {
        return userDao.getById(id);
    }

    public void saveUser(User user) {
        userDao.save(user);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delete(User user) {
        userDao.delete(user);
    }

    public List getAll() {
        return userDao.getAll();
    }
}
