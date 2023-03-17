package com.java.advanced.part1;

public class LambdaFunction {
	public static void main(String[] args) {
		BasicFunction insertPrefixMrOnString = value -> "Mr. " + value;
		System.err.println(insertPrefixMrOnString.generate("Marcus"));
	}
}
