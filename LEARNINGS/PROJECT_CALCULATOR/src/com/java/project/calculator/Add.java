package com.java.project.calculator;

public class Add implements OperatorFunction {

	@Override
	public double getResult(Double... nums) {
		double result = 0;
		for (double value : nums) {
			result += value;
		}
		return result;
	}

}
