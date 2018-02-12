package com.epam.database.dao;


import com.epam.database.entity.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao extends AbstractDao<Category> {

    {
        clazz = Category.class;
    }
}
