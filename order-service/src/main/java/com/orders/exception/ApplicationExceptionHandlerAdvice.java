package com.orders.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.orders.dto.ErrorResponseEntity;

@ControllerAdvice
public class ApplicationExceptionHandlerAdvice  extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<String> errors = new ArrayList<>();
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			FieldError field = (FieldError) error;
			errors.add( field.getField()+" " +error.getDefaultMessage());
		}
		ErrorResponseEntity errorResponseEntity = new ErrorResponseEntity();
		errorResponseEntity.setDescription(HttpStatus.BAD_REQUEST.name());
		errorResponseEntity.setStatus(400);
		errorResponseEntity.setErrors(errors);
		return new ResponseEntity<>(errorResponseEntity, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = OrderNotFoundException.class)
	public ResponseEntity<Object> OrderNotFoundException(OrderNotFoundException exception) {
		//log.info("Exception ->     {}  ", exception);
		List<String> errors = new ArrayList<>();
		ErrorResponseEntity errorResponseEntity = new ErrorResponseEntity();
		errorResponseEntity.setDescription(HttpStatus.NO_CONTENT.name());
		errorResponseEntity.setStatus(204);
		errors.add(exception.getMessage());
		errorResponseEntity.setErrors(errors);
		return new ResponseEntity<>(errorResponseEntity, HttpStatus.NO_CONTENT);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> handleDatabaseOperationFailedException(Exception exception) {
		//log.info("Exception ->     {}  ", exception);
		List<String> errors = new ArrayList<>();
		ErrorResponseEntity errorResponseEntity = new ErrorResponseEntity();
		errorResponseEntity.setDescription(exception.getMessage());
		errorResponseEntity.setStatus(503);
		errors.add(exception.getMessage());
		errorResponseEntity.setErrors(errors);
		return new ResponseEntity<>(errorResponseEntity, HttpStatus.SERVICE_UNAVAILABLE);
	}
	
}
