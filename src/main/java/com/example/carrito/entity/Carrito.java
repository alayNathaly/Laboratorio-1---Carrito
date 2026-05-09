package com.example.carrito.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaCreacion;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ItemCarrito> items = new ArrayList<>();

    public double calcularTotal() {

        double total = 0;

        for (ItemCarrito item : items) {
            total += item.calcularSubtotal();
        }

        return total;
    }

    public Long getId() {
        return id;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<ItemCarrito> getItems() {
        return items;
    }
}