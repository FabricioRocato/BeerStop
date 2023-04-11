package com.example.beerstop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "comanda")
public class Comanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "table_number")
    private Long tableNumber;

    @Column(name = "is_open")
    private Boolean isOpen;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany
    @JoinTable(name = "comanda_product",
    joinColumns = @JoinColumn(name = "comanda_id"),
    inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> product;

    private Comanda() {
        this.isOpen = Boolean.TRUE;
    }
}