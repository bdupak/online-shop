package com.epam.database.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.TypedQuery;
import java.util.List;

public abstract class AbstractDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    protected Class<T> clazz;

    public T getById(Long id) {
        return getSession().get(clazz, id);
    }

    public void save(T entity) {
        getSession().save(entity);
    }

    public void update(T entity) {
        getSession().update(entity);
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    public List<T> getAll() {
        TypedQuery<T> query = getSession().createQuery("from " + clazz.getSimpleName());
        return query.getResultList();
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
