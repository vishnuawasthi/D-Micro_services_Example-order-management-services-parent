package com.orders.dto;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Order has below data: - Customer name - - Order date - Shipping address -
 * Order items - Total ($)
 * 
 * @author Vishnu Awasthi
 *
 */
@JsonInclude(value = Include.NON_NULL)
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

	private Double total;

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

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "OrderDetailDTO [id=" + id + ", customerName=" + customerName + ", shippingAddress=" + shippingAddress
				+ ", orderDate=" + orderDate + ", orderItems=" + orderItems + ", total=" + total + "]";
	}

}
