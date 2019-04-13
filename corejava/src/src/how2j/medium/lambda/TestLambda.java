package how2j.medium.lambda;

import how2j.medium.collections.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
