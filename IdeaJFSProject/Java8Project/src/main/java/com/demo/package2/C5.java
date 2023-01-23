package com.demo.package2;

import com.demo.package1.C1;

public class C5 extends C1 {

    public static void main(String[] args) {
//        C1 c1 = new C1();
//        private variables cannot be accessed by other classes in the same package.
//        System.out.println(c1.testVar);
//        c1.testMethod();
        C5 c5 = new C5();
        System.out.println(c5.testVar);
        c5.testAccess();
        c5.testAccess();
    }
    public void testAccess() {
        System.out.println(testVar);
        testMethod();
    }
}
