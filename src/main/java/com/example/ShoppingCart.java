package com.example;

import java.util.Collection;

public interface ShoppingCart {

	void addItem(Product product);

	int countItems();

	Collection<Product> allItems();

	void removeItem(int id) throws ProductNotInCartException;

	double totalPrice();

	void clearCart();

	String placeOrder();

}