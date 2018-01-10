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
    @Column(name = "id")
    private Integer id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "salt")
    private String salt;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "age")
    private Integer age;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "discount")
    private Integer discount;
    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "address_fk")
    private Address address;
    @Column(name = "role_fk")
    private Integer roleFk;
    @Column(name = "img_url")
    private String imageUrl;
    @Column(name = "uuid")
    private String uuid;
    @Column(name = "reg_date")
    private Timestamp registeredDate;
    @Column(name = "lang")
    private String language;
    @Column(name = "is_deleted")
    private Boolean isDeleted;
}
