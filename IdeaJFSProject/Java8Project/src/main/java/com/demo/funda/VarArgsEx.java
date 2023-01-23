package com.demo.funda;

public class VarArgsEx {
    public static void main(String[] args) {
//        SUM UP 1 TO 10 NUMBER .. EG 1&2, 1&2&3, 1&2&3...10
        sum(1,2,5,50,20,30);
        sum(1,2,5,50,20,30,3,3535,3535,3333);
        sum(50);
        sum(5,50);

    }
    public  static void sum(int x, int ...numbers){
//        System.out.println(numbers.length);
        int result = 0;
        for(int number : numbers) {
            result += number;
        }
        System.out.println(result+x);
    }
    //IP IMPLEMENT SUM METHOD FOR NUMBERS (BYTE+INT+SHORT+LONG+DOUBLE)
}
