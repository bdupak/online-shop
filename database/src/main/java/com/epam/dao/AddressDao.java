package com.epam.dao;

import com.epam.entity.Address;
import org.hibernate.SessionFactory;

public class AddressDao extends AbstractDao<Address> {

    public AddressDao(SessionFactory sessionFactory, Class<Address> clazz) {
        super(sessionFactory, clazz);
    }
}