package com.java.advanced.part3;

// A thread in Java is the direction or path that is taken while a program is being executed.
// Generally, all the programs have at least one thread, known as the main thread, that is provided
// by the JVM (or Java Virtual Machine) at the starting of the program's execution.
public class ThreadExample {
	
	public static void main(String[] args) {
		// Creating the objects
		PDFGenerator initiatePdfGenerator = new PDFGenerator();
		LoadingBar initiateLoadingBar = new LoadingBar(initiatePdfGenerator);
		
		// Testing the methods
		initiatePdfGenerator.start();
		initiateLoadingBar.start();
	}
}

class PDFGenerator extends Thread {
	@Override
	public void run() {
		try {
			System.out.println("Starting the PDF generation...");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("PDF generated...");
	}
}

class LoadingBar extends Thread {
	private Thread initiatePdfGenerator;
	
	public LoadingBar(Thread initiatePdfGenerator) {
		this.initiatePdfGenerator = initiatePdfGenerator;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(500);
				
				if(!initiatePdfGenerator.isAlive()) {
					break;
				}
				System.out.println("Loading...");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
