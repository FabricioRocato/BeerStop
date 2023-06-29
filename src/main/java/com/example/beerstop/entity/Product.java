package com.example.beerstop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int quantityInStock;
    private double price;

    @Enumerated(EnumType.STRING)
    private ProductGroup productGroup;

}
