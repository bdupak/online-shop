package com.epam.service;

import com.epam.dao.ProductDao;
import com.epam.entity.Product;

import java.util.List;

public class ProductService {

    private ProductDao productDao;

    public ProductService() {
        productDao = new ProductDao(Product.class);
    }

    public Product getProductById(Integer id) {
        return productDao.getById(id);
    }

    public void saveProduct(Product Product) {
        productDao.save(Product);
    }

    public void update(Product Product) {
        productDao.update(Product);
    }

    public void delete(Product Product) {
        productDao.delete(Product);
    }

    public List getAll() {
        return productDao.getAll();
    }
}
