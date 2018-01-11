package com.epam.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "product_feedback")
@Data
public class ProductFeedback {

    @Id
    @GeneratedValue
    private Integer id;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Set<Product> product;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Set<User> user;
    private Timestamp date;
    private Integer mark;
    private String advantages;
    private String disadvantages;
    private String feedback;
}
