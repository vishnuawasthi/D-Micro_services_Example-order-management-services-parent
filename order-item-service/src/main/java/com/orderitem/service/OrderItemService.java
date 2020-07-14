package com.orderitem.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.orderitem.dto.OrderItemDetailDTO;

public interface OrderItemService {

	@Transactional
	void createOrderItems(Long orderId, List<OrderItemDetailDTO> orderItems);

	@Transactional
	List<OrderItemDetailDTO> fetchOrderItems(Long orderId);
}
