package com.epam.database.service;

import com.epam.database.dao.AddressDao;
import com.epam.database.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressDao addressDao;

    @Transactional
    public Address getById(Long id) {
        return addressDao.getById(id);
    }

    @Transactional
    public void saveAddress(Address Address) {
        addressDao.save(Address);
    }

    @Transactional
    public void update(Address Address) {
        addressDao.update(Address);
    }

    @Transactional
    public void delete(Address Address) {
        addressDao.delete(Address);
    }

    @Transactional
    public List getAll() {
        return addressDao.getAll();
    }
}
