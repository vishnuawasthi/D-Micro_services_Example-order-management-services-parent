package com.orders.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.orders.dto.OrderDetailDTO;

public interface OrderService {

	/**
	 * This method would create order into ORDER DATABASE and also take care of
	 * creating ORDER ITEM in the ORDER ITEM Database by making rest call to ORDER
	 * ITEM Service.
	 * 
	 * @param orderDetail
	 * @return , ID of the created order
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	Long placeOrder(OrderDetailDTO orderDetail);

	/**
	 * This method would give details of order along with order item details against
	 * supplied order Id
	 * 
	 * @param orderId, Id of the order
	 * @return Order Details
	 */
	OrderDetailDTO getOrderByOrderId(Long orderId);
	
}
