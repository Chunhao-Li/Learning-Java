package medium.IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestOuputStream {
    public static void main(String[] args) {
        try {
            File f = new File("haha.txt");
            byte[] data = {88, 89};

            FileOutputStream fos = new FileOutputStream(f);
            fos.write(data);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
