package com.java.lambda.examples;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class PredefinedFunctionalInterfaceExample {

	public static void main(String[] args) {
		
		/* Function<T,R> is a predefined interface provided by Java 8.
		 * T - Input type
		 * R - Output type
		 * R apply(T t) - is a method which take only one argument and return the function result of type R
		 * */
		Function<String,Integer> function = (s) -> s.length();
		System.out.println("The length of the name Ashin Jimmy is "+function.apply("Ashin Jimmy"));
		
		
//  Consumer interface 
//	provides accept method which takes particular type of input and return specific output	
		
		Consumer<String> consumer = (inputData) -> System.out.println(inputData);
		consumer.accept("Consumer interface implementation using lambda expression --- ");
		
		
//	Supplier interface
//	provides get method which don't take any input but supply output	
		
		Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();
		System.out.println("Current date and time is -- "+supplier.get());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		System.out.println("Formatted current date and time is -- "+formatter.format(supplier.get()));
		
		
		
//		Runnable interface using lambda expression
		
		Runnable runnable = () -> System.out.println("Implementing runnable interface ---- ");
		Thread thread =  new Thread(runnable);
		thread.start();
		
	}
	
}
