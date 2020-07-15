package com.orders.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_DETAIL")
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "SEQ_PRODUCT_DETAIL", sequenceName = "SEQ_PRODUCT_DETAIL")
public class ProductDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRODUCT_DETAIL")
	private Long id;

	@Column(unique = true)
	private String productCode;

	@Column
	private String productName;

	@Column
	private Double price;

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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductDetail [productCode=" + productCode + ", productName=" + productName + ", price=" + price + "]";
	}

}
