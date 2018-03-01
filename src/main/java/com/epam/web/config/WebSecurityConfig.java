package com.epam.web.config;

import com.epam.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public void configure(AuthenticationManagerBuilder auth) {
        //TODO add logic for encoding pass
    }

    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().anyRequest().hasAnyRole("admin", "user")
                .and().authorizeRequests().antMatchers("/login**").permitAll()
                .and().formLogin().loginPage("/loginUser").loginProcessingUrl("/login").permitAll()
                .and().logout().logoutSuccessUrl("/logout").permitAll()
                .and().csrf().disable();

        httpSecurity.authorizeRequests().antMatchers("/user**").hasRole("user")
                .and().authorizeRequests().antMatchers("/admin**").hasRole("admin")
                .and().formLogin();
    }

}
