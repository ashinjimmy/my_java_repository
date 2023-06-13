package com.java.project.calculator;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MainApp {

	public static void main(String[] args) {
		int x = 1;
		do {
			String inputExpression = new ReadExpression().readInputs();

			DecimalFormat decimalFormat = new DecimalFormat("###.##");

			String[] operatorArr = inputExpression.split("[0-9]+"); // Create an array of operators
			String[] numberArr = inputExpression.split("[\\-\\+\\*\\/]"); // Create an array of numbers

			Queue<String> numberQueue = new LinkedList<>(Arrays.asList(numberArr));
			Queue<String> operatorQueue = new LinkedList<>(Arrays.asList(operatorArr));

			operatorQueue.remove(); // To remove the extra white space [, +, +, +]
			Double result = Double.parseDouble(numberQueue.poll());// Fetching 1st element of the Queue
			OperatorFunction operatorFunction = null;

			while (!numberQueue.isEmpty()) {

				String operator = operatorQueue.poll();
				try {

					switch (operator) {
					case "+":
						operatorFunction = new Add();
						break;

					case "*":
						operatorFunction = new Multiply();
						break;

					case "-":
						operatorFunction = new Substract();
						break;

					case "/":
						operatorFunction = new Divide();
						break;

					default:
						System.out.println("Invalid operator choosen");
						break;
					}

					Double num2 = Double.parseDouble(numberQueue.poll()); // Fetching remaining elements
					result = operatorFunction.getResult(result, num2);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			System.out.println("\n ******** Result ****** : " + decimalFormat.format(result));
		} while (x == 1);
	}
}
