package medium.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Node {
    public Node leftNode;
    public Node rightNode;
    public Object value;

    public void add (Object v) {
        if (value == null) {
            value = v;
        }
        else {
            if ((Integer) v - ((Integer) value) <= 0) {
                if (leftNode == null) {
                    leftNode = new Node();
                }
                leftNode.add(v);
            }
            else {
                if (rightNode == null) {
                    rightNode = new Node();
                }
                rightNode.add(v);
            }
        }
    }

    public List<Object> values() {
        List<Object> values = new ArrayList<>();

        if (leftNode != null) {
            values.addAll(leftNode.values());
        }
        values.add(value);
        if (rightNode != null) {
            values.addAll(rightNode.values());
        }
        return  values;
    }

    public static void main(String[] args) {
        int randoms[] = new int[] {67, 7, 30, 73, 10, 0, 78, 81, 10, 74};
        Node roots = new Node();
        for (int number : randoms) {
            roots.add(number);
        }
    }
}

