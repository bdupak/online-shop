package com.epam.service;

import com.epam.dao.UserDao;
import com.epam.entity.User;
import com.epam.utils.HibernateUtils;

import java.util.List;

public class UserService {
    private UserDao userDao;

    public UserService() {
        userDao = new UserDao(HibernateUtils.getSessionFactory(), User.class);
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
