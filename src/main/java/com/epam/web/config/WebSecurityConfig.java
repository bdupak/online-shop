package com.epam.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity(debug = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);//.passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        /*
        Basic method
        */

//        httpSecurity.authorizeRequests().anyRequest().authenticated()
//                .and().formLogin().loginPage("/login").loginProcessingUrl("/login").permitAll();


        /*
        With messages
        */

//        httpSecurity.authorizeRequests().anyRequest().authenticated()
//                .and().formLogin().loginPage("/login").loginProcessingUrl("/login")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .successHandler((req, res, auth) -> {
//                    System.out.println("Success !");
//                    for (GrantedAuthority authority : auth.getAuthorities()) {
//                        System.out.println("Authority = " + authority.getAuthority());
//                        throw new RuntimeException(authority.getAuthority());
//                    }
//                })
//                .failureHandler((req, res, exp) -> {
//                    System.out.println("No success");
//                    if (exp.getClass().isAssignableFrom(BadCredentialsException.class)) {
//                        System.out.println("Invalid User Name or password");
//                    } else {
//                        System.out.println(exp.getMessage());
//                    }
//                    res.sendRedirect("/login");
//                })
//                .permitAll();

        /*
        with filter
        */

        httpSecurity.authorizeRequests()
                .antMatchers("/admin/**").access("hasRole('admin')")
                .and()
                .formLogin().loginPage("/login")
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/logout")
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .csrf().disable();

        httpSecurity.authorizeRequests()
                .antMatchers("/user/**").access("hasRole('user')")
                .and()
                .formLogin().loginPage("/login")
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/logout")
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .csrf().disable();


//        httpSecurity.authorizeRequests().anyRequest().hasAnyRole("admin", "user")
//                .and().authorizeRequests().antMatchers("/login**").permitAll()
//                .and().formLogin().loginPage("/login").loginProcessingUrl("/login").permitAll()
//                .and().logout().logoutSuccessUrl("/logout").permitAll()
//                .and().csrf().disable();
//
//        httpSecurity.authorizeRequests().antMatchers("/user**").hasRole("user")
//                .and().authorizeRequests().antMatchers("/admin**").hasRole("admin")
//                .and().formLogin();
    }
}
