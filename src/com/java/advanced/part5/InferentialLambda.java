package com.java.advanced.part5;

import java.util.function.Function;

// Type Inference states that the data type of any expression. For instance, a method return
// type or argument type can be understood automatically by the compiler.
// Types in the argument list can be omitted since java already know the types of the expected
// parameters for the single abstract method of functional interface.
public class InferentialLambda {
	public static void main(String[] args) {
		// Lambda Function that returns a number divided by 2
		Function<Integer, Double> divisionByTwo = (var number) -> number / 2.0;
		// Displaying the result
		System.out.println(divisionByTwo.apply(988));
	}
}
