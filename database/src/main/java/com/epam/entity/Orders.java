package com.epam.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table( name = "orders")
@Data
public class Orders {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "user_fk")
    private Integer userFk;
    @Column(name = "product_fk")
    private Integer productFk;
    private Timestamp date;
    private Integer quantity;
    private Boolean isDelivered;
}
