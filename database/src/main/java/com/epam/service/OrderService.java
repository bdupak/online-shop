package com.epam.service;

import com.epam.dao.OrderDao;
import com.epam.entity.Order;

import java.util.List;

public class OrderService {

    private OrderDao orderDao;

    public OrderService() {
        orderDao = new OrderDao(Order.class);
    }

    public Order getOrderById(Integer id) {
        return orderDao.getById(id);
    }

    public void saveOrder(Order Order) {
        orderDao.save(Order);
    }

    public void update(Order Order) {
        orderDao.update(Order);
    }

    public void delete(Order Order) {
        orderDao.delete(Order);
    }

    public List getAll() {
        return orderDao.getAll();
    }
}
