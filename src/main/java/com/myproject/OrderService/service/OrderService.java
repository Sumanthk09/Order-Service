package com.myproject.OrderService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.myproject.OrderService.Entity.Order;
import com.myproject.OrderService.Repository.OrderRepository;
import com.myproject.OrderService.dto.Payment;
import com.myproject.OrderService.dto.TransactionRequest;
import com.myproject.OrderService.dto.TransactionResponse;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private RestTemplate template;
	
	public TransactionResponse saveOrder(TransactionRequest request)
	{
		String message="";
		Order order = request.getOrder();
		Payment payment = request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		Payment paymentResponse = template.postForObject("http://PAYMENT-SERVICE/Payment/doPayment", payment, Payment.class);
		message=paymentResponse.getPaymentStatus().equals("success")?"successful":"failed payment";
		repository.save(order);
		return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),message);
	}
	
}
