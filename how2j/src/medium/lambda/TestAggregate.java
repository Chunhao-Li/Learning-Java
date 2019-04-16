package medium.lambda;

import medium.collections.Hero;

import java.util.*;

public class TestAggregate {
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heroes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            heroes.add(new Hero("hero " + i, r.nextInt(200), r.nextInt(200)));

        }

        heroes.sort( (h1, h2) -> (int) (h1.hp-h2.hp));
        Hero hero =heroes.get(2);

        String name = heroes.stream().sorted((h1, h2) -> h1.hp > h2.hp ? -1: 1)
                .skip(2).map(h->h.name).findFirst().get();

//        System.out.println("初始化后的集合：");
//        System.out.println(heroes);
//        System.out.println("查询条件：hp>100 && damage<50");
//        System.out.println("通过传统操作方式找出满足条件的数据：");
//
//        for (Hero h : heroes) {
//            if (h.hp > 100 && h.damage < 50)
//                System.out.println(h.name);
//        }
//
//        System.out.println("通过聚合操作方式找出满足条件的数据：");
//
//        heroes.
//                stream()
//                .filter(h -> h.hp > 100 && h.damage < 50)
//                .forEach(h -> System.out.println(h.name));
//
//        heroes
//
//                .forEach(h-> System.out.println(h.name));
//
//        Hero[] hs = heroes.toArray(new Hero[heroes.size()]);
//        Arrays.stream(hs)
//                .forEach(h-> System.out.println(h.name));
//
//
//        heroes.stream().sorted().forEach(System.out::println);
//        heroes.stream().skip(3).forEach(System.out::println);
//        heroes.stream().mapToDouble(Hero::getHp).forEach(System.out::println);
//        heroes.stream().map((h)->h.name+" - " + h.hp + " - " + h.damage).forEach(System.out::println);
//
//        Object[] hss = heroes.toArray();
//        Hero minDamageHero = heroes.stream().min((h1, h2) -> h1.damage-h2.damage).get();
//        long count = heroes.stream().count();
//        Hero firstHero = heroes.stream().findFirst().get();
//
//    }
    }
}