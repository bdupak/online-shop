package com.epam.database.dao;


import com.epam.database.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDao extends AbstractDao<Role> {

    {
        clazz = Role.class;
    }
}
