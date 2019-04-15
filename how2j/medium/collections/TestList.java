package how2j.medium.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        List<Hero> heroes = new ArrayList<>();
//        HashMap<String, Hero> heroes = new HashMap<>();

        for (int i = 0; i < 2000000; i++) {
            Hero h = new Hero("Hero " + i);
//            heroes.put(h.name, h);
            heroes.add(h);
        }

        for (int i = 0; i < 10; i++) {
            // shuffle the list
            Collections.shuffle(heroes);
//
            long start = System.currentTimeMillis();
//            Hero target = heroes.get("Hero 1000000");
//            System.out.println("Found it !");
            String target = "Hero 100000";
//
            for (Hero h : heroes) {
                if (h.name.equals(target)) {
                    System.out.println("Found it!");
                    break;
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("Cost " + (end - start) + "milliseconds");
        }
    }
}
