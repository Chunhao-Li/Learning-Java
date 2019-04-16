package medium.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CloseStreams {
    public static void main(String[] args) {
        File f = new File("lol.txt");
        FileInputStream fis = null;
        try {
            try {
                fis = new FileInputStream(f);
                byte[] all = new byte[(int) f.length()];
                fis.read(all);
                for (byte b : all) {
                    System.out.println(b);
                }
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}