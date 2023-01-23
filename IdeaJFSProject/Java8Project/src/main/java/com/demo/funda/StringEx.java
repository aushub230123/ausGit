package com.demo.funda;

public class StringEx {
    public static void main(String[] args) {

        String message = "Today is Monday and Monday is actually a good day because it works for the weekend...!";
        System.out.println(message.lastIndexOf("Monday"));
        System.out.println(message.endsWith("!"));
        System.out.println(message.indexOf("well"));
        System.out.println(message.indexOf("Monday"));
        System.out.println(message.indexOf("M"));
        System.out.println(message.lastIndexOf("a"));
        System.out.println(message.length());
        System.out.println(message.substring(7,11));
        //Find out 5 string and implement them

        // Print only the characters from the String test by removing the special characters = "welcome$abc!1test";
    }
}