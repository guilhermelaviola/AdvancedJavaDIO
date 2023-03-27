package com.java.advanced.part1;

import java.util.function.BiPredicate;

// A function is a pure function if: The execution of the function has no side effects.
//The return value of the function depends only on the input parameters passed to the function.
public class PureFunctions {
	public static void main(String[] args) {
		// BiPredicate is a functional interface in Java that accepts two inputs and can return
		// a boolean value. It is similar to the Predicate interface. The only difference is that
		// it takes two inputs instead of one.
		BiPredicate<Integer, Integer> checkIfIsLarger = (parameter, comparisonValue) -> parameter > comparisonValue;
		// Must return true
		System.out.println(checkIfIsLarger.test(15, 10));
		// Must return false
		System.out.println(checkIfIsLarger.test(8, 21));
	}
}
