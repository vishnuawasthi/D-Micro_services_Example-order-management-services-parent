package com.orders.restclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.orders.dto.OrderItemDetail;

@FeignClient(name = "order-item-service", url = "localhost:8091")
public interface OrderItemServiceRestClient {

	@PostMapping("/api/v1/orders/{orderId}/order-items")
	void createOrderItems(@PathVariable("orderId") Long orderId, @RequestBody List<OrderItemDetail> orderItems);

}
