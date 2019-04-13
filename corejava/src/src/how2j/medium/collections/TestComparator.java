package how2j.medium.collections;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TestComparator {
    public static void main(String[] args) {

        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        };
        Set<Integer> tree = new TreeSet<>(c);
        for (int i = 0; i < 10; i++) {
            tree.add(i);
        }
        System.out.println(tree);
    }
}
