package com.api.order.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.api.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	Order findByOrderid(Integer orderid);

	
}
