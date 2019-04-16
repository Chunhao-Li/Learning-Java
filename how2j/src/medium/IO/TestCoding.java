package medium.IO;

import java.io.UnsupportedEncodingException;

public class TestCoding {
    private static void showCode(String str, String encode) {
        try {
            System.out.printf("Character: \"%s\" 's hex under %s coding: %n", str, encode);
            byte[] bs = str.getBytes(encode);

            for (byte b : bs) {
                int i = b & 0xff;
                System.out.print(Integer.toHexString(i) + "\t");
            }
            System.out.println();
            System.out.println();
        } catch (UnsupportedEncodingException e) {
            System.out.printf("UnsupportedEncodingException: %s cannot be encoded with %s method %n", str, encode);
        }
    }

    private static void showCode(String str) {
        String[] encodes = {"BIG5", "GBK", "GB2312", "UTF-8", "UTF-16", "UTF-32"};
        for (String encode : encodes) {
            showCode(str, encode);
        }
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
//        byte[] cs = "中".getBytes("utf-8");
////        System.out.println(cs);
//        for (byte b : cs) {
//            System.out.println(b);
//            byte i =(byte) (b & 0xff);
//            System.out.println(Integer.toHexString((int) b));
//        }
        String str= "種";
        showCode(str);
    }
}
