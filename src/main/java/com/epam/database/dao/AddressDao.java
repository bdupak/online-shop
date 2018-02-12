package com.epam.database.dao;


import com.epam.database.entity.Address;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDao extends AbstractDao<Address> {

    {
        clazz = Address.class;
    }

}
