package com.epam.dao;

import com.epam.entity.Product;
import org.hibernate.SessionFactory;

public class ProductDao extends AbstractDao<Product> {

    public ProductDao() {
    }

    public ProductDao(SessionFactory sessionFactory, Class<Product> clazz) {
        super(sessionFactory, clazz);
    }
}
