package com.orders.controller;

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

import com.orders.dto.OrderDetailDTO;
import com.orders.service.OrderService;

/**
 * This controller would provide all the
 * 
 * @author Vishnu Awasthi Email : Vishnuawasthi121@gmail.com
 *
 */
@RestController
@RequestMapping("/api/v1")
public class OrderController {
	
	private static final Logger log = Logger.getLogger(OrderController.class);
	
	@Autowired
	private OrderService orderService;

	/**
	 * This handler would create order in the system
	 * @param orderDetail
	 * @return , Order ID
	 */
	@PostMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object placeOrder(@RequestBody @Valid OrderDetailDTO orderDetail) {
		log.debug("orderDetail -> " + orderDetail);
		Long orderId = orderService.placeOrder(orderDetail);
		return new ResponseEntity<>(orderId, HttpStatus.OK);
	}

	/**
	 * This handler would give order details queried against order id.
	 * @param orderId ,Order id
	 * @return Order Detail
	 */
	@GetMapping(value = "/orders/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getOrderById(@PathVariable("orderId") Long orderId) {
		log.debug("orderId -> " + orderId);
		OrderDetailDTO order = orderService.getOrderByOrderId(orderId);
		return new ResponseEntity<OrderDetailDTO>(order, HttpStatus.OK);
	}

}
