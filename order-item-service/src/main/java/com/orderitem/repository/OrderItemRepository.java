package com.orderitem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.orderitem.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

	@Query(" SELECT orderItem FROM OrderItem orderItem WHERE orderItem.orderId =:id")
	List<OrderItem> findAllOrderItemsByOrderId(@Param(value = "id") Long orderId);
}
