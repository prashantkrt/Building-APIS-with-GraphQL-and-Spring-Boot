package com.mylearning.grapghql.controller;

import com.mylearning.grapghql.dto.OrderInputRequestDto;
import com.mylearning.grapghql.dto.OrderResponseDto;
import com.mylearning.grapghql.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @MutationMapping
    public OrderResponseDto saveOrder(@Argument OrderInputRequestDto orderInputRequestDto) {
        return orderService.saveOrder(orderInputRequestDto);
    }

    @MutationMapping
    public OrderResponseDto updateOrder(@Argument OrderInputRequestDto orderInputRequestDto) {
        return orderService.updateOrder(orderInputRequestDto);
    }

    @MutationMapping
    public OrderResponseDto deleteOrder(@Argument Integer orderId) {
        return orderService.deleteOrder(orderId);
    }

    @QueryMapping
    public OrderResponseDto getOrderById(@Argument Integer orderId) {
        return orderService.getOrderById(orderId);
    }

    @QueryMapping
    public List<OrderResponseDto> getAllOrders() {
        return orderService.getAllOrders();
    }
}
