package com.example;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCartImpl implements ShoppingCart {

	private Map<Integer, Product> cart = new HashMap<>();

	@Override
	public void addItem(Product product) {
		int pid = product.getId();
		if (cart.containsKey(pid)) {
			Product existingProduct = cart.get(pid);
			existingProduct.setQty(existingProduct.getQty() + 1);
		} else {
			cart.put(pid, product);
		}
	}

	@Override
	public int countItems() {
		int count = 0;
		Collection<Product> products = cart.values();
		for (Product product : products) {
			count = count + product.getQty();
		}
		return count;

	}

	@Override
	public Collection<Product> allItems() {
		return cart.values();
	}

	@Override
	public void removeItem(int id) throws ProductNotInCartException {
		if (!cart.containsKey(id)) {
			throw new ProductNotInCartException("Product with ID : " + id + " not there in cart!!!!");
		} else {
			Product product = cart.get(id);
			if (product.getQty() == 1) {
				cart.remove(id);
			} else {
				product.setQty(product.getQty() - 1);
			}

		}
	}

	@Override
	public double totalPrice() {
		double total = 0.0;
		Collection<Product> products = cart.values();
		for (Product product : products) {
			double individualPrice = product.getQty() * product.getPrice();
			total = total + individualPrice;
		}
		return total;

	}

	@Override
	public void clearCart() {
		cart.clear();
	}
	
	@Override
	public String placeOrder() {
		return "O"+System.currentTimeMillis()+"O     ";
	}
	
	



}
