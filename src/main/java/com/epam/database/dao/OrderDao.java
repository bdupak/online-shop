package com.epam.database.dao;


import com.epam.database.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao extends AbstractDao<Order> {

    {
        clazz = Order.class;
    }
}
