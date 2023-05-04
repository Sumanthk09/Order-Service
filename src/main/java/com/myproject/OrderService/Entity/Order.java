package com.myproject.OrderService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_order_dtl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order 
{
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int qt;
	private double price;

}
