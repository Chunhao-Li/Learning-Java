package medium.IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PracticeOS {
    public static void main(String[] args) {
       try {File f = new File("test/xyz/lol2.txt");
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
            f.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(f);
        byte[] data = {97, 102, 97, 102};
        fos.write(data);
        fos.close();
        } catch (IOException e) {
           e.printStackTrace();

    }
}}
