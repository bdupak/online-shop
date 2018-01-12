package com.epam.dao;

import com.epam.entity.Category;
import org.hibernate.SessionFactory;

public class CategoryDao extends AbstractDao<Category> {

    public CategoryDao() {
    }

    public CategoryDao(SessionFactory sessionFactory, Class<Category> clazz) {
        super(sessionFactory, clazz);
    }
}
