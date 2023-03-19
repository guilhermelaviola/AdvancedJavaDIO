package com.java.advanced.part2;

import java.util.function.Function;

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
