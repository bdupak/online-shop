package com.epam.dao;

import com.epam.entity.ProductFeedback;
import org.hibernate.SessionFactory;

public class ProductFeedbackDao extends AbstractDao<ProductFeedback> {

    public ProductFeedbackDao(SessionFactory sessionFactory, Class<ProductFeedback> clazz) {
        super(sessionFactory, clazz);
    }
}
