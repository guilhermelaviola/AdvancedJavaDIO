package com.java.advanced.part5;

import java.util.stream.Collectors;

public class StringExamples {
	public static void main(String[] args) {
		// String blank
		String space = " ";
		System.out.println(space.isBlank());
		
		// String repeat
		String name = "Gianluigi Buffon";
		System.out.println(name.repeat(5));
		
		// String lines
		String html = "<html>\\n<head>\\n</head>\\n <body> \\n <body> \\n<html>";
		System.out.println(html.lines().map(s -> "[TAG] ::" + s).collect(Collectors.toList()));
	}
}
