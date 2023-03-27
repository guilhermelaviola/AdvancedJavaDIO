package com.java.advanced.part2;

import java.util.function.Predicate;

// Generally predicate means a statement that determines whether a value could be true or false.
// In programming predicates mean functions with one argument that return a boolean value.
// Functional Interface Predicate was realised in Java 8.
// “Functional” means that it contains only one abstract method.
public class PredicateExample {
	public static void main(String[] args) {
		Predicate<String> isStringEmpty = String::isEmpty;
		
		// Testing it on an empty String
		System.out.println(isStringEmpty.test(""));
		// Testing it on a String with text
		System.out.println(isStringEmpty.test("The String is not empty!"));
	}
}
