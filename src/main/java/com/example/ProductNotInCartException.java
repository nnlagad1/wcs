package com.example;

public class ProductNotInCartException extends Exception{

	public ProductNotInCartException(String message) {
		super(message);
	}
	public ProductNotInCartException() {
		// TODO Auto-generated constructor stub
	}
}
