package com.orders.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class OrderItemDetail {

	@NotEmpty
	private String productCode;

	@NotEmpty
	private String productName;

	@NotNull
	private Long quantity;

	@NotNull
	private Double price;

	public OrderItemDetail() {
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderItemDetail [productCode=" + productCode + ", productName=" + productName + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}

}
