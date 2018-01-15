package com.epam.service;

import com.epam.dao.CategoryDao;
import com.epam.entity.Category;

import java.util.List;

public class CategoryService {

    private CategoryDao categoryDao;

    public CategoryService() {
        categoryDao = new CategoryDao(Category.class);
    }

    public Category getCategoryById(Integer id) {
        return categoryDao.getById(id);
    }

    public void saveCategory(Category Category) {
        categoryDao.save(Category);
    }

    public void update(Category Category) {
        categoryDao.update(Category);
    }

    public void delete(Category Category) {
        categoryDao.delete(Category);
    }

    public List getAll() {
        return categoryDao.getAll();
    }
}
