package com.example.OrderSystem.controller;

import com.example.OrderSystem.model.Order;
import com.example.OrderSystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador que expone las APIs REST para gestionar las órdenes.
 */
@RestController // Le indica a Spring que esta clase gestiona peticiones HTTP REST.
@RequestMapping("/orders") // Todas las rutas empezarán por /orders
public class OrderController {

    private final OrderService orderService;

    /**
     * Inyección del servicio mediante el constructor.
     */
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/hello")
    public String hello() {
        return "¡Hola desde Smart Paradise!";
    }

    /**
     * GET /orders
     * Devuelve todas las órdenes.
     */
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    /**
     * GET /orders/{id}
     * Devuelve una orden por ID.
     */
    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    /**
     * POST /orders
     * Crea una nueva orden.
     * El cuerpo de la petición debe ser un JSON que represente la orden.
     */
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }
    @PostMapping("/batch")
    public List<Order> createOrders(@RequestBody List<Order> orders) {
        return orders.stream()
                .map(orderService::saveOrder)
                .toList();
    }
    /**
     * PUT /orders/{id}
     * Actualiza una orden existente por ID.
     */
    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order updatedOrder) {
        return orderService.updateOrder(id, updatedOrder);
    }

    /**
     * DELETE /orders/{id}
     * Elimina una orden por ID.
     */
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}