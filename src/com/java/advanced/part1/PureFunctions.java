package com.java.advanced.part1;

import java.util.function.BiPredicate;

public class PureFunctions {

	public static void main(String[] args) {
		BiPredicate<Integer, Integer> checkIfIsLarger = (parameter, comparisonValue) -> parameter > comparisonValue;
		
		// Must return true
		System.out.println(checkIfIsLarger.test(15, 10));
		// Must return false
		System.out.println(checkIfIsLarger.test(8, 21));
	}
}
