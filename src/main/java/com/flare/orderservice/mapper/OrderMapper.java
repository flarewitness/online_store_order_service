package com.flare.orderservice.mapper;

import com.flare.orderservice.dto.CreateOrderResponseDTO;
import com.flare.orderservice.dto.OrderRequestDTO;
import com.flare.orderservice.entity.Order;
import com.flare.orderservice.entity.OrderItem;
import com.flare.orderservice.enums.OrderStatus;

public class OrderMapper {

    public static Order toEntity(OrderRequestDTO request) {
        return Order.builder()
                .userId(request.getUserId())
                .status(OrderStatus.PENDING)
                .build();
    }

    public static CreateOrderResponseDTO toCreateOrderResponseDTO(Order createdOrder) {
        return CreateOrderResponseDTO.builder()
                .orderId(createdOrder.getId())
                .status(createdOrder.getStatus())
                .build();
    }
}
