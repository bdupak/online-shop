package com.epam.database.dao;


import com.epam.database.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao extends AbstractDao<Product> {

    {
        clazz = Product.class;
    }
}
