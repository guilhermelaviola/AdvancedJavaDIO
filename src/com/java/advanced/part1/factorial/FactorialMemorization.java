package com.java.advanced.part1.factorial;

import java.util.HashMap;
import java.util.Map;

public class FactorialMemorization {
	static Map<Integer, Integer> FACTORIAL_MAP = new HashMap<>();
	public static void main(String[] args) {
		long I = System.nanoTime();
		System.out.println(factorialWithMemorization(4));
		long F = System.nanoTime();
		System.out.println("FACTORIAL 1 " + (F - I));
		
		I = System.nanoTime();
		System.out.println(factorialWithMemorization(4));
		F = System.nanoTime();
		System.out.println("FACTORIAL 2 " + (F - I));
	}
	
	public static Integer factorialWithMemorization(Integer value) {
		if(value == 1) {
			return value;
		}else {
			if(FACTORIAL_MAP.containsKey(value)) {
				return FACTORIAL_MAP.get(value);
			}else {
				Integer result = value * factorialWithMemorization(value - 1);
				FACTORIAL_MAP.put(value, result);
				return result;
			}
		}
	}
}
