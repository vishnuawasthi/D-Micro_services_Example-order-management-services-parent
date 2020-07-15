package com.orders.repositories;

import org.springframework.data.repository.CrudRepository;

import com.orders.entities.ProductDetail;

public interface ProductDetailRepository extends CrudRepository<ProductDetail, Long> {

}
