package com.demo.constructors;

public class ConstructorChainingEx {
//    constructor chaining with this
    public static void main(String[] args) {
//     Calculator2 calculator2 = new Calculator2();
       Calculator2 calculator21 = new Calculator2(500,600,900.9f);
    }
}
class Calculator2{
    int num1, num2;
    float num3;
//    default constructor
public  Calculator2() {
    this.num1 = 0;
    this.num2 = 0;
    System.out.println("Calculator2()");
    System.out.println(num1 + "  "+ num2);

}
    public  Calculator2(int num1, int num2) {
        this();
        this.num1 = num1;
        this.num2 = num2;
        System.out.println("Calculator2(int num1, int num2)");
        System.out.println(num1 + "  "+ num2);

    }
    public  Calculator2(int num1, int num2, float num3) {
//        this.num1 = 100;
//        this.num2 = 200;
//        constructor chaining is calling one constructor inside another for reusability
        //Calculator2()
//        this();
        this(num1,num2);
        this.num3 = num3;
        System.out.println(" Calculator2(int num1, int num2, float num3)");
        System.out.println(num1 + "  "+ num2 + " " + num3);
    }
}