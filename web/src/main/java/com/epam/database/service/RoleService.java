package com.epam.database.service;

import com.epam.database.dao.RoleDao;
import com.epam.database.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    @Transactional
    public Role getById(Long id) {
        return roleDao.getById(id);
    }

    @Transactional
    public void save(Role Role) {
        roleDao.save(Role);
    }

    @Transactional
    public void update(Role Role) {
        roleDao.update(Role);
    }

    @Transactional
    public void delete(Role Role) {
        roleDao.delete(Role);
    }

    @Transactional
    public List getAll() {
        return roleDao.getAll();
    }
}
