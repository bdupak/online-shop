package com.epam.service;

import com.epam.dao.ProductFeedbackDao;
import com.epam.entity.ProductFeedback;

import java.util.List;

public class ProductFeedbackService {

    private ProductFeedbackDao productFeedbackDao;

    public ProductFeedbackService() {
        productFeedbackDao = new ProductFeedbackDao(ProductFeedback.class);
    }

    public ProductFeedback getProductFeedbackById(Integer id) {
        return productFeedbackDao.getById(id);
    }

    public void saveProductFeedback(ProductFeedback ProductFeedback) {
        productFeedbackDao.save(ProductFeedback);
    }

    public void update(ProductFeedback ProductFeedback) {
        productFeedbackDao.update(ProductFeedback);
    }

    public void delete(ProductFeedback ProductFeedback) {
        productFeedbackDao.delete(ProductFeedback);
    }

    public List getAll() {
        return productFeedbackDao.getAll();
    }
}
