package com.demo.funda;

public class StringEqualsVsIdenticalEx {
    public static void main(String[] args) {
//        == compares for being identical (identical means equal and identical)
//        equals compares value
//        same memory location in string constant pool
//        String arlan = "Arlan";
//        String cute = "Arlan";

//      two different memory locations are created. (heap memory)
        String arlan = new String("Arlan");
        String cute = new String("Arlan");

        if(arlan == cute) {
            System.out.println("Both are the same person.");
            System.out.println("Identical");
        }
        else {
            System.out.println("Not identical");
            System.out.println("Both are different persons");
        }
        if(arlan.equals(cute)) {
            System.out.println("Equal");
            System.out.println("Both are the same person.");
        }
        else {
            System.out.println("Not Equal");
            System.out.println("Both are different persons");
        }
    }
}
