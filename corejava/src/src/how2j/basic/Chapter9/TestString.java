package how2j.basic.Chapter9;

import java.util.Date;
import java.util.Random;

public class TestString {
    public static void main(String[] args) {
//        String str1 = "let there ";
//
//        StringBuffer sb = new StringBuffer(str1);
//        sb.append("be light");
//        System.out.println(sb);
//        sb.delete(4, 10);
//        System.out.println(sb);
//        sb.insert(4, "there ");
//        System.out.println(sb);
//        sb.reverse();
//        System.out.println(sb);
//        String str1 = "dkfls";ow
//        StringBuffer sb = new StringBuffer(str1);
//        System.out.println(sb.length());
//        System.out.println(sb.capacity());
//        Date now = new Date();
////        Random generator = new Random();
//
//        int count = 0;
//        while (count < 10001) {
//            Random generator = new Random();
//
//        }
//
//        String str = "";
        StringBuffer sb1 = new StringBuffer();
        MyStringBuffer sb2 = new MyStringBuffer();
        int total = 3000000;

//        StringBuilder sss = new StringBuilder();
        int count = 0;
        long start1 = System.currentTimeMillis();
        while (count <= total) {
//            str += randomString(16);
//            sss.append(randomString());
            sb1.append(randomString(10));
            count++;

        }
        long end1 = System.currentTimeMillis();
        count = 0;
        long start2 = System.currentTimeMillis();
        while (count<= total) {
//            sb.append(randomString(16));
            sb2.append(randomString(10));
            count++;
        }
        long end2 = System.currentTimeMillis();
//        System.out.println("String costs time: " + (end - start));
        System.out.printf("StringBuffer appends %d times, costs %d milliseconds.\n", total, end1 - start1);
        System.out.printf("MyStringBuffer appends %d times, costs %d milliseconds.\n ",total, (end2 - start2));
//        System.out.println("Date.getTime() \t\t\t return:" + now.getTime());
//        System.out.println("System.currentTimeMillis()\t return:" + System.currentTimeMillis());
//        System.out.println(randomString());
    }

    public static String randomString(int length) {
//        char[] allChar = new char['9'-'0' + 'Z' -'A' + 'z' -'a' + 3];
//        for (int i = 0; i <= '9'-'0'; i++) {
//            allChar[i] = (char) ('0' + i);
//        }
//        for (int i = 10; i <= 'Z'-'A' + 10; i++) {
//            allChar[i] = (char) ('A' + i - 10);
//        }
//        for (int i = 36; i < allChar.length; i++) {
//            allChar[i] = (char) ('a' + i - 36);
//        }
////        return String.valueOf(allChar);
//        Random generator = new Random();
//
//        char[] output = new char[10];
//        for (int i = 0; i < output.length; i++) {
//            int index = generator.nextInt(62);
//            output[i] = allChar[index];
//        }
//        return String.valueOf(output);

        String pool = "";
        for (short i = '0'; i <= '9'; i++) {
            pool += (char) i;
        }
        for (short i = 'a'; i <= 'z'; i++) {
            pool += (char) i;
        }
        for (short i = 'A'; i <= 'Z'; i++) {
            pool += (char) i;
        }
        char[] cs = new char[length];
        for (int i = 0; i < cs.length; i++) {
            int index = (int) (Math.random() * pool.length());
            cs[i] = pool.charAt(index);
        }
        String result = new String(cs);
        return result;

    }
}
