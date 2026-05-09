package com.example.carrito.service;

import com.example.carrito.entity.*;
import com.example.carrito.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public Carrito crearCarrito() {

        Carrito carrito = new Carrito();

        carrito.setFechaCreacion(LocalDateTime.now());

        return carritoRepository.save(carrito);
    }

    public void agregarProducto(Long carritoId, Long productoId, int cantidad) {

        Carrito carrito = carritoRepository
                .findById(carritoId)
                .orElseThrow();

        Producto producto = productoRepository
                .findById(productoId)
                .orElseThrow();

        ItemCarrito item = new ItemCarrito();

        item.setCantidad(cantidad);

        item.setPrecioUnitario(producto.getPrecio());

        item.setProducto(producto);

        carrito.getItems().add(item);

        carritoRepository.save(carrito);
    }
}