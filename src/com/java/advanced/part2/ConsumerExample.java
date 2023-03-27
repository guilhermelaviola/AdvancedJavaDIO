package com.java.advanced.part2;

import java.util.function.Consumer;

// Java Consumer is a functional interface which represents an operation that accepts a single
// input argument and returns no result. Unlike most other functional interfaces, Consumer is
// expected to operate via side-effects. The Consumer's functional method is accept(Object).
public class ConsumerExample {
	
	public static void main(String[] args) {
		Consumer<String> displayAPhrase = System.out::println;
		Consumer<String> displayAnotherPhrase = phrase -> System.out.println(phrase);
		displayAPhrase.accept("Phrase");
	}
}
