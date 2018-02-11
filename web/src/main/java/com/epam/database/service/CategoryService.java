package com.epam.database.service;

import com.epam.database.dao.CategoryDao;
import com.epam.database.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Transactional
    public Category getCategoryById(Long id) {
        return categoryDao.getById(id);
    }

    @Transactional
    public void saveCategory(Category Category) {
        categoryDao.save(Category);
    }

    @Transactional
    public void update(Category Category) {
        categoryDao.update(Category);
    }

    @Transactional
    public void delete(Category Category) {
        categoryDao.delete(Category);
    }

    @Transactional
    public List getAll() {
        return categoryDao.getAll();
    }
}
