package com.mylearning.grapghql.Repository;

import com.mylearning.grapghql.entity.Order;
import com.mylearning.grapghql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("SELECT o FROM Order o WHERE o.user = :user")
    List<Order> findOrdersByUser(@Param("user") User user);

    @Query("SELECT o FROM Order o WHERE o.user = ?1 AND o.orderStatus = ?2")
    List<Order> findOrdersByUserAndStatus(User user, String status);
}
