package com.java.advanced.part2;

import java.util.function.Predicate;

public class PredicateExample {
	public static void main(String[] args) {
		Predicate<String> isStringEmpty = String::isEmpty;
		
		// Testing it on an empty String
		System.out.println(isStringEmpty.test(""));
		// Testing it on a String with text
		System.out.println(isStringEmpty.test("The String is not empty!"));
	}
}
