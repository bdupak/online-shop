package com.epam.database.dao;


import com.epam.database.entity.ProductFeedback;
import org.springframework.stereotype.Repository;

@Repository
public class ProductFeedbackDao extends AbstractDao<ProductFeedback> {

    {
        clazz = ProductFeedback.class;
    }
}
