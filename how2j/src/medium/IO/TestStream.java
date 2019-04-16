package medium.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestStream {
    public static void main(String[] args) {
//        try {
//            File f = new File("LOL.txt");
////            FileInputStream fis = new FileInputStream(f);
//            FileOutputStream fos = new FileOutputStream(f);
//        } catch (IOException e ) {
//            e.printStackTrace();
//        }
        try {
            File f = new File("lol.txt");
            FileInputStream fis = new FileInputStream(f);
            byte[] all = new byte[(int) f.length()];
            fis.read(all);
            for (byte b : all) {
                System.out.println(b);
                fis.close();

            }



        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
