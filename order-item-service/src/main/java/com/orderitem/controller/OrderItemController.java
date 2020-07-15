package com.orderitem.controller;

import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderitem.dto.OrderItemDetailDTO;
import com.orderitem.service.OrderItemService;

@RestController
@RequestMapping("/api/v1")
public class OrderItemController {

	private static final Logger log = Logger.getLogger(OrderItemController.class);
	
	@Autowired
	private OrderItemService orderItemService;

	@PostMapping(value = "/orders/{orderId}/order-items", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object createOrderItems(@PathVariable("orderId") Long orderId,@Valid @RequestBody List<OrderItemDetailDTO> orderItems) {
		log.info("Order item request received ..");
		orderItemService.createOrderItems(orderId, orderItems);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(value = "/orders/{orderId}/order-items", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getOrderItems(@PathVariable("orderId") Long orderId) {
		List<OrderItemDetailDTO> orderItemList = orderItemService.fetchOrderItems(orderId);
		return new ResponseEntity<List<OrderItemDetailDTO>>(orderItemList, HttpStatus.OK);

	}

}
