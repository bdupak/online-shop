package com.epam.database.service;

import com.epam.database.dao.AbstractDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class AbstractService<T> {

    @Autowired
    protected AbstractDao<T> dao;

    @Transactional
    public T getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    public void save(T entity) {
        dao.save(entity);
    }

    @Transactional
    public void update(T entity) {
        dao.update(entity);
    }

    @Transactional
    public void delete(T entity) {
        dao.delete(entity);
    }

    @Transactional
    public List getAll() {
        return dao.getAll();
    }
}
