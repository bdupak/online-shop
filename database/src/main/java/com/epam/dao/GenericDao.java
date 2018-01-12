package com.epam.dao;

import java.util.List;

public interface GenericDao<T> {

    T getById(Integer id);

    void save(T t);

    void update(T t);

    void delete(T t);

    List getAll();

}
