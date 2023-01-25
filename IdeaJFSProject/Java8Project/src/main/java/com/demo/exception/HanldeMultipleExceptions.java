package com.demo.exception;

public class HanldeMultipleExceptions {
    public static void main(String[] args) {
        String colors[] = {"Red","Green","Blue"};
        Calculator calculator = null;
        System.out.println("Normal Calculator");
        try {
            for (int i = 0; i <= 3; i++) {
                System.out.println(colors[i]);
            }
            calculator.add(50, 50);
        }
//        System.out.println("compile time error!");
//      IP one catch block for handling both the exceptions
        catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException)
        {
            System.out.println("Check index...");
        }
        catch(NullPointerException nullPointerException){
            System.out.println("Instantiate the calculator....");
        }
        System.out.println("Thankyou!");
    }
}
