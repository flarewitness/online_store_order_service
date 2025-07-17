package com.flare.orderservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "order_items")
public class OrderItem extends BaseEntity {
    private long productId;
    private int quantity;
    private double pricePerUnit;
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
}
