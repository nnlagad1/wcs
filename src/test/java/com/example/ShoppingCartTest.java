package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ShoppingCartTest {

	ShoppingCart shoppingCart = null;

	@Before
	public void init() {
		shoppingCart = new ShoppingCartImpl();
	}

	@After
	public void clean() {
		shoppingCart = null;

	}

	@Test
	public void checkForOrderPlacedSuccessfully() {
		
		Product laptop = new Product(100, "Laptop", 1200.00, 1);
		Product watch = new Product(101, "Watch", 8000.00, 1);
		Product mobile = new Product(102, "Mobile", 20000.00, 1);

		shoppingCart.addItem(laptop);
		shoppingCart.addItem(watch);
		shoppingCart.addItem(mobile);
		shoppingCart.addItem(mobile);

		assertNotNull(shoppingCart.placeOrder());
		assertTrue(shoppingCart.placeOrder().length() > 5);
		assertTrue(shoppingCart.placeOrder().startsWith("O"));

	}

	@Test
	public void checkForCartEmptyOrNot() {
		Product laptop = new Product(100, "Laptop", 1200.00, 1);
		Product watch = new Product(101, "Watch", 8000.00, 1);
		Product mobile = new Product(102, "Mobile", 20000.00, 1);

		shoppingCart.addItem(laptop);
		shoppingCart.addItem(watch);
		shoppingCart.addItem(mobile);
		shoppingCart.addItem(mobile);
		shoppingCart.clearCart();

		assertTrue(shoppingCart.countItems() == 0);

	}

	@Test
	public void checkForTotalPriceShouldbeAccurate() {
		Product laptop = new Product(100, "Laptop", 1200.00, 1);
		Product watch = new Product(101, "Watch", 8000.00, 1);
		Product mobile = new Product(102, "Mobile", 20000.00, 1);

		shoppingCart.addItem(laptop);
		shoppingCart.addItem(watch);
		shoppingCart.addItem(mobile);
		shoppingCart.addItem(mobile);

		assertEquals(49200.00, shoppingCart.totalPrice(), 2);

	}

	@Test(expected = ProductNotInCartException.class)
	public void removeNoNExistanceItemFromCartShouldGiveError() throws ProductNotInCartException {
		Product laptop = new Product(100, "Laptop", 1200.00, 1);
		Product watch = new Product(101, "Watch", 8000.00, 1);
		Product mobile = new Product(102, "Mobile", 20000.00, 1);

		shoppingCart.addItem(laptop);
		shoppingCart.addItem(watch);
		shoppingCart.addItem(mobile);
		shoppingCart.addItem(mobile);

		shoppingCart.removeItem(105);

	}

	@Test
	public void removeLaptopShouldRemoveLaptopOnly() {
		Product laptop = new Product(100, "Laptop", 1200.00, 1);
		Product watch = new Product(101, "Watch", 8000.00, 1);
		Product mobile = new Product(102, "Mobile", 20000.00, 1);

		shoppingCart.addItem(laptop);
		shoppingCart.addItem(watch);
		shoppingCart.addItem(mobile);
		shoppingCart.addItem(mobile);

		int oldCartSize = shoppingCart.countItems();
		try {
			shoppingCart.removeItem(100);
			Collection<Product> products = shoppingCart.allItems();
			for (Product productValue : products) {
				assertNotEquals(100, productValue.getId());
			}
		} catch (ProductNotInCartException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void removeMultipleItemsFromCartShouldReduceSize() {
		Product laptop = new Product(100, "Laptop", 1200.00, 1);
		Product watch = new Product(101, "Watch", 8000.00, 1);
		Product mobile = new Product(102, "Mobile", 20000.00, 1);

		shoppingCart.addItem(laptop);
		shoppingCart.addItem(laptop);
		shoppingCart.addItem(watch);
		shoppingCart.addItem(mobile);
		shoppingCart.addItem(mobile);

		int oldCartSize = shoppingCart.countItems();
		try {
			shoppingCart.removeItem(100);
			shoppingCart.removeItem(101);
			assertEquals(2, (oldCartSize - shoppingCart.countItems()));

		} catch (ProductNotInCartException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void removeItemFromCartShouldReduceSizeByOne() {
		Product laptop = new Product(100, "Laptop", 1200.00, 1);
		Product watch = new Product(101, "Watch", 8000.00, 1);
		Product mobile = new Product(102, "Mobile", 20000.00, 1);

		shoppingCart.addItem(laptop);
		shoppingCart.addItem(laptop);
		shoppingCart.addItem(watch);
		shoppingCart.addItem(mobile);
		shoppingCart.addItem(mobile);

		int oldCartSize = shoppingCart.countItems();
		try {
			shoppingCart.removeItem(101);
			assertEquals(1, (oldCartSize - shoppingCart.countItems()));

		} catch (ProductNotInCartException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void cartShouldNotbeNull() {
		assertNotNull(shoppingCart.allItems());
	}

	@Test
	public void countItemsShouldReturnZeroItemsInEmptyCart() {
		assertEquals(0, shoppingCart.countItems());
	}

	@Test
	public void addMultipleItemsInCart() {
		Product laptop = new Product(100, "Laptop", 1200.00, 1);
		Product watch = new Product(101, "Watch", 8000.00, 1);
		Product mobile = new Product(102, "Mobile", 20000.00, 1);

		shoppingCart.addItem(laptop);
		shoppingCart.addItem(watch);
		shoppingCart.addItem(mobile);
		shoppingCart.addItem(mobile);
		shoppingCart.addItem(mobile);

		assertEquals(5, shoppingCart.countItems());
	}

	@Test
	public void addOneItem() {
		Product product = new Product(100, "Laptop", 1200.00, 1);
		shoppingCart.addItem(product);
		assertEquals(1, shoppingCart.countItems());
	}

	@Test
	public void addAndCheckForAddedProductInCart() {
		Product product = new Product(100, "Laptop", 1200.00, 1);
		shoppingCart.addItem(product);
		Collection<Product> products = shoppingCart.allItems();
		for (Product productValue : products) {
			assertEquals(100, productValue.getId());
			assertTrue(productValue.getName().equals("Laptop"));
		}
	}

}