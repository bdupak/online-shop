package com.epam.dao;

import com.epam.entity.Order;
import org.hibernate.SessionFactory;

public class OrderDao extends AbstractDao<Order> {

    public OrderDao(SessionFactory sessionFactory, Class<Order> clazz) {
        super(sessionFactory, clazz);
    }
}
