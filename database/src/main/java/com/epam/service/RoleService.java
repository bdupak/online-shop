package com.epam.service;

import com.epam.dao.RoleDao;
import com.epam.entity.Role;

import java.util.List;

public class RoleService {

    private RoleDao roleDao;

    public RoleService() {
        roleDao = new RoleDao(Role.class);
    }

    public Role getById(Integer id) {
        return roleDao.getById(id);
    }

    public void save(Role Role) {
        roleDao.save(Role);
    }

    public void update(Role Role) {
        roleDao.update(Role);
    }

    public void delete(Role Role) {
        roleDao.delete(Role);
    }

    public List getAll() {
        return roleDao.getAll();
    }
}
