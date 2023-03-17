package com.java.advanced.part1;

public class AnonymousClassFunction {

	public static void main(String[] args) {
		BasicFunction insertPrefixMrOnString = new BasicFunction() {

			@Override
			public String generate(String value) {
				return "Mr. " + value;
			}

		};
		System.out.println(insertPrefixMrOnString.generate("Joseph"));
	}
}