package com.orders.service;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.orders.dto.OrderDetailDTO;
import com.orders.dto.OrderItemDetail;
import com.orders.entities.OrderDetail;
import com.orders.exception.OrderNotFoundException;
import com.orders.repositories.OrderDetailRepository;
import com.orders.restclients.OrderItemServiceRestClient;

@Service
public class OrderServiceImpl implements OrderService {

	private static final Logger log = Logger.getLogger(OrderServiceImpl.class);
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Autowired
	private OrderItemServiceRestClient restClient;

	public static final String ORDER_NOT_FOUND_MSG = "Order not found for provided orderId";

	@Override
	public Long placeOrder(OrderDetailDTO orderDetail) {
		log.debug("orderDetail   -> " + orderDetail);
		OrderDetail entity = new OrderDetail();
		BeanUtils.copyProperties(orderDetail, entity);
		/**
		 * As exercise does not talk about the price. Here we can assume two possible
		 * way 
		 * 1. Price will come with Order item. 
		 * 2. By Querying the Product details
		 * based on the product code we can get the price. 
		 * Note : I am going with first Option.
		 * 
		 */
		DoubleSummaryStatistics summaryStatistics = orderDetail.getOrderItems().stream().map(item -> {
			Double totalPrice = item.getPrice() * item.getQuantity();
			return totalPrice;
		}).collect(Collectors.summarizingDouble(Double::valueOf));

		entity.setTotal(summaryStatistics.getSum());
		orderDetailRepository.save(entity);
		restClient.createOrderItems(entity.getId(), orderDetail.getOrderItems());
		return entity.getId();
	}

	@Override
	public OrderDetailDTO getOrderByOrderId(Long orderId) {
		log.debug("orderId   -> " + orderId);
		OrderDetailDTO orderDetailDTO = null;
		Optional<OrderDetail> OrderDetailOption = orderDetailRepository.findById(orderId);

		if (OrderDetailOption.isPresent()) {
			orderDetailDTO = new OrderDetailDTO();
			BeanUtils.copyProperties(OrderDetailOption.get(), orderDetailDTO);
			List<OrderItemDetail> orderItems = restClient.getOrderItemsByOrderId(orderId);

			if (!CollectionUtils.isEmpty(orderItems)) {
				orderDetailDTO.setOrderItems(orderItems);
			}
		}
		throw new OrderNotFoundException(ORDER_NOT_FOUND_MSG);
	}

}
