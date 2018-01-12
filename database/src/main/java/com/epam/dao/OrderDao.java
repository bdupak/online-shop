package com.epam.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

public class OrderDao extends AbstractDao<Order> {

    public OrderDao() {
    }

    public OrderDao(SessionFactory sessionFactory, Class<Order> clazz) {
        super(sessionFactory, clazz);
    }
}
