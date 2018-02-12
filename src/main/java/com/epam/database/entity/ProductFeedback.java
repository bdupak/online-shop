package com.epam.database.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "product_feedback")
@Data
public class ProductFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Set<Product> product;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Set<User> user;
    private Timestamp date;
    private Integer mark;
    private String advantages;
    private String disadvantages;
    private String feedback;
}
