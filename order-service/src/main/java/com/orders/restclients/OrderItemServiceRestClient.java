package com.orders.restclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.orders.dto.OrderItemDetail;
/**
 * This is rest client for order-item service.
 * @author Vishnu Awasthi 
 * Email : Vishnuawasthi121@gmail.com
 *
 */
@FeignClient(name = "order-item-service")
public interface OrderItemServiceRestClient {

	/**
	 * This method would invoke /api/v1/orders/{orderId}/order-items end point. This is an POST call.
	 * @param orderId, Id of the order
	 * @param orderItems , Associate Order Item with provided order id.
	 */
	@PostMapping(value="/api/v1/orders/{orderId}/order-items")
	void createOrderItems(@PathVariable("orderId") Long orderId, @RequestBody List<OrderItemDetail> orderItems);
	
	@GetMapping(value="/api/v1/orders/{orderId}/order-items")
	List<OrderItemDetail> getOrderItemsByOrderId(@PathVariable("orderId") Long orderId);

}
