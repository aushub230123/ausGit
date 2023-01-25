package com.demo.exception;

public class CheckedExceptionEx {

//this will compile if ReflectiveOperationException is a parent/ancestor of ClassNotFoundException
    public static void main(String[] args) throws  ReflectiveOperationException{

        try {
            checkedTest();
        } catch (ClassNotFoundException e) {
//            catching a checked exception and throwing an unchecked exception
//            throw new RuntimeException(e);
            throw e;
        }
    }

    private static void checkedTest() throws ClassNotFoundException {
        //        try {
//            Returns the Class object associated with the class or interface with the given string name
        Class<?> classDetials =    Class.forName("java.lang.String");
        System.out.println(classDetials.getName());
        System.out.println("Return the class");
//        }
//        catch (ClassNotFoundException classNotFoundException) {
//            System.out.println("class not found");
//            System.out.println(classNotFoundException);
//        }
    }
}
