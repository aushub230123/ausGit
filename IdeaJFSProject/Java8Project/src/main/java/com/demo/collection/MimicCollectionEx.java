package com.demo.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class MimicCollectionEx {
    public static void main(String[] args) {
        Collection<E> collection;
        List<E> list;
        Set<E> set;
        ArrayList<E> arrayList;
    }
}

class E extends Object{}
interface CollectionM {
    boolean add(E e);
}
interface ListM extends CollectionM {
    E get(int index);
    E set(int index, E element);
}

