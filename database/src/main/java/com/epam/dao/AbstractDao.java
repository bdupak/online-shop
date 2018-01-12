package com.epam.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public abstract class AbstractDao<T> implements GenericDao<T> {
    private Class<T> clazz;
    protected SessionFactory sessionFactory;

    public AbstractDao() {
    }

    public AbstractDao(SessionFactory sessionFactory, Class<T> clazz) {
        this.sessionFactory = sessionFactory;
        this.clazz = clazz;
    }

    @Override
    public T getById(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(clazz, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(T t) {
        try (Session session = sessionFactory.openSession()) {
            session.save(t);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(T t) {
        try (Session session = sessionFactory.openSession()) {
            session.update(t);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(T t) {
        try (Session session = sessionFactory.openSession()) {
            session.delete(t);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM" + clazz.getSimpleName()).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }
}
