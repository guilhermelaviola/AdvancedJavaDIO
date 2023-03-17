package com.java.modular_calculator;

import com.java.modular_calculator.operation.Calculator;

// Testing the calculator
public class Main {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		
		System.out.println("TESTING:");
		System.out.println("Sum: (2 + 2): " + calculator.sum(2, 2));
		System.out.println("Subtraction: (5 - 3): " + calculator.subtraction(5, 3));
		System.out.println("Multiplication: (2 * 5): " + calculator.multiplication(2, 2));
		System.out.println("Division: (8 / 2): " + calculator.division(8, 2));
	}
	
}
