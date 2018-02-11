package com.epam.database.service;

import com.epam.database.dao.ProductDao;
import com.epam.database.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    @Transactional
    public Product getProductById(Long id) {
        return productDao.getById(id);
    }

    @Transactional
    public void saveProduct(Product Product) {
        productDao.save(Product);
    }

    @Transactional
    public void update(Product Product) {
        productDao.update(Product);
    }

    @Transactional
    public void delete(Product Product) {
        productDao.delete(Product);
    }

    @Transactional
    public List getAll() {
        return productDao.getAll();
    }
}
