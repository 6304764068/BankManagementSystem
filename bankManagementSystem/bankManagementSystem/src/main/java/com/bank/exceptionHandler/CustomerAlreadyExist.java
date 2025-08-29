package com.bank.exceptionHandler;

public class CustomerAlreadyExist extends RuntimeException{

	public CustomerAlreadyExist(String message){
		super(message);
	}
	
}