package com.java.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// Test class (There's a connection error)
public class Test {
	
	public static void main(String[] args) throws IOException {
		Socket echoSocket = new Socket("localhost", 10000);

		PrintWriter output = new PrintWriter(echoSocket.getOutputStream(), true);
		BufferedReader input = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
		
		output.println(" <isomsg>\\n\" +\r\n"
				+ "                \"  <field id=\\\"0\\\" value=\\\"0800\\\" />\\n\" +\r\n"
				+ "                \"  <field id=\\\"3\\\" value=\\\"000000\\\" />\\n\" +\r\n"
				+ "                \"  <field id=\\\"11\\\" value=\\\"000001\\\" />\\n\" +\r\n"
				+ "                \"  <field id=\\\"41\\\" value=\\\"00000001\\\" />\\n\" +\r\n"
				+ "                \"  <field id=\\\"70\\\" value=\\\"901\\\" />\\n\" +\r\n"
				+ "                \" </isomsg>\\n");
		input.lines()
					.forEach(System.out::println);
		echoSocket.close();
	}
}
