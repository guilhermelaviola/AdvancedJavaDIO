package com.java.advanced.part2;

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
