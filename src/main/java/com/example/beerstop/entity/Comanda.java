package com.example.beerstop.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "comanda")
public class Comanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroComanda;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemComanda> itens;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Employee employee;

    // Constructors, getters, and setters

    public void adicionarItem(ItemComanda item) {
        itens.add(item);
    }

    public void removerItem(ItemComanda item) {
        itens.remove(item);
    }

    public List<ItemComanda> getItens() {
        return itens;
    }

    public double getTotalPagar() {
        double total = 0.0;
        for (ItemComanda item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    public Comanda() {
        this.status = Status.OPEN;
    }
}
