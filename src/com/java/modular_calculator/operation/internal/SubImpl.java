package com.java.modular_calculator.operation.internal;

import com.java.modular_calculator.Operation;

//Implementing the subtraction operation
public class SubImpl implements Operation {

	@Override
	public int execute(int x, int y) {
		return x - y;
	}

}
