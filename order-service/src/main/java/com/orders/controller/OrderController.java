package com.orders.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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

@RestController
@RequestMapping("/api/v1")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object placeOrder(@RequestBody @Valid OrderDetailDTO orderDetail) {
		System.out.println("orderDetail -> " + orderDetail);
		orderService.placeOrder(orderDetail);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getOrders(HttpServletRequest request) {
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(value = "/orders/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getOrderById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
