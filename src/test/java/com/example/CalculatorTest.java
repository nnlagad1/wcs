package com.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CalculatorTest {

	Calculator cal = null;

	@Before
	public void init() {
		System.out.println("Inside init!!!!");
		cal = new Calculator();
	}

	@After
	public void clean() {
		System.out.println("Inside clean!!!!");
		cal = null;
	}

	@Test(timeout = 4)
	public void divideTwoPositiveNumbersForSLA() {
		cal.divide(150, 10);
	}

	@Test(expected = ArithmeticException.class)
	public void divideByZeroForException() {
		// Calculator cal = new Calculator();
		cal.divide(15, 0);
	}

	@Test
	public void divideTwoPositiveNumbers() {
		// Calculator cal = new Calculator();
		Assert.assertEquals(3, cal.divide(15, 5));
	}

	@Test
	public void addTwoNegativeNumbers() {
		// Calculator cal = new Calculator();
		int rs = cal.sum(-15, -5);
		Assert.assertEquals(-20, rs);
	}

	@Test
	public void addTwoPositiveNumbers() {
		// Calculator cal = new Calculator();
		int rs = cal.sum(15, 5);
		Assert.assertEquals(20, rs);
	}

	@Test
	public void addPositiveAndNegativeNumber() {
		// Calculator cal = new Calculator();
		int rs = cal.sum(15, -5);
		Assert.assertEquals(10, rs);
	}

	@Test(expected = AssertionError.class)
	public void addTwoBigPositiveNumbersForBoundry() {
		// Calculator cal = new Calculator();
		int rs = cal.sum(171818181, 272727272);
		Assert.assertTrue("SUM is beyond boundry value!!!!!", Integer.MAX_VALUE <= rs);
	}
	
	@Test
	public void multiPleWithZero() {
		int rs=cal.multiply(15, 0);
		Assert.assertEquals(0, rs);
	}
	
	@Test
	public void divideTwoPositiveNumbers() {
		// Calculator cal = new Calculator();
		Assert.assertEquals(10, cal.divide(150, 5));
	}

}