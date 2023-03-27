package com.java.advanced.part1;

import java.util.function.UnaryOperator;

// An immutable object is an object whose internal state remains constant
// after it has been entirely created. 
// This means that the public API of an immutable object guarantees us that
// it will behave in the same way during its whole lifetime.
public class Immutability {
	public static void main(String[] args) {
		int value = 25;
		// In Java, the unary operator is an operator that can be used only with an operand.
		// It is used to represent the positive or negative value, increment/decrement the
		// value by 1, and complement a Boolean value.
		UnaryOperator<Integer> returnTripled = v -> v * 3;
		// Displaying the original value
		System.out.println(value);
		// Displaying the value tripled
		System.out.println(returnTripled.apply(value));
	}
}
