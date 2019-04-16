package medium.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;







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
         map.put("t", "坦克");
         map.put("adc", "物理");
         map.put("apc", "魔法");
         map.put("t", "坦克2");

         System.out.println(map.get("adc"));

         System.out.println(map);


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
