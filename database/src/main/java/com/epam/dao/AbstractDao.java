package com.epam.dao;

import com.epam.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public abstract class AbstractDao<T> implements GenericDao<T> {
    private Class<T> clazz;
    protected SessionFactory sessionFactory;
    protected Transaction transaction;

    public AbstractDao(Class<T> clazz) {
        this.sessionFactory = HibernateUtils.getSessionFactory();
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
            transaction = session.beginTransaction();
            session.save(t);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void update(T t) {
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(t);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(T t) {
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(t);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM " + clazz.getSimpleName()).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }
}
