package com.java.advanced.part3;

import java.util.stream.IntStream;

public class ParallelStreamExample {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		IntStream.range(1, 100000).forEach(number -> factorial(number));
		long ending = System.currentTimeMillis();
		
		start = System.currentTimeMillis();
		IntStream.range(1, 100000).parallel().forEach(number -> factorial(number));
		ending = System.currentTimeMillis();
		System.out.println("Execution time in Parallel: " + (ending - start));
	}
	
	public static long factorial(long number) {
		long fact = 1;
		
		for(long i = 2; i <= number; i++) {
			fact *= i;
		}
		return fact;
	}
}
