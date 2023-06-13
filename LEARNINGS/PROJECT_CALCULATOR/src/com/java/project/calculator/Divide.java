package com.java.project.calculator;

public class Divide implements OperatorFunction {

	@Override
	public double getResult(Double... nums) {
		double firstElement = nums[0];
		for (int i = 1; i <= nums.length - 1; i++) {
			firstElement = firstElement / nums[i];
		}
		return firstElement;
	}

}
