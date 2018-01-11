package com.epam.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Set<User> user;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Set<Product> product;
    private Timestamp date;
    private Integer quantity;
    @Column(name = "is_delivered")
    private Boolean isDelivered;
}
