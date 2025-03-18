package com.mylearning.grapghql.service;

import com.mylearning.grapghql.Helper.ExceptionHelper;
import com.mylearning.grapghql.Repository.OrderRepository;
import com.mylearning.grapghql.dto.OrderInputRequestDto;
import com.mylearning.grapghql.dto.OrderResponseDto;
import com.mylearning.grapghql.entity.Order;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper mapper;

    public OrderResponseDto saveOrder(OrderInputRequestDto orderInputRequestDto) {
        Order order = mapper.map(orderInputRequestDto, Order.class);
        orderRepository.save(order);
        return mapper.map(order, OrderResponseDto.class);
    }

    public List<OrderResponseDto> getAllOrders() {
        Type listType = new TypeToken<List<OrderResponseDto>>() {
        }.getType();
        List<Order> orders = orderRepository.findAll();
        return new ModelMapper().map(orders, listType);
//        or
//        return orders.stream()
//                .map(order -> mapper.map(order, OrderResponseDto.class))
//                .toList();
//        //or
//        return orders.stream()
//                .map(order -> new OrderResponseDto(
//                        order.getId(),
//                        order.getCustomerName(),
//                        order.getTotalAmount(),
//                        order.getOrderStatus()
//                ))
//                .toList();

    }

    public OrderResponseDto getOrderById(Integer orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        return mapper.map(order, OrderResponseDto.class);
    }

    public OrderResponseDto updateOrder(OrderInputRequestDto orderInputRequestDto) {
        Order order = mapper.map(orderInputRequestDto, Order.class);
        orderRepository.save(order);
        return mapper.map(order, OrderResponseDto.class);
    }

    public OrderResponseDto deleteOrder(Integer orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        orderRepository.delete(order);
        return mapper.map(order, OrderResponseDto.class);
    }




}
