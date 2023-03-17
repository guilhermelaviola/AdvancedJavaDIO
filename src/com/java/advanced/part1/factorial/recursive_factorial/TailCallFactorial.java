package com.java.advanced.part1.factorial.recursive_factorial;

public class TailCallFactorial {
	public static void main(String[] args) {
		System.out.println(factorialA(10));
	}
	
	public static double factorialA(double value) {
		return factorialWithTailCall(value, 1);
	}
	
	public static double factorialWithTailCall(double value, double number) {
		if(value == 0) {
			return number;
		}
		return factorialWithTailCall(value - 1, number*value);
	}
}
