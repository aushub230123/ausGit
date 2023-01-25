package com.demo.exception;

import java.util.Scanner;

public class TryWithResourcesEx {
    public static void main(String[] args) {
//        useScanner();
        tryWithResources();
    }

    private static void useScanner() {
//         pre-java 7
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("enter num ");
            String numberString = scanner.nextLine();
            int number = Integer.parseInt(numberString);
            System.out.println("entered number multiplied " + (number*number));
            scanner.close();
//        }catch ( NumberFormatException exception) {
            System.out.println("Enter a valid number...");
        }
        catch ( Exception exception) {
            System.out.println("Unable to close scanner!");
        }
    }
    private static void tryWithResources() {
        try (Scanner scanner = new Scanner(System.in)){
            System.out.println("enter num ");
            String numberString = scanner.nextLine();
            int number = Integer.parseInt(numberString);
            System.out.println("entered number multiplied " + (number*number));
        }catch ( NumberFormatException exception) {
            System.out.println("Enter a valid number...");
        }
        catch ( Exception exception) {
            System.out.println("Unable to close scanner!");
        }
    }
}
