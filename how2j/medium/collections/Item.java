package how2j.medium.collections;

public class Item implements LOL {
    String name;
    int price;

    public Item() {}

    public Item(String name) {
        this.name = name;
    }

    public void effect() {
        System.out.println("After using the item it has effect");
    }
}
