package com.java.advanced.part1.factorial.recursive_factorial;

public class RecursiveFactorial {
	public static void main(String[] args) {
		System.out.println(factorial(4));
	}
	
	public static int factorial(int value) {
		if(value == 1) {
			return value;
		}else {
			return value * factorial(value - 1);
		}
	}
}
