package how2j.medium.collections;

import java.util.*;

import how2j.basic.Chapter8.CompareString;

import static how2j.basic.Chapter8.CompareString.randomStrings;

public class TestHashSet {
    public static void main(String[] args) {
//        HashSet<String> names = new HashSet<>();
//        names.add("gareen");
////        System.out.println(names);
////        names.add("gareen");
////        System.out.println(names);
//        HashSet<Integer> numbers = new HashSet<>();
////        numbers.add(9);
////        numbers.add(5);
////        numbers.add(1);
////        System.out.println(numbers);
//        for (int i = 0; i < 20; i++) {
//            numbers.add(i);
//        }
////        numbers.get(0);
//        // use iterator
//        for (Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext();) {
//            Integer i = iterator.next();
//            System.out.println(i);
//        }
//        // use enhanced for loop
//        for (Integer i : numbers) {
//            System.out.println(i);
//        }
//        CompareString cs = new CompareString();
        String[] strings = new String[100];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = randomStrings(2);
        }
        for (int i = 0; i< strings.length; i++) {
            System.out.print(strings[i] + " ");
            if (i % 20 == 19) {
                System.out.println();
            }
        }
        HashSet<String> result = new HashSet<>();
//        List<String> result = new ArrayList<>();
//        for (String s : strings) {
//            strings1.add(s);
//        }

        for (String s1 : strings) {
            int repeat = 0;
            for (String s2 : strings) {
                if (s1.equalsIgnoreCase(s2)) {
                    repeat++;
                    if (repeat == 2) {
                        result.add(s1);
                        break;
                    }
                }
            }
        }
        System.out.printf("There are %d repeating strings %n", result.size());
        if (result.size() != 0) {
            System.out.println("they are: ");
            for (String s : result) {
                System.out.print(s + " ");
            }
        }

    }
}
