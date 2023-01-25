package com.demo.exception;

public class UnhandledException {
    public static void main(String[] args) {
        String colors[] = {"Red","Green","Blue"};
        for(int i = 0; i<=3 ; i++) {
            System.out.println(colors[i]);
        }
//        program will abruptly terminate / not preferred
        System.out.println("Thank you.....");
    }
}
