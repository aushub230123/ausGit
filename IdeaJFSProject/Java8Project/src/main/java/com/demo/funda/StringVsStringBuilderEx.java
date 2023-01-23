package com.demo.funda;

public class StringVsStringBuilderEx {
    public static void main(String[] args) {
        concatString();
        concatStringBuffer();
        concatStringBuilder();
    }

    private static void concatString() {
        System.out.println("String .....");
        String testString = "S";
        long startTime = System.currentTimeMillis();
        for(int i = 1; i<50001; i++) {
            testString +=i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time Taken : " + (endTime - startTime));
    }
    private static void concatStringBuilder() {
        System.out.println("String .....");
        StringBuilder stringBuilder = new StringBuilder();
        long startTime = System.currentTimeMillis();
        for(int i = 1; i<50001; i++) {
           stringBuilder.append(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time Taken : " + (endTime - startTime));
    }
    private static void concatStringBuffer() {
        System.out.println("String .....");
        StringBuffer stringBuffer = new StringBuffer();
        long startTime = System.currentTimeMillis();
        for(int i = 1; i<50001; i++) {
            stringBuffer.append(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time Taken : " + (endTime - startTime));
    }
}
