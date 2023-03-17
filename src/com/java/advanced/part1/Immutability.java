package com.java.advanced.part1;

import java.util.function.UnaryOperator;

public class Immutability {
	public static void main(String[] args) {
		int value = 25;
		UnaryOperator<Integer> returnTripled = v -> v * 3;
		// Displaying the original value
		System.out.println(value);
		// Displaying the value tripled
		System.out.println(returnTripled.apply(value));
	}
}
