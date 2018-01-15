package com.epam.dao;

import com.epam.entity.Role;
import org.hibernate.SessionFactory;

public class RoleDao extends AbstractDao<Role> {

    public RoleDao(Class<Role> clazz) {
        super(clazz);
    }
}
