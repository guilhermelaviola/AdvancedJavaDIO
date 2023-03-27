package com.java.advanced.part2;

import java.util.function.Supplier;

// Supplier is a functional interface whose SAM (Single Abstract Method) is get().
// One of the most frequent use cases of this interface is to defer the execution of some code.
// The Optional class has a few methods that accept a Supplier as a parameter,
// such as Optional.or(), Optional.
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

// Person class
class Person {
	// Attributes
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