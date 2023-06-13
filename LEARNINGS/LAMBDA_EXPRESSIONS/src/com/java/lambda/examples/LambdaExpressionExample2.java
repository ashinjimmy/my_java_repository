package com.java.lambda.examples;

public class LambdaExpressionExample2 {

	public static void main(String[] args) {

		Addition sum = (a, b) -> (a + b); // Lambda expression
		int total = sum.sumOfTwoNums(10, 20);
		print(total);
	}

	private static void print(int total) {
		System.out.println("sum of two numbers are --- " + total);
	}

}
