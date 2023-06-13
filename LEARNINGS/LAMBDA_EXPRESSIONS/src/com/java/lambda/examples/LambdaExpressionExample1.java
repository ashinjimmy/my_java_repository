package com.java.lambda.examples;

public class LambdaExpressionExample1 implements Shape {

	public static void main(String[] args) {

		/*
		 * Lambda expression which has no name, no return type, contains parameter list
		 * and body. Functional interface programming. If the body of the lamda
		 * expression has only one statement then there is no requirement of { .. }
		 * Lines of codes can be reduced
		 */

		Shape rectangele = () -> System.out.println("Draw the shape of a rectangle ....");
		//rectangele.draw(); // Traditional way of call
		print(rectangele); // Generalized approach to pass the lamda exppression as an argument

		//Shape square = () -> System.out.println("Draw the shape of a square  ....");
		//square.draw();
		print(() -> System.out.println("Draw the shape of a square  ....")); // This is most shortest way to do functional programming

// --------------------------------------------------------

//		Traditional method to call draw()
		Shape sh = new LambdaExpressionExample1();
		sh.draw();

	}

	/*
	 * Method overriding This is the traditional approach for the implementation of
	 * interface properties. Lines of codes are more
	 */

	@Override
	public void draw() {
		System.out.println("Draw ..");
	}

	
	/* Demonstrate how lamda expression can pass as a parameter in method.
	 * Generalized method declaration to print the functions of each lambda expressions. 
	 *  */
	private static void print(Shape shape) {
		shape.draw();
	}

}
