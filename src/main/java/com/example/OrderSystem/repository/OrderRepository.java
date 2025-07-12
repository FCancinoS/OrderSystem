package com.example.OrderSystem.repository;

import com.example.OrderSystem.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de acceso a datos para la entidad Order.
 * Spring Boot generará automáticamente las implementaciones básicas de CRUD.
 */
@Repository // Le indica a Spring Boot que esta interfaz debe ser tratada como un componente de acceso a datos.
public interface OrderRepository extends JpaRepository<Order, Long> {
    /*
     * No necesitas escribir ningún método aquí si solo quieres las operaciones básicas:
     * - findAll()          → para obtener todas las órdenes.
     * - findById(Long id)  → para buscar por ID.
     * - save(Order order)  → para guardar o actualizar una orden.
     * - deleteById(Long id) → para eliminar por ID.
     *
     * Si más adelante necesitas búsquedas específicas, puedes declararlas así:
     * List<Order> findByProductName(String productName);
     */
}