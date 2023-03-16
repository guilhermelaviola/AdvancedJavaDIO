package modular_calculator.operation.internal;

import modular_calculator.Operation;

// Implementing the division operation
public class DivImpl implements Operation {

	@Override
	public int execute(int x, int y) {
		return x / y;
	}

}
