package com.epam.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
@Data
public class Category {

    @Id
    @GeneratedValue
    private Integer id;
    private String category;
}
