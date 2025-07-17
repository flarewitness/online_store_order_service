package com.flare.orderservice.service;

import com.flare.orderservice.clients.ProductServiceClient;
import com.flare.orderservice.dto.CreateOrderResponseDTO;
import com.flare.orderservice.dto.OrderItemDTO;
import com.flare.orderservice.dto.OrderRequestDTO;
import com.flare.orderservice.dto.ProductDTO;
import com.flare.orderservice.entity.Order;
import com.flare.orderservice.entity.OrderItem;
import com.flare.orderservice.mapper.OrderItemMapper;
import com.flare.orderservice.mapper.OrderMapper;
import com.flare.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;
    private final ProductServiceClient productServiceClient;

    public OrderService(OrderRepository orderRepository, ProductServiceClient productServiceClient) {
        this.orderRepository = orderRepository;
        this.productServiceClient = productServiceClient;
    }

    @Override
    public CreateOrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO) throws Exception {
        Order order = OrderMapper.toEntity(orderRequestDTO);

        List<OrderItem> items = new ArrayList<>();

        for(OrderItemDTO itemDTO : orderRequestDTO.getItems()){
            ProductDTO product = productServiceClient.getProductById(itemDTO.getProductId());
            double pricePerUnit = product.getPrice();
            double totalPrice = pricePerUnit * itemDTO.getQuantity();

            OrderItem item = OrderItemMapper.OrderItemRequestDTOtoOrderItemEntity(itemDTO, order, pricePerUnit, totalPrice);
            items.add(item);
        }

        order.setItems(items);
        Order createdOrder = orderRepository.save(order);

        return OrderMapper.toCreateOrderResponseDTO(createdOrder);
    }
}
