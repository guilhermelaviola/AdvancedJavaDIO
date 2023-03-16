package modular_calculator.operation.internal;

import modular_calculator.Operation;

//Implementing the subtraction operation
public class SubImpl implements Operation {

	@Override
	public int execute(int x, int y) {
		return x - y;
	}

}
