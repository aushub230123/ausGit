package com.demo.exception;

public class HandledException {
        public static void main(String[] args) {
            String colors[] = {"Red","Green","Blue"};
            // bounds 0 - 2
            for(int i = 0; i<=3 ; i++) {
                try {
                    System.out.println(colors[i]);

                }
                catch(Error arrayIndexOutOfBoundsException){
                    System.out.println("Please check array index, does this work?");
                }
                catch(Throwable arrayIndexOutOfBoundsException){
                    System.out.println("Please check array index : from Throwable!");
                }
//                System.out.println("Thanks!");
            }
            System.out.println("Thanks!");
            System.out.println("Thank you.....");
        }
}
