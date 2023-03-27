package com.java.advanced.part1;

// Anonymous classes are inner classes with no name.
// Since they have no name, we can't use them in order to create instances
// of anonymous classes. As a result, we have to declare and instantiate
// anonymous classes in a single expression at the point of use.
public class AnonymousClassFunction {

	// In this case, we are displaying a name with the prefix 'Mr'
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