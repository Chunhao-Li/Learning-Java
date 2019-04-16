package medium.IO;

import javax.naming.ldap.UnsolicitedNotification;
import java.io.*;
import java.nio.charset.Charset;

public class ChineseCodeing {
    public static void main(String[] args) throws UnsupportedEncodingException {


//    File f = new File("test2.txt");
//        try (FileInputStream fis = new FileInputStream(f);) {
//        byte[] all = new byte[(int) f.length()];
//        fis.read(all);
//
//        //文件中读出来的数据是
//        System.out.println("文件中读出来的数据是：");
//        for (byte b : all)
//        {
//            int i = b&0x000000ff;  //只取16进制的后两位
//            System.out.println(Integer.toHexString(i));
//        }
//        System.out.println("把这个数字，放在GBK的棋盘上去：");
//        String str = new String(all,"GBK");
//        System.out.println(str);
//    } catch (IOException e) {
////        // TODO Auto-generated catch block
////        e.printStackTrace();
////    }
//        File f = new File("test2.txt");
//        System.out.println("默认编码方式:"+ Charset.defaultCharset());
//        //FileReader得到的是字符，所以一定是已经把字节根据某种编码识别成了字符了
//        //而FileReader使用的编码方式是Charset.defaultCharset()的返回值，如果是中文的操作系统，就是GBK
//        try (FileReader fr = new FileReader(f)) {
//            char[] cs = new char[(int) f.length()];
//            fr.read(cs);
//            System.out.printf("FileReader会使用默认的编码方式%s,识别出来的字符是：%n",Charset.defaultCharset());
//            System.out.println(new String(cs));
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        //FileReader是不能手动设置编码方式的，为了使用其他的编码方式，只能使用InputStreamReader来代替
//        //并且使用new InputStreamReader(new FileInputStream(f),Charset.forName("UTF-8")); 这样的形式
//        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(f),Charset.forName("BIG5"))) {
//            char[] cs = new char[(int) f.length()];
//            isr.read(cs);
//            System.out.printf("InputStreamReader 指定编码方式UTF-8,识别出来的字符是：%n");
//            System.out.println(new String(cs));
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        byte[] bytes = new byte[3];
        bytes[0] = (byte) 0xE5;
        bytes[1] = (byte) 0xB1;
        bytes[2] = (byte) 0x8c;
        System.out.println(new String(bytes,"UTF-8"));

    }

}



