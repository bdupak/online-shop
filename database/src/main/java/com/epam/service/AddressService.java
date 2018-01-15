package com.epam.service;

import com.epam.dao.AddressDao;
import com.epam.entity.Address;

import java.util.List;

public class AddressService {

    private AddressDao addressDao;

    public AddressService() {
        addressDao = new AddressDao(Address.class);
    }

    public Address getAddressById(Integer id) {
        return addressDao.getById(id);
    }

    public void saveAddress(Address Address) {
        addressDao.save(Address);
    }

    public void update(Address Address) {
        addressDao.update(Address);
    }

    public void delete(Address Address) {
        addressDao.delete(Address);
    }

    public List getAll() {
        return addressDao.getAll();
    }
}
