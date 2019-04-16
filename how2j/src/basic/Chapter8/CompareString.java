package basic.Chapter8;

import java.util.ArrayList;

public class CompareString {
    public static void main(String[] args) {
//        String str1 = "the light";
////        String str2 = new String(str1);
////        String str3 = "the light";
////        System.out.println(str1 == str2);
////        System.out.println(str1 == str3);
//        String start = "the";
//        String end = "light";
//        System.out.println(str1.startsWith(end));
//        System.out.println(str1.endsWith(end));
        String[] strings = new String[100];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = randomStrings(2);
        }
//        for (String s : strings) {
//            System.out.println(s);
//        }
        ArrayList<String> appeared = new ArrayList<>();
        for (String s : strings) {
            if (!appeared.contains(s)) {
                appeared.add(s);
            }
        }
        System.out.println(appeared.size());

    }

    public static String randomStrings(int length) {
        String pool = "";
        for (short i = '0'; i < '9'; i++) {
            pool += (char) i;
        }
        for (int i = 'a'; i < 'z'; i++) {
            pool += (char) i;
        }
        for (short i = 'A'; i < 'Z'; i++) {
            pool += (char) i;
        }
        char[] chars = new char[length];
        for (int i = 0; i < chars.length; i++) {
            int index = (int) (Math.random()*pool.length());
            chars[i] = pool.charAt(index);
        }
        return new String(chars);

    }
}
