package com.example.beerstop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "stock_movement")
public class StockMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne()
    private Product product;

    @Enumerated(EnumType.STRING)
    private MovementType tipo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "movement_date")
    private Date movementDate;
}