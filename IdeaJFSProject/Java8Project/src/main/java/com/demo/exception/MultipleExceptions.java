package com.demo.exception;

public class MultipleExceptions {
    public static void main(String[] args) {
        String colors[] = {"Red","Green","Blue"};
        Calculator calculator = null;
        System.out.println("Normal Calculator");
        for(int i = 0; i<=3 ; i++) {
            System.out.println(colors[i]);
        }
        calculator.add(50,50);
        System.out.println("Thankyou!");
    }
}
