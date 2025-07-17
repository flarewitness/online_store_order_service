package com.flare.orderservice.entity;

import com.flare.orderservice.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order extends BaseEntity{

    private long userId;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<OrderItem> items;
}
