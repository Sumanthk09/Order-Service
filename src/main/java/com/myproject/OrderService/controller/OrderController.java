package com.myproject.OrderService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.OrderService.Entity.Order;
import com.myproject.OrderService.dto.Payment;
import com.myproject.OrderService.dto.TransactionRequest;
import com.myproject.OrderService.dto.TransactionResponse;
import com.myproject.OrderService.service.OrderService;

@RestController
@RequestMapping("/Order")
public class OrderController {

	@Autowired
	private OrderService service;
	
	@PostMapping("/bookOrder")
	public TransactionResponse saveOrder(@RequestBody TransactionRequest request)
	{
		return service.saveOrder(request);
	}
	
	@GetMapping("/getOrder")
	public Optional<Order> getorder(@RequestParam("id") int id, @RequestHeader("loggedInUser") String username )
	{
		System.out.println(username);
		return service.getOrderById(id);
	}
}
