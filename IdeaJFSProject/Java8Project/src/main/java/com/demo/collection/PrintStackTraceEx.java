package com.demo.collection;

public class PrintStackTraceEx {
	public static void main(String[] args) {
		goToUSA();
	}

	public static void goToUSA() {
		System.err.println("USA");
		goToMexico();
	}

	public static void goToMexico() {
		System.err.println("Mexico");
		int result = 0;
		try {
			result = 100 / result;
		} catch (ArithmeticException arithmeticException) {
			System.err.println(arithmeticException);
			arithmeticException.printStackTrace();
		}

	}
}