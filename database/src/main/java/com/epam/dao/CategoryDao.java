package com.epam.dao;

import com.epam.entity.Category;
import org.hibernate.SessionFactory;

public class CategoryDao extends AbstractDao<Category> {

    public CategoryDao(Class<Category> clazz) {
        super(clazz);
    }
}
