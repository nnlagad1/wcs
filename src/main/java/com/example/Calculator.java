package com.example;
//this is comment

import java.util.concurrent.TimeUnit;

public class Calculator {

	public int sum(int valOne, int valTwo) {
		return valOne + valTwo;
	}

	public int divide(int valOne, int valTwo) {
		return valOne / valTwo;
	}
	
	public int multiply(int valOne, int valTwo) {
		// 200 DB loc
		/*try {
			TimeUnit.SECONDS.sleep(5);
		} catch (Exception e) {
		}*/
		return valOne * valTwo;
	}

}