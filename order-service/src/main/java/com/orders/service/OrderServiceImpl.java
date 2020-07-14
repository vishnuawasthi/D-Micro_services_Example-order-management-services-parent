package com.orders.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orders.dto.OrderDetailDTO;
import com.orders.entities.OrderDetail;
import com.orders.repositories.OrderDetailRepository;
import com.orders.restclients.OrderItemServiceRestClient;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Autowired
	private OrderItemServiceRestClient restClient;

	@Override
	public Long placeOrder(OrderDetailDTO orderDetail) {
		System.out.println("orderDetail   -> " + orderDetail);
		OrderDetail entity = new OrderDetail();
		BeanUtils.copyProperties(orderDetail, entity);
		orderDetailRepository.save(entity);
		restClient.createOrderItems(entity.getId(), orderDetail.getOrderItems());
		return entity.getId();
	}

}