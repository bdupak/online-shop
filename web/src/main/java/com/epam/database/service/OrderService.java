package com.epam.database.service;

import com.epam.database.dao.OrderDao;
import com.epam.database.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    @Transactional
    public Order getById(Long id) {
        return orderDao.getById(id);
    }

    @Transactional
    public void save(Order Order) {
        orderDao.save(Order);
    }

    @Transactional
    public void update(Order Order) {
        orderDao.update(Order);
    }

    @Transactional
    public void delete(Order Order) {
        orderDao.delete(Order);
    }

    @Transactional
    public List getAll() {
        return orderDao.getAll();
    }
}
