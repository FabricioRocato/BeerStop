package com.example.beerstop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "comanda")
public class Comanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "table_number")
    private Long tableNumber;

    @OneToMany
    @JoinColumn(name = "employee")
    private List<Employee> employee;

    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

    @OneToMany
    @JoinColumn(name = "product")
    private List<Product> product;

}
