package how2j.medium.collections;


import how2j.basic.Chapter9.MyStringBuffer;

import java.util.LinkedList;

public class MyStack implements Stack {

//    public Mystack() {
//        LinkedList heroes = new LinkedList();
//    }
    LinkedList<Hero> heroes = new LinkedList<>();




    @Override
    public void push(Hero h) {
        heroes.add(h);

    }

    @Override
    public Hero pull() {
//        Hero h = heroes.getLast();
////        return h;
//        heroes.removeLast();
//        return h;
        return heroes.removeLast();
    }

    @Override
    public Hero peek() {
        return heroes.getLast();
    }

    public static void main(String[] args) {
        MyStack heroStack = new MyStack();
        for (int i = 0; i < 5; i++) {
            Hero h = new Hero("hero name " + i);
            System.out.println("Push hero:" + h);
            heroStack.push(h);
        }
        for (int i = 0; i < 5; i++) {
            Hero h = heroStack.pull();
            System.out.println("Pull hero:" + h);
        }
    }
}
