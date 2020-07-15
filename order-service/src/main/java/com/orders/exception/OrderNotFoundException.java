package com.orders.exception;

public class OrderNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public OrderNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
