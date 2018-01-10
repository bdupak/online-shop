package com.epam.dao;

import com.epam.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDao extends AbstractDao {

    public UserDao() {
    }

    public UserDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public User getUserById(Long id) {
        try(Session session = sessionFactory.openSession()) {
            return session.get(User.class, id);
        } catch(HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List getUsers() {
        try(Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM User").list();
        } catch(HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }
}
