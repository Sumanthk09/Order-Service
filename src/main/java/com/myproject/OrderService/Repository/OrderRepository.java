package com.myproject.OrderService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.OrderService.Entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
