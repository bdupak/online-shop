package com.epam.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
@Data
public class Address {
    @Id
    @GeneratedValue
    private Integer id;
    private String country;
    private String city;
    private String street;
    private String zipcode;
}
