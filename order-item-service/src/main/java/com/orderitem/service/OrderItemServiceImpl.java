package com.orderitem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.orderitem.dto.OrderItemDetailDTO;
import com.orderitem.entities.OrderItem;
import com.orderitem.repository.OrderItemRepository;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void createOrderItems(Long orderId, List<OrderItemDetailDTO> orderItems) {
		List<OrderItem> entities = new ArrayList<OrderItem>();
		orderItems.stream().forEach(item -> {
			OrderItem entity = new OrderItem();
			BeanUtils.copyProperties(item, entity);
			entity.setOrderId(orderId);
			entities.add(entity);
		});
		orderItemRepository.saveAll(entities);
	}

	@Override
	public List<OrderItemDetailDTO> fetchOrderItems(Long orderId) {
		List<OrderItemDetailDTO> orderItemList = new ArrayList<>();
		List<OrderItem> entities = orderItemRepository.findAllOrderItemsByOrderId(orderId);
		if (!CollectionUtils.isEmpty(entities)) {
			entities.stream().forEach(item -> {
				OrderItemDetailDTO orderItemDetailDTO = new OrderItemDetailDTO();
				BeanUtils.copyProperties(item, orderItemDetailDTO);
				orderItemList.add(orderItemDetailDTO);
			});
		}
		return orderItemList;
	}

}
