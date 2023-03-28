package com.java.advanced.part3;

import java.util.stream.IntStream;

// Any stream in Java can easily be transformed from sequential to parallel.
// We can achieve this by adding the parallel method to a sequential stream or by
// creating a stream using the parallelStream method of a collection.
// Parallel streams enable us to execute code in parallel on separate cores.
// The final result is the combination of each individual outcome.
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
