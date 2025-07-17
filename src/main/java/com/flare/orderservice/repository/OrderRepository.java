package com.flare.orderservice.repository;

import com.flare.orderservice.entity.Order;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // This interface extends JpaRepository to provide CRUD operations for Order entities.
    // Additional query methods can be defined here if needed.
}
