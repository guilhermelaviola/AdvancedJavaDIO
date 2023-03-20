package com.java.advanced.part2;

import java.util.function.Consumer;

public class ConsumerExample {
	
	public static void main(String[] args) {
		Consumer<String> displayAPhrase = System.out::println;
		Consumer<String> displayAnotherPhrase = phrase -> System.out.println(phrase);
		displayAPhrase.accept("Phrase");
	}
}
