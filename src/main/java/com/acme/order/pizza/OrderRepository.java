package com.acme.order.pizza;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acme.order.OrderStatus;

public interface OrderRepository extends JpaRepository<PizzaOrder, Long> {
	List<PizzaOrder> findByStatus(OrderStatus delivered);
}
