package com.java.advanced.part2;

import java.util.function.Supplier;

public class SupplierExample {
	public static void main(String[] args) {
		// Creating two instances of the Person class
		Supplier<Person> personInstance = () -> new Person();
		Supplier<Person> personInstance2 = Person::new;
		
		// Displaying both instances
		System.out.println(personInstance.get());
		System.out.println(personInstance2.get());
	}
}

class Person {
	// Person attributes
	private String name;
	private Integer age;
	
	// Constructor
	public Person() {
		name = "Andrew";
		age = 29;
	}

	// toString() method
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}