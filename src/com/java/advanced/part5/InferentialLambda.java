package com.java.advanced.part5;

import java.util.function.Function;

public class InferentialLambda {
	
	public static void main(String[] args) {
		Function<Integer, Double> divisionByTwo = (var number) -> number / 2.0;
		
		System.out.println(divisionByTwo.apply(988));
	}
}
