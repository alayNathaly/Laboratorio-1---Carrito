package com.example.carrito.dto;

public class AgregarProductoDTO {

    private Long carritoId;

    private Long productoId;

    private int cantidad;

    public Long getCarritoId() {
        return carritoId;
    }

    public Long getProductoId() {
        return productoId;
    }

    public int getCantidad() {
        return cantidad;
    }
}