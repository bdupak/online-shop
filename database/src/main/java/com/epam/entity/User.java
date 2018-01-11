package com.epam.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String login;
    private String password;
    private String salt;
    private String name;
    private String surname;
    private Integer age;
    @Column(name = "phone_number")
    private String phoneNumber;
    private Integer discount;
    @ManyToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "address_fk")
    private Address address;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_fk")
    private Role role;
    @Column(name = "img_url")
    private String imageUrl;
    private String uuid;
    @Column(name = "reg_date")
    private Timestamp registeredDate;
    @Column(name = "lang")
    private String language;
    @Column(name = "is_deleted")
    private Boolean isDeleted;
}
