package com.example.OrderSystem.service;

import com.example.OrderSystem.model.Order;
import com.example.OrderSystem.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio que gestiona la lógica relacionada con las órdenes.
 */
@Service // Le dice a Spring Boot que esta clase es un componente de lógica de negocio.
public class OrderService {

    private final OrderRepository orderRepository;

    /**
     * Inyección de dependencia del repository.
     * Spring Boot proporciona automáticamente la instancia.
     */
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Obtiene todas las órdenes almacenadas.
     */
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    /**
     * Guarda una nueva orden o actualiza una existente.
     */
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    /**
     * Busca una orden por su ID.
     */
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    /**
     * Elimina una orden por su ID.
     */
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public Order updateOrder(Long id, Order updatedOrder) {
        // Busca la orden por su ID
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        // Actualiza los campos
        existingOrder.setProductName(updatedOrder.getProductName());
        existingOrder.setQuantity(updatedOrder.getQuantity());
        existingOrder.setPrice(updatedOrder.getPrice());

        // Guarda los cambios
        return orderRepository.save(existingOrder);
    }

}