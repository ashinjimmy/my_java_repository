package com.java.project.calculator;

import java.util.Scanner;

public class ReadExpression {

	String readInputs() {
		
		System.out.println("\n==========================");
		System.out.println("    MY CALCULATOR APP     ");
		System.out.println("==========================");
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the expression to calculate, reference -- (400*3/2+10-100) :");
		String expression = input.next();
		return expression;
	}
	
}
