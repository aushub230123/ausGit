package com.demo.exception;
public class ExceptionPropogationEx {
	public static void main(String[] args) {
		System.err.println("do");
		//main caller / divide called
//		unHandled();
		try {
			unHandled();
		} catch (ArithmeticException exception) {
			String messageString = exception.getMessage();
			System.err.println("No dividing by 0 " + messageString);
		}
		System.err.println("done");
	}
	// may throw ArithmeticException / caller to handle
	private static void unHandled() throws ArithmeticException{
		//IP handle exception here
		System.err.println("do unHandled");
		unHandled1();
		System.err.println("done unHandled");
	}
	// may throw ArithmeticException / caller to handle
	private static void unHandled1() throws ArithmeticException{
		System.err.println("do unHandled1");
		// raising exception
		int result = 100/0;
//		ArithmeticException arithmeticException = new ArithmeticException();
//		throw arithmeticException;
		System.err.println("done unHandled1");
	}
}