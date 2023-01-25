package com.demo.exception;

public class ExceptionPropogation {
    public static void main(String[] args) {
        System.out.println("do");
        try {
          test();
        } catch (ArithmeticException arithmeticException) {
            System.out.println("divide by zero handled again.....");
        }
        System.out.println("done");
    }

    public static void test() {
        int i = 100;
        try {
            i/=0;
        } catch (ArithmeticException arithmeticException) {
            System.out.println("divide by zero");
//            propogate the exception / rethrow it
            System.out.println("rethrowing ....");
            throw arithmeticException;
        }
    }
}
