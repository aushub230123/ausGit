package com.demo.package1;

public class C2 {
    public static void main(String[] args) {
        C1 c1 = new C1();
//        private variables cannot be accessed by other classes in the same package.
        System.out.println(c1.testVar);
        c1.testMethod();
    }
}
