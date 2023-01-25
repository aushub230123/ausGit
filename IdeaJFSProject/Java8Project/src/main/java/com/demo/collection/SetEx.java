package com.demo.collection;


import sun.reflect.generics.tree.Tree;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetEx {
    public static void main(String[] args) {
//        rawTypes();
//        genericTypes();
//        compatibilityRawAndGeneric();
//        workingWithSet();
        workingWithTreeSet();
    }

    private static void workingWithSet() {
        Set<String> shoppingCartSet = new HashSet<String>();
//        methods from Collection interface
        shoppingCartSet.add("Man's Search For Meaning");
        System.out.println(shoppingCartSet.add("Start With Why"));
        shoppingCartSet.add("Java");
        System.out.println(shoppingCartSet.add("Start With Why"));
        shoppingCartSet.add("Deep Work");
        System.out.println(shoppingCartSet);
//        shoppingCartSet.remove("Start With Why");
        System.out.println(shoppingCartSet.remove("Deep Work"));
        shoppingCartSet.add(null);
        shoppingCartSet.add(null);
        System.out.println(shoppingCartSet);
        for(String item : shoppingCartSet) {
            System.out.println(item);
        }
        System.out.println(shoppingCartSet.size());
//        shoppingCartSet.clear();
//        System.out.println(shoppingCartSet.size());

        Set<String> removeItemsSet = new HashSet<String>();
//        methods from Collection interface
        removeItemsSet.add("Man's Search For Meaning");
        removeItemsSet.add("Deep Work");
        removeItemsSet.add(null);

        shoppingCartSet.removeAll(removeItemsSet);
        System.out.println(shoppingCartSet);
    }

    private static void workingWithTreeSet() {
        Set<String> shoppingCartSet = new TreeSet<String>();
//        methods from Collection interface
        shoppingCartSet.add("Man's Search For Meaning");
        System.out.println(shoppingCartSet.add("Start With Why"));
        shoppingCartSet.add("Java");
        System.out.println(shoppingCartSet.add("Start With Why"));
        shoppingCartSet.add("Deep Work");
        System.out.println(shoppingCartSet);
//        shoppingCartSet.remove("Start With Why");
        System.out.println(shoppingCartSet.remove("Deep Work"));
        shoppingCartSet.add(null);
        shoppingCartSet.add(null);
        System.out.println(shoppingCartSet);
        for(String item : shoppingCartSet) {
            System.out.println(item);
        }
        System.out.println(shoppingCartSet.size());
//        shoppingCartSet.clear();
//        System.out.println(shoppingCartSet.size());

        Set<String> removeItemsSet = new TreeSet<String>();
//        methods from Collection interface
        removeItemsSet.add("Man's Search For Meaning");
        removeItemsSet.add("Deep Work");
        removeItemsSet.add(null);

        shoppingCartSet.removeAll(removeItemsSet);
        System.out.println(shoppingCartSet);
    }
    private static void compatibilityRawAndGeneric() {
        Set rawHashSet = new HashSet<String>();
        rawHashSet.add(5);
        ArithmeticException arithmeticException = new ArithmeticException();
        rawHashSet.add(arithmeticException);

        Set<Integer> secondSet = rawHashSet;
        System.out.println(secondSet);

//        HashSet<String> rawHashSet1 = new HashSet<String>();
//        rawHashSet1.add(5);
//        rawHashSet1.add(arithmeticException);
    }

    private static void rawTypes() {;
        //        Raw types
//        Dynamic polymorphism
        Set colors = new HashSet();
        colors.add("Green");
        ArithmeticException arithmeticException = new ArithmeticException();
        colors.add(arithmeticException);
        System.out.println(colors);

//        colors = new TreeSet();
    }
    private static void genericTypes() {
        // Generic types with type safety
        Set<String> colors = new HashSet<String>();
        colors.add("Green");
        ArithmeticException arithmeticException = new ArithmeticException();
//        colors.add(arithmeticException);
        System.out.println(colors);
//        colors = new Stack();
    }
}
