package com.epam.database.service;

import com.epam.database.dao.UserDetailsDao;
import com.epam.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.security.core.userdetails.User.withUsername;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    UserDetailsDao userDetailsDao;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDetailsDao.getUserByUsername(username);
        UserBuilder builder;
        if (user != null) {
            builder = withUsername(username);
            builder.disabled(user.getIsDeleted());
            builder.password(user.getPassword());
            String authorities = user.getRole().getRole();
            builder.authorities(authorities);
        } else {
            throw new UsernameNotFoundException("User not found");
        }
        return builder.build();
    }
}
