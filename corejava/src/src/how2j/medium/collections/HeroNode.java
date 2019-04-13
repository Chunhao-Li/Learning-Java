package how2j.medium.collections;

import java.util.ArrayList;
import java.util.List;

public class HeroNode {

    public HeroNode leftNode;
    public HeroNode rightNode;
    public Hero value;

    public void add(Hero h) {
        if (value == null) {
            value = h;
        }
        else {
            if (h.hp >= value.hp) {
                if (leftNode == null) {
                    leftNode = new HeroNode();
                }
                leftNode.add(h);

            }
            else {
                if (rightNode == null){
                    rightNode = new HeroNode();
                }
                rightNode.add(h);
            }
        }
    }

    public List<Hero> values() {
        List<Hero> values = new ArrayList<>();
        if (leftNode != null) {
            values.addAll(leftNode.values());
        }
        values.add(value);
        if (rightNode != null ) {
            values.addAll(rightNode.values());
        }
        return values;
    }

    public static void main(String[] args) {
        List<Hero> hs = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Hero h = new Hero("hero " + i);
            h.hp = (float) (Math.random()*900 + 100) ;
            hs.add(h);
        }
        System.out.println("Initial 10 heroes list: ");
        System.out.println(hs);

        HeroNode heroTree = new HeroNode();
        for (Hero h : hs) {
            heroTree.add(h);
        }
        System.out.println("After becoming a tree: ");
        System.out.println(heroTree.values());
//        System.out.println(heroes.values());
    }


}
