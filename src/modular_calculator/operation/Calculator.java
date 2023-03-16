package modular_calculator.operation;

import modular_calculator.operation.internal.DivImpl;
import modular_calculator.operation.internal.MultImpl;
import modular_calculator.operation.internal.SubImpl;
import modular_calculator.operation.internal.SumImpl;

// Defining the calculator object
public class Calculator {

	// Variables
	public DivImpl divImpl;
	public MultImpl multImpl;
	public SubImpl subImpl;
	public SumImpl sumImpl;
	
	// Constructor
	public Calculator() {
		divImpl = new DivImpl();
		multImpl = new MultImpl();
		subImpl = new SubImpl();
		sumImpl = new SumImpl();
	}
	
	// Methods
	public int division(int x, int y) {
		return divImpl.execute(x, y);
	}
	
	public int multiplication(int x, int y) {
		return multImpl.execute(x, y);
	}
	
	public int sum(int x, int y) {
		return sumImpl.execute(x, y);
	}
	
	public int subtraction(int x, int y) {
		return subImpl.execute(x, y);
	}
	
}

