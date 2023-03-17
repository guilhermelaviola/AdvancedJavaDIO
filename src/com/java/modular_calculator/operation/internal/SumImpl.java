package com.java.modular_calculator.operation.internal;

import com.java.modular_calculator.Operation;

//Implementing the sum operation
public class SumImpl implements Operation{

	@Override
	public int execute(int x, int y) {
		return x + y;
	}

}
