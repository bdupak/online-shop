package com.epam.database.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.TypedQuery;
import java.util.List;

public abstract class AbstractDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    protected Class<T> clazz;

    public T getById(Long id) {
        return sessionFactory.getCurrentSession().get(clazz, id);
    }

    public void save(T entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    public void update(T entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    public void delete(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    public List<T> getAll() {
        TypedQuery<T> query = sessionFactory.getCurrentSession().createQuery("from " + clazz.getSimpleName());
        return query.getResultList();
    }
}
