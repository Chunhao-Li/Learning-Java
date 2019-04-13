package how2j.medium.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListCmpLinkedList {
    public static void main(String[] args) {
        List<Integer> l;
        l = new ArrayList<>();
        insertLast(l, "Arraylist");
        l = new LinkedList<>();
        insertLast(l, "LinkedList");
    }

    private static void insertLast(List<Integer> l, String type) {
        int total = 1000 ;
        final int number = 5;
        long start =System.currentTimeMillis();
        for (int i = 0; i < total; i++) {
            l.add(l.size()/2, number);
        }
        long end = System.currentTimeMillis();
        System.out.printf( "insert %d records into %s, costs %d milliseconds %n", total, type, end-start);
    }
}
