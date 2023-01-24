import java.util.Arrays;
public class ArrayEx {
    public static void main(String[] args) {
        primitiveArray();
        referenceArray();
    }

    private static void referenceArray() {
        Number [] numbers = new Number[3];

        byte age = 50;
        //        boxing - conversion of primitive types into wrapper
        Byte boxedAge = age;
        //        unboxing - conversion of wrapper types into primitives
        age = boxedAge;
        //numbers[0] = new Byte(age);
	numbers[0] = (byte) age;
        int salary = 75000;
        numbers[1] =salary;
        float tax = 50.55f;
        numbers[2] = tax;
        for (Number number: numbers
             ) {
            System.out.println(number);
        }
//        java.lang.ArrayIndexOutOfBoundsException: 3
        numbers[2] = 50;
    }

    private static void primitiveArray() {
        //        Arrays : linear, homogenous, fixed
        int numbers[] = {343,24,23,34};
        numbers[1] = 5000;
//        numbers[1] = "50";
//        numbers[1] = 50.50f;
        for(int i = 0; i< numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        Arrays.sort(numbers);
        for(int i = 0; i< numbers.length; i++) {
            System.out.println(numbers[i]);
        }
//        enhanced for loop
        for(int number : numbers) {
            System.out.print(number + "\t");
        }
        System.out.println();
//
    }
}
