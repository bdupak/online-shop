package com.epam.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "product_feedback")
@Data
public class ProductFeedback {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "product_fk")
    private Integer productFk;
    @Column(name = "user_fk")
    private Integer userFk;
    private Timestamp date;
    private String advantages;
    private String disadvantages;
    private String feedback;
}
