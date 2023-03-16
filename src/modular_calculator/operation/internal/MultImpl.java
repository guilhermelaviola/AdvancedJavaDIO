package modular_calculator.operation.internal;

import modular_calculator.Operation;

//Implementing the multiplication operation
public class MultImpl implements Operation {

	@Override
	public int execute(int x, int y) {
		return x * y;
	}

}
