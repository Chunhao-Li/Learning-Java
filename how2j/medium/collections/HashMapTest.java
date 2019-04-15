package how2j.medium.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMapTest {
    public static void main(String[] args) {
//        HashMap<String, String> dictionary = new HashMap<>();
////        dictionary.put("adc", "physical hero");
////        dictionary.put("apc", "magical hero");
////        dictionary.put("t", "tank");
////
//////        System.out.println(dictionary.get("t"));
////        HashMap<String, Hero> heroMap = new HashMap<>();
////        heroMap.put("gareen", new Hero("gareen1"));
////        System.out.println(heroMap);
////        heroMap.put("gareen",new Hero("gareen2"));
////        System.out.println(heroMap);
////        heroMap.clear();
////        Hero gareen = new Hero("gareen");
////        heroMap.put("hero1", gareen);
////        heroMap.put("hero2",gareen);
////        System.out.println(heroMap);

        System.out.println("----------initialisation-------------");
        List<Hero> heroes = new ArrayList<>();
        int total = 30000000;
        for (int i = 0; i < total; i++ ) {
            Hero h = new Hero("hero-" + (int) (Math.random()*9000 + 1000));
            heroes.add(h);
        }
//        System.out.println(heroes);

        HashMap<String, List<Hero>> heroMap = new HashMap<>();
        for (Hero h : heroes) {
            List<Hero> list = heroMap.get(h.name);
            if (list == null) {
                list = new ArrayList<>();
                heroMap.put(h.name, list);
            }
            list.add(h);
        }
        System.out.println("-----------initialisation finished---------");

        System.out.println("---------start searching-----------");

        findByIteration(heroes);
        findByMap(heroMap);



//        ArrayList<Hero> hero5555 = new ArrayList<>();
//        long start1 = System.currentTimeMillis();
//        for (Hero h : heroes) {
//            if (Integer.parseInt(h.name.substring(5)) == 5555) {
//                hero5555.add(h);
//            }
//        }
//        long end1 = System.currentTimeMillis();


    }
    private static List<Hero> findByMap(HashMap<String,List<Hero>> m) {
        long start = System.currentTimeMillis();
        List <Hero> result = m.get("hero-5555");
        long end = System.currentTimeMillis();
        System.out.printf("Using map, find %d heroes, cost %d milliseconds \n", result.size(), end-start);
        return result;
    }

    private static List<Hero> findByIteration(List<Hero> hs) {
        long start = System.currentTimeMillis();
        List<Hero> result = new ArrayList<>();
        for (Hero h : hs) {
            if (h.name.equals("hero-5555")) {
                result.add(h);
            }
        }
        long end = System.currentTimeMillis();
        System.out.printf("Using for, find %d heroes, cost %d milliseconds\n", result.size(), end-start);
        return result;
    }

}
