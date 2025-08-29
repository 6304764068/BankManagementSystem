package com.bank.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bank.entity.Customer;

@RestControllerAdvice
public class ExceptionHandlerClass {

	@ExceptionHandler
	public ResponseEntity<Object> handleCustolerAlreadyExist(CustomerAlreadyExist exception){
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.GONE);
	}
	
}
