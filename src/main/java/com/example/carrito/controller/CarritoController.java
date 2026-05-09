package com.example.carrito.controller;

import com.example.carrito.dto.AgregarProductoDTO;
import com.example.carrito.entity.Carrito;
import com.example.carrito.service.CarritoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrito")
public class CarritoController {

    @GetMapping
    public String prueba() {
        return "API carrito funcionando";
    }
    @Autowired
    private CarritoService carritoService;

    @PostMapping
    public Carrito crearCarrito() {

        return carritoService.crearCarrito();
    }

    @PostMapping("/agregar")
    public String agregarProducto(@RequestBody AgregarProductoDTO dto) {

        carritoService.agregarProducto(
                dto.getCarritoId(),
                dto.getProductoId(),
                dto.getCantidad()
        );

        return "Producto agregado";
    }
}