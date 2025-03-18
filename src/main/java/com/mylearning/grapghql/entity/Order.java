package com.mylearning.grapghql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private String orderDetails;
    private String orderStatus;
    private Double orderPrice;
    private String orderDate;
    private String orderTime;
    private String orderAddress;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
