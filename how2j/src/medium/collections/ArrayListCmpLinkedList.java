package medium.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

public class ArrayListCmpLinkedList {
    public static void main(String[] args) {
        List<Integer> l;
        l = new ArrayList<>();
//        insertLast(l, "Arraylist");
        insertLast(ArrayList::new, "ArrayList");
        Supplier<List> s2 = new Supplier<List>() {
            @Override
            public List get() {
                return new LinkedList();
            }
        };

        //
        s2 = () -> {return new LinkedList();};
        //
        s2 = () -> new LinkedList();
        insertLast(() -> new LinkedList(), "LinkedList");
        //
        insertLast(LinkedList::new, "LinkedList");
    }

    private static void insertLast(Supplier<List> s, String type) {
        int total = 1000 ;
        final int number = 5;
        List l = s.get();
        long start =System.currentTimeMillis();
        for (int i = 0; i < total; i++) {
            l.add(l.size()/2, number);
        }
        long end = System.currentTimeMillis();
        System.out.printf( "insert %d records into %s, costs %d milliseconds %n", total, type, end-start);
    }
}
