package com.flare.orderservice.mapper;

import com.flare.orderservice.dto.OrderItemDTO;
import com.flare.orderservice.entity.Order;
import com.flare.orderservice.entity.OrderItem;

public class OrderItemMapper {

    public static OrderItem OrderItemRequestDTOtoOrderItemEntity(OrderItemDTO itemDTO, Order order, double pricePerUnit, double totalPrice) {

        return OrderItem.builder()
                .productId(itemDTO.getProductId())
                .quantity(itemDTO.getQuantity())
                .order(order)
                .pricePerUnit(pricePerUnit)
                .totalPrice(totalPrice)
                .build();
    }
}
