package medium.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class RemoveBOM {
    public static void main(String[] args) {
        File f = new File("test.txt");
        try (FileInputStream fis = new FileInputStream(f);) {
            byte[] all = new byte[(int) f.length()];
            fis.read(all);
            System.out.println("首先确认按照UTF-8识别出来有？");
            String str = new String(all,"UTF-8");
            System.out.println(str);
            System.out.println("根据前面的所学，知道'中'字对应的UTF-8编码是：e4 b8 ad");
            System.out.println("打印出文件里所有的数据的16进制是：");
            for (byte b : all) {
                int i = b&0xff;
                System.out.print(Integer.toHexString(i)+ " ");
            }
            System.out.println();
            System.out.println("通过观察法得出 UTF-8的 BOM 是 ef bb bf");
            byte[] bom = new byte[3];
            bom[0] = (byte) 0xef;
            bom[1] = (byte) 0xbb;
            bom[2] = (byte) 0xbf;
            byte[] fileContentWithoutBOM= removeBom(all,bom);
            System.out.println("去掉了BOM之后的数据的16进制是：");
            for (byte b : fileContentWithoutBOM) {
                int i = b&0xff;
                System.out.print(Integer.toHexString(i)+ " ");
            }
            System.out.println();
            System.out.println("对应的字符串就没有问号了：");
            String strWithoutBOM=new String(fileContentWithoutBOM,"UTF-8");
            System.out.println(strWithoutBOM);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private static byte[] removeBom(byte[] all, byte[] bom) {
        return Arrays.copyOfRange(all, bom.length, all.length);
    }
}

