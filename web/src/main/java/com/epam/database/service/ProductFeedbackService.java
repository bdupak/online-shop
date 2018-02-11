package com.epam.database.service;


import com.epam.database.dao.ProductFeedbackDao;
import com.epam.database.entity.ProductFeedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductFeedbackService {

    @Autowired
    private ProductFeedbackDao productFeedbackDao;

    @Transactional
    public ProductFeedback getProductFeedbackById(Long id) {
        return productFeedbackDao.getById(id);
    }

    @Transactional
    public void saveProductFeedback(ProductFeedback ProductFeedback) {
        productFeedbackDao.save(ProductFeedback);
    }

    @Transactional
    public void update(ProductFeedback ProductFeedback) {
        productFeedbackDao.update(ProductFeedback);
    }

    @Transactional
    public void delete(ProductFeedback ProductFeedback) {
        productFeedbackDao.delete(ProductFeedback);
    }

    @Transactional
    public List getAll() {
        return productFeedbackDao.getAll();
    }
}
