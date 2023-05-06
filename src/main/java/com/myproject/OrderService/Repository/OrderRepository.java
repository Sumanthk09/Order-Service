package com.myproject.OrderService.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.OrderService.Entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	Optional<Order> findById(int id);

}
