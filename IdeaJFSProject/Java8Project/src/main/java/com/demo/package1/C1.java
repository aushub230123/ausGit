package com.demo.package1;

public class C1 {
//    HIGHEST LEVEL OF ENCAPSULATION
      protected String  testVar = "test";
      protected void testMethod() {
        System.out.println("testMethod");
    }
    public static void main(String[] args) {
        C1 c1 = new C1();
        System.out.println(c1.testVar);
        c1.testMethod();
    }
}
