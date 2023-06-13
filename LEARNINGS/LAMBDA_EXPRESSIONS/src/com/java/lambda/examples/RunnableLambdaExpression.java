package com.java.lambda.examples;

public class RunnableLambdaExpression {

	public static void main(String[] args) {

		/*
		 * Runnable interface contains an abstract method run();
		 * 
		 * Traditional method -- present class implements Runnable interface -- override
		 * the run method by giving some implementations. Then call the constructor of
		 * the Tread class and pass the
		 * 
		 */

		Runnable runnable = () -> System.out.println("Lambda expression to call runnable interface");

		Thread th = new Thread(runnable);
		th.start();

	}

}
