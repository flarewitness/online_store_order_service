package com.flare.orderservice.controllers;

import com.flare.orderservice.dto.CreateOrderResponseDTO;
import com.flare.orderservice.dto.OrderRequestDTO;
import com.flare.orderservice.service.IOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    private final IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<CreateOrderResponseDTO> createOrder(@RequestBody OrderRequestDTO request) throws Exception {
        CreateOrderResponseDTO response = orderService.createOrder(request);
        return ResponseEntity.ok(response);
    }

}
