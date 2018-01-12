package com.epam.dao;

import com.epam.entity.Role;
import org.hibernate.SessionFactory;

public class RoleDao extends AbstractDao<Role> {

    public RoleDao() {
    }

    public RoleDao(SessionFactory sessionFactory, Class<Role> clazz) {
        super(sessionFactory, clazz);
    }
}
