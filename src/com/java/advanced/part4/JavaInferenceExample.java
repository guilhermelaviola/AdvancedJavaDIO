package com.java.advanced.part4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

// Usage of the var keyword
//var keyword CAN be used:
	// - As local and initiated variables;
	// - Supporting variable of the enhanced for;
	// - Supporting variable of iterative for;
	// - try variable with resource.
		
	// and CANNOT be used:
	// - At a class level;
	// - As a parameter;
	// - In local non-initialized variables.

public class JavaInferenceExample {
	
	public static void main(String[] args) {
		// Testing the methods
		connectAndPrintURLJavaOracle();
		displayFullName("Giuseppe", "Mazzarri");
		displaySum(12, 23, 3);
	}
	
	// Displaying a web page HTM code
	private static void connectAndPrintURLJavaOracle() {
		try {
			var url = new URL("https://docs.oracle.com/javase/17/language/");
			var urlConnection = url.openConnection();
			
			try(var bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))){
				System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Displaying full name, given the parameter first and last name
	public static void displayFullName(String firstName, String lastName) {
		var fullName = String.format("%s %s", firstName, lastName);
		System.out.println(fullName);
	}
	
	//  Displaying the sum values
	public static void displaySum(int... numbers) {
		int sum;
		if(numbers.length > 0) {
			sum = 0;
			for(var number = 0; number < numbers.length; number++) {
				sum += numbers[number];
			}
			System.out.println("The sum is: " + sum);
		}
	}
}
