package com.orders.dto;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Order has below data: - Customer name - - Order date - Shipping address -
 * Order items - Total ($)
 * 
 * @author Vishnu Awasthi
 *
 */
public class OrderDetailDTO {

	private Long id;

	@NotEmpty
	private String customerName;

	@NotEmpty
	private String shippingAddress;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date orderDate;

	@NotNull
	@Valid
	private List<OrderItemDetail> orderItems;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public List<OrderItemDetail> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemDetail> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "OrderDetailDTO [id=" + id + ", customerName=" + customerName + ", shippingAddress=" + shippingAddress
				+ ", orderDate=" + orderDate + ", orderItems=" + orderItems + "]";
	}

}
