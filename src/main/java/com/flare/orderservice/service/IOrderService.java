package com.flare.orderservice.service;

import com.flare.orderservice.dto.CreateOrderResponseDTO;
import com.flare.orderservice.dto.OrderRequestDTO;

public interface IOrderService {

    CreateOrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO) throws Exception;
}
