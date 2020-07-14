package com.orders.repositories;

import org.springframework.data.repository.CrudRepository;

import com.orders.entities.OrderDetail;

public interface OrderDetailRepository  extends CrudRepository<OrderDetail, Long>{

}
