package com.epam.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String overview;
    private Double price;
    private Integer weight;
    private String size;
    @Column(name = "img_url")
    private String imageUrl;
    @Column(name = "is_deleted")
    private Boolean isDeleted;
    @Column(name = "category_fk")
    private Integer category;
}
