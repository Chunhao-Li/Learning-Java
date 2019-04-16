package medium.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashMap implements IHashMap{
    LinkedList<Entry>[] map = new LinkedList[2000];


    @Override
    public void put(String key, Object object) {
        int hashcode = MyHashCode.hashcode(key);
        LinkedList<Entry> data;
        data = map[hashcode];
        if (data == null) {

            data = new LinkedList<>();
            map[hashcode]= data;
//            Entry entry = new Entry(key, object);

        }

        // justify whether the key already has the value
        boolean found = false;
        for (Entry e : data) {
            if (key.equals(e.key)) {
                e.value = object;
                found = true;
                break;
            }
        }
        if (!found) {
            Entry entry = new Entry(key, object);
            data.add(entry);
        }
    }

    @Override
    public Object get(String key) {
        int hashcode = MyHashCode.hashcode(key);
        LinkedList<Entry> value = map[hashcode];
        if (value == null) {
            return null;
        }
        else {
            for (Entry e : value) {
                if (e.key.equals(key)) {
                    return e.value;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        MyHashMap map =new MyHashMap();
        System.out.println(map.map.length);
        //
         map.put("t", "坦克");
         map.put("adc", "物理");
         map.put("apc", "魔法");
         map.put("t", "坦克2");

         System.out.println(map.get("adc"));

         System.out.println(map);

//        System.out.println(map.hashcode("name=hero-2387"));
//        System.out.println(map.hashcode("name=hero-5555"));

    }

    @Override
    public String toString() {
        LinkedList<Entry> result = new LinkedList<>();

        for (LinkedList<Entry> linkedList : map) {
            if (null == linkedList)
                continue;
            result.addAll(linkedList);
        }
        return result.toString();
    }
}
