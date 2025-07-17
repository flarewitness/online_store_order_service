package com.flare.orderservice.dto;

import com.flare.orderservice.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOrderResponseDTO {
    private long orderId;
    private OrderStatus status;
}
