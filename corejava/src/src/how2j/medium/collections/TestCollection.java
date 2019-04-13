package how2j.medium.collections;

import how2j.basic.Chapter3.SortedArray;

import java.lang.reflect.Array;
import java.util.*;
import java.util.HashMap;

public class TestCollection {
    @SuppressWarnings("unchecked")
//    public static void main(String[] args) {
//        ArrayList<Hero> heroes=  new ArrayList<>();
//
//        for (int i = 0; i < 100; i++) {
//            heroes.add(new Hero("hero " + i));
//        }
////        System.out.println(heroes);
//
//        // add the element on the specific position
////        Hero specialHero = new Hero("special hero");
////        heroes.add(3, specialHero);
//        System.out.println(heroes);
//        ArrayList<Hero> rem = new ArrayList<>();
////        for (int i = 1; i < heroes.size(); i++) {
////            if (i % 8 == 0) {
////                rem.add(heroes.get(i));
////            }
////        }
////        System.out.println(heroes.size());
//        for (int i = heroes.size() - 1; i >= 0; i--) {
//            if (i % 8 == 0) {
////                System.out.println(i);
////                System.out.println(heroes.get(i));
//                heroes.remove(i);
//            }
//        }
//        for (Hero h : heroes) {
//            int id = Integer.parseInt(h.name.substring(5));
//            if (id % 8 == 0) {
//                rem.add(h);
//            }
//        }
//        for (Hero h : rem) {
//            heroes.remove(h);
//        }
//        heroes.removeAll(rem);
//        for (Hero h : heroes) {
//            int index = (int)
//                    heroes.reh.name.substring(4, h.name.length());
//        }
//        System.out.println(heroes);
//        System.out.println(heroes.size());
//        Hero[] hs = (Hero[]) heroes.toArray(new Hero[] {});
//        System.out.println("array: " + hs);
//
//        System.out.print("A new hero with the same name hero 1, but returns: ");
//        System.out.println(heroes.contains(new Hero("hero 1")));
//        System.out.print("To justify whether it contains specialHero, returns: ");
//        System.out.println(heroes.contains(specialHero));
//        System.out.println(heroes.get(5));
////        System.out.println(heroes.get(6));
//        System.out.println();
//        System.out.println("specialHero's index is " + heroes.indexOf(specialHero));
//        System.out.println("A new hero with the same name\"hero 1\"'s index is " +
//                heroes.indexOf(new Hero("hero 1"))); // -1
//        System.out.print("clear: " );
//        heroes.clear();
//        System.out.println(heroes);
//        for (Hero h : heroes) {
//            if (h.name.equals("hero 1")) {
//                System.out.println("True!");
//            }
//        }
//        List<LOL> lolList = new ArrayList<>();
//        lolList.add(new Hero("Garon"));
//        lolList.add(new Item("blood"));

//        System.out.println("--------------iterator using while------------");
//        Iterator<Hero> iter = heroes.iterator();
//        while (iter.hasNext()) {
//            Hero h = iter.next();
//            System.out.println(h);
//        }
//
//        System.out.println("---------------iterator with for--------------");
//        for (Iterator<Hero> iterator = heroes.iterator(); iterator.hasNext();) {
//            Hero he = iterator.next();
//            System.out.println(he);
//        }


//        LinkedList<Hero> ll = new LinkedList<>();
//        ll.addLast(new Hero("hero1"));
//        ll.addLast(new Hero("hero2"));
//        ll.addLast(new Hero("hero3"));
//        System.out.println(ll);
//
//        ll.addFirst(new Hero("heros"));
//        System.out.println(ll);
//
//        System.out.println(ll.getFirst());
//        System.out.println(ll.getLast());
//
//        System.out.println(ll);
//        System.out.println(ll.removeFirst());
//        System.out.println(ll.removeLast());
//        System.out.println(ll);

//        Queue<Hero> q = new LinkedList<>();
//        System.out.print("initial queue: \t");
//        q.offer(new Hero("Hero1"));
//        q.offer(new Hero("Hero2"));
//        q.offer(new Hero("Hero3"));
//        q.offer(new Hero("Hero4"));
//
//        System.out.println(q);
//        System.out.print("get the first element:\t");
//        Hero h = q.poll();
//        System.out.println(h);
//        System.out.print("After getting the first elem: \t");
//        System.out.println(q);
//        System.out.print("See the first one: \t");
//        h = q.peek();
//        System.out.println(h);
////        System.out.println(q);
//        List<Integer> randomNumbers = new ArrayList<>();
//        for (int i = 0 ; i < 40000; i++) {
//            int in = (int) (Math.random() * 10000);
//            randomNumbers.add(in);
//        }
////        System.out.println(randomNumbers.toString());
//
//        ArrayList<Integer> selectionTest = new ArrayList<>(randomNumbers);
//        ArrayList<Integer> bubleTest = new ArrayList<>(randomNumbers);
////        List<Integer> treeTest = List.copyOf(randomNumbers);
////        Node treeTest = new Node();
////        for (int i : randomNumbers) {
////            treeTest.add(i);
////        }
//        long startSelection = System.currentTimeMillis();
//        SortedArray.selectionSort(selectionTest);
//        long endSelection = System.currentTimeMillis();
//        long startBuble = System.currentTimeMillis();
//        SortedArray.bubleSort(bubleTest);
//        long endBuble = System.currentTimeMillis();
//        long startTree = System.currentTimeMillis();
//        Node treeTest = new Node();
//        for (int i : randomNumbers) {
//            treeTest.add(i);
//        }
//        List  treeList =  treeTest.values();
//        long endTree = System.currentTimeMillis();
//        System.out.println("Selection sort costs " + (endSelection- startSelection));
//        System.out.println("Buble sort costs " + (endBuble - startBuble));
//        System.out.println("Node tree costs " + (endTree - startTree));
//        System.out.println(selectionTest.hashCode());
//        System.out.println(bubleTest.hashCode());
//        System.out.println(treeTest.hashCode());
//        System.out.println(treeList.hashCode());
//        System.out.println(selectionTest.equals(bubleTest));
//        System.out.println(selectionTest.equals(treeList));
//        System.out.println(selectionTest.equals(randomNumbers));
//
//        Scanner in = new Scanner(System.in);
//
//    }
    public static void main(String[] args) {
        Random r =new Random();
        List<Hero> heros = new ArrayList<Hero>();

        for (int i = 0; i < 10; i++) {
            //通过随机值实例化hero的hp和damage
            heros.add(new Hero("hero "+ i, r.nextInt(100), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heros);

        //直接调用sort会出现编译错误，因为Hero有各种属性
        //到底按照哪种属性进行比较，Collections也不知道，不确定，所以没法排
        //Collections.sort(heros);

        //引入Comparator，指定比较的算法

//        Comparator<Hero> c = new Comparator<Hero>() {
//            @Override
//            public int compare(Hero h1, Hero h2) {
//                //按照hp进行排序
//                if(h1.hp>=h2.hp)
//                    return 1;  //正数表示h1比h2要大
//                else
//                    return -1;
//            }
//        };
        Collections.sort(heros);
        System.out.println("按照血量排序后的集合：");
        System.out.println(heros);
    }
}
