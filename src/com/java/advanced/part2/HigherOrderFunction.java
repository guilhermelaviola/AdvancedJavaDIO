package com.java.advanced.part2;

// Higher-order functions are functions that either accept other functions as arguments,
// or return a function as a result. The result of one higher-order function can be used
// as the input to another higher-order function. Any time we pass a lambda expression to
// a method, that method is a higher-order function.
public class HigherOrderFunction {
	
	public static void main(String[] args) {
		Calulation sum = (a, b) -> a + b;
		System.out.println(executeOperation(sum, 10, 7));
	}
	
	public static int executeOperation(Calulation calculation, int x, int y) {
		return calculation.calculate(x, y);
	}
}

@FunctionalInterface
interface Calulation {
	public int calculate(int x, int y);
}
