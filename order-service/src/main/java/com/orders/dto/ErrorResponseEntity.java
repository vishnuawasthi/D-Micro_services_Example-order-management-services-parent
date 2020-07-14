package com.orders.dto;

import java.util.List;

public class ErrorResponseEntity {

	private int status;

	private String description;

	private List<String> errors;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		return "ErrorResponseEntity [status=" + status + ", description=" + description + ", errors=" + errors + "]";
	}

}
