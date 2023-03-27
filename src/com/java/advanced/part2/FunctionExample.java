package com.java.advanced.part2;

import java.util.function.Function;

// Represents a function that accepts one argument and produces a result.
// This is a functional interface whose functional method is apply(Object).
public class FunctionExample {
	public static void main(String[] args) {
		// Defining basic functions with the Function class
		Function<String, String> displayNameInverted = text -> new StringBuilder(text).reverse().toString();
		Function<String, Integer> convertStringToIntAndCalculateTheDouble = string -> Integer.valueOf(string) * 2;
		
		// Testing the Functions
		System.out.println(displayNameInverted.apply("Andrea"));
		System.out.println(convertStringToIntAndCalculateTheDouble.apply("100"));
	}
}
