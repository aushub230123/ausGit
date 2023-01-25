package com.demo.exception;

public class NullPointerExceptionEx {
    public static void main(String[] args) {
//        IP : Hanlde NullPointerException
        Calculator calculator = null;
        try{
            calculator.add(50,50);
            System.out.println("Normal Calculator");
        }
      catch(NullPointerException nullPointerException) {
          System.out.println("Ensure that you have created and instance using new keyword");
          calculator = new Calculator();
      }
        calculator.add(60,50);
    }
}

