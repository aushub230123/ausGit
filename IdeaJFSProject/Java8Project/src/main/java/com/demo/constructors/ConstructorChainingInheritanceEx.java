package com.demo.constructors;
//chaining with super keyword
public class ConstructorChainingInheritanceEx {
    public static void main(String[] args) {

        Advanced calculator21 = new Advanced(500,600,900.9f);
    }
}
class Standard{
    //PRIVATE VARIABLES CANNOT INHERITED
    // CANNOT BE ACCESS BY DERIVED CLASS
    // BUT PUBLIC OR PROTECTED METHODS OF BASE CLASS USING PRIVATE VARIABLES CAN BE ACCESSED IN THE DERIVED CLASS
    private int num1, num2;
//    default constructor
//public  Standard() {
//    this.num1 = 0;
//    this.num2 = 0;
//    System.out.println("Standard()");
//    System.out.println(num1 + "  "+ num2);
//
//}
    public  Standard(int num1, int num2) {
//        this();
//        this.num1 = num1;
        this.num1 = 5;
        this.num2 = num2;
        System.out.println("Standard(int num1, int num2)");
        System.out.println(num1 + "  "+ num2);
        System.out.println(this.num1 + " " + this.num2);
    }
}

class Advanced extends  Standard{
//    int num1, num2;
        float num3;
//    default constructor
//    public  Standard() {
//        this.num1 = 0;
//        this.num2 = 0;
//        System.out.println("Standard()");
//        System.out.println(num1 + "  "+ num2);
//
//    }

    public  Advanced(int num1, int num2, float num3) {
        super(num1,num2);
        System.out.println(" Calculator2(int num1, int num2, float num3)");
        System.out.println(num1 + "  "+ num2 + " " + num3);
    }
}