package com.java.advanced.part1;

// A lambda expression is a short block of code which takes in parameters and returns a value.
// Lambda expressions are similar to methods, but they do not need a name and they can be 
// implemented right in the body of a method.
public class LambdaFunction {
	public static void main(String[] args) {
		// Lambda function
		BasicFunction insertPrefixMrOnString = value -> "Mr. " + value;
		System.err.println(insertPrefixMrOnString.generate("Marcus"));
	}
}
