package medium.lambda;

import medium.collections.Hero;

import java.util.*;
import java.util.function.Supplier;

public class TestLambda {
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heroes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            heroes.add(new Hero("hero " + i, r.nextInt(100), r.nextInt(100)));
        }
        System.out.println(heroes);
//        System.out.println("use anonymous way");
//        HeroChecker checker = new HeroChecker() {
//            @Override
//            public boolean test(Hero h) {
//                return (h.hp < 100 && h.damage < 50);
//            }
//        };
        System.out.println("use lambda(anonymous method)");
//        filter(heroes, h -> h.hp>100 && h.damage < 50);
        TestLambda testLambda = new TestLambda();
        filter(heroes, testLambda::testHero);
        filter(heroes, h->testLambda.testHero(h));
        filter(heroes, h->h.mathched());
        filter(heroes, Hero::mathched);

        Supplier<List> s = new Supplier<List>() {
            @Override
            public List get() {
                return new ArrayList();
            }
        };

        // anonymous inner class
        List list1 = getList(s);

        // Lambda
        List list2 = getList(() -> new ArrayList());

        // Constructor reference
        List list3 = getList(ArrayList::new);


        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 10; i++) {
            heros.add(new Hero("hero "+ i, r.nextInt(100), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heros);

        //
        Comparator<Hero> c = (h1, h2)-> h1.compareHero(h2) ;
        Collections.sort(heros,c);

        //
        Collections.sort(heros,Hero::compareHero);

        System.out.println(heros);
    }

    public static List getList(Supplier<List> s ) {
        return s.get();
        }

    public  boolean testHero(Hero h) {
        return h.hp>100 && h.damage < 50;
    }

    private static void filter(List<Hero> heroes, HeroChecker checker) {
        for (Hero hero : heroes) {
            if (checker.test(hero)) {
                System.out.println(hero);
            }
        }
    }
}
