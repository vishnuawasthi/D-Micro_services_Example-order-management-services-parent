package com.orders.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_DETAIL")
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "SEQ_ORDER_DETAIL", sequenceName = "SEQ_ORDER_DETAIL")
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ORDER_DETAIL")
	private Long id;

	private String customerName;

	private String shippingAddress;

	private Date orderDate;

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

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", customerName=" + customerName + ", shippingAddress=" + shippingAddress
				+ ", orderDate=" + orderDate + ", total=" + total + "]";
	}

}
