package how2j.medium.collections;

import java.util.LinkedHashSet;
import java.util.Set;


public class TestLinkedHashSet {
    public static void main(String[] args) {
//        Double pi = Math.PI;
        Set<Integer> list = new LinkedHashSet<>();
        String str = String.valueOf(Math.PI);
        str =str.replace(".", "");
        char[] numbers = str.toCharArray();
        for (char c : numbers) {
//            if (c >= '0' && c <= '9') {
                int i = Integer.parseInt(String.valueOf(c));
                list.add(i);
//            }
        }
        System.out.println(list);
    }
    }



