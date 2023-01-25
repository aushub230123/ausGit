package com.demo.exception;

public class TryFinallyEx {
	public static void main(String[] args) {
		System.err.println("do");
		int result = 0, num1, num2;
		num1 = 1000;
//		num2 = 200;
		num2 = 0;
		try {
			result = num1 / num2;
			System.err.println("here?");
		} 
		// not interested in handling the exception
//		catch (ArithmeticException exception) {
//			String messageString = exception.getMessage();
//			System.err.println("No dividing by 0 " + messageString);
//		}
//		System.out.println("can't have anything here!");
		finally {
			System.err.println("clean up");
			result = num1 = num2 = 0;
		}
		System.err.println(result);
		System.err.println("done");
	}
}
