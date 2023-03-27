package com.java.advanced.part1;

import java.util.Arrays;

//Using Streams in an Array
public class FunctionComposition {
	public static void main(String[] args) {
		
		// Array of numbers
		int[] values = {2, 5, 7, 6};
		
		// Functional programming
		// Filtering numbers with mod = 0 (which in this case are 2 and 6)
		// Mapping them (multiplying by 2)
		// And finally displaying the result
		Arrays.stream(values)
				.filter(number -> number % 2 == 0)
				.map(number -> number * 2)
				.forEach(number -> System.out.println(number));
	}
}
