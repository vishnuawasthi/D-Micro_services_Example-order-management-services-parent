package com.orders.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.orders.dto.OrderDetailDTO;

public interface OrderService {

	@Transactional(propagation=Propagation.REQUIRED)
	Long placeOrder(OrderDetailDTO orderDetail);
	
}
