package com.java.methodreference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReferenceDemo {
	
	public static int add(int a, int b) {
		return a+b;
	}
	
	public  void display(String msg) {
		msg = msg.toUpperCase();
		System.out.println("Display the message in upper case -- "+msg);
	}
	

	
	public static void main(String[] args) {
		
//		1. Method reference to the static method  ******************************
		
//		Find the square root of the number using lambda expression
		
		Function<Integer, Double> funtion = (input) -> Math.sqrt(input);
		System.out.println("Square root of the number using lambda expression --"+funtion.apply(10));
		
//		Find the square root of the number using method reference
		
		Function<Integer, Double> functionMethodRefrnce = Math::sqrt;
		System.out.println("Square root of the number using method reference -- "+functionMethodRefrnce.apply(10));
		
		
		
//		Calculating the sum of two numbers using lambda expression 
		
		BiFunction<Integer, Integer, Integer> bifunctionLam = (a,b) -> a+b;
		System.out.println("Addition of two numbers using lambda expression -- "+bifunctionLam.apply(10, 20));
	
//		Calculating the sum of two numbers using method reference
		
		BiFunction<Integer, Integer, Integer> bifunction = MethodReferenceDemo::add;
		System.out.println("Addition of two numbers using method reference -- "+bifunction.apply(10, 20));
		
	
// 	  2. Method reference to an instance method of an object  ******************************
		
		MethodReferenceDemo methodReferenceDemo =  new MethodReferenceDemo();
		
//		Lambda expression 
	Printable printMsg = (msg) -> methodReferenceDemo.display(msg);
	printMsg.print("Hello World ...");
	
//	Method Reference 
	Printable printMsg2 = methodReferenceDemo::display;
	printMsg2.print("New World ..");
	
	
//	3. Reference to the instance method of an arbitrary object  ******************************
		/* Sometimes we call the method of the argument in the lambda expression
		 * in such cases we can use method reference to call an instance method of 
		 * an arbitrary object of specific type */ 
	
//	Using lambda expression
	Function<String, String> functionLambda =  (String input) -> input.toLowerCase();
	System.out.println(functionLambda.apply("Java Rocks -- "));

//	Using method reference
	Function<String , String> functionMethodReference = String::toLowerCase;
	System.out.println(functionMethodReference.apply("Java Rocks !!"));
	
//	Example 
	
	String [] arr = {"A","d","x","C","b","D","a","B","c"};
	
//	Using lambda expression
	Arrays.sort(arr, (s1,s2) -> s1.compareToIgnoreCase(s2));
	System.out.println(Arrays.toString(arr));
	
//	Using method reference 
	Arrays.sort(arr, String::compareToIgnoreCase);
	System.out.println(Arrays.toString(arr));
	
	
// 4.	Reference to a constructor ******************************
	
	List<String> subjects = new ArrayList<String>();
	subjects.add("Engg Matematics");
	subjects.add("Software Engg");
	subjects.add("Data Science");
	subjects.add("Cloud Computing");
	subjects.add("Database Management");
	subjects.add("Software Engg");
	subjects.add("Network Security");
	
	System.out.println("List -- "+subjects);
	
//	Using lambda expression to convert a list of data into a set of data 
	
	Function<List<String>, Set<String>> functionalLambda =  (subjectsList) -> new HashSet<String>(subjectsList);
	System.out.println("Set L E -- "+functionalLambda.apply(subjects));
	
//	Using method reference to convert a list of data into a set of data
	
	Function<List<String>, Set<String>> functionalMethodRef = HashSet::new;
	System.out.println("Set using M R "+functionalMethodRef.apply(subjects));
	
	}
	
}
