package com.java.advanced.part2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// In Java, iteration is a technique used to sequence through a block of code repeatedly
// until a specific condition either exists or no longer exists. Iterations are a very
// common approach used with loops.
public class IterationsExample {
	
	public static void main(String[] args) {
		// Creating lists of Strings and Integers
		String[] names = {"Andrew", "Joseph", "Steven", "Marcus" };
		Integer[] numbers = {12, 18, 23, 8, 44};
		
		// Testing
		displayFilteredNames(names);
		displayAllNames(names);
		displayTheDoubleOfEachName(numbers);
		
		List<String> professions = new ArrayList<>();
		professions.add("Professor");
		professions.add("Software Developer");
		professions.add("Dentist");
		professions.add("Software Engineer");
		professions.add("Actor");
		
		professions.stream().filter(profession -> profession.startsWith("Software"))
		.forEach(System.out::println);
	}
	
	public static void displayFilteredNames(String... names) {
		
		String namesToBeDisplayed = "";
		for(int i = 0; i < names.length; i++) {
			if(names[i].equals("John")) {
				namesToBeDisplayed += names[i];
			}
		}
		
		String namesToBePrintedFromStream = Stream.of(names)
				.filter(name -> name.equals("John"))
				.collect(Collectors.joining());
		
		System.out.println("Names from Stream: " + namesToBePrintedFromStream);
		
		String nameResults = Stream.of(names)
				.filter(name -> name.equals("John"))
				.collect(Collectors.joining());
		System.out.println(nameResults);
	}
	
	public static void displayAllNames(String... names) {
		for(String name : names) {
			System.out.println("Displaying names " + name);
						
		}
		
		Stream.of(names)
		.forEach(name -> System.out.println("Displaying by forEach: " + name));
	}
	
	public static void displayTheDoubleOfEachName(Integer... numbers) {
		for(Integer number : numbers) {
			System.out.println(number * 2);
		}
		
		Stream.of(numbers).map(number -> number * 2).forEach(System.out::println);
	}
}
