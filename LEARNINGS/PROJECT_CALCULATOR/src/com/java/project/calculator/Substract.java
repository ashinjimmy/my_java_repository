package com.java.project.calculator;

public class Substract implements OperatorFunction {

	@Override
	public double getResult(Double... nums) {
		double result = nums[0];
		for (int i = 1; i <= nums.length-1 ; i++) {
			result = result - nums[i];
		}
		return result;
	}

}
