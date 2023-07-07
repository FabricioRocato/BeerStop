package com.example.beerstop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    @ManyToOne
    private ProductGroup productGroup;

    @OneToMany
    @JsonIgnore
    private List<Movement> movement;

}