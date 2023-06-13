package com.java.project.calculator;

public class Multiply implements OperatorFunction {

	@Override
	public double getResult(Double... nums) {
		double result = 1 ;
		for (double value : nums) {
			result *= value;
		}
		return result;

	}

}
