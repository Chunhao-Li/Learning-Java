package medium.IO;

import java.io.File;
import java.util.Date;

public class TestFile {
//        File f1 = new File("~/LOL.txt");
//        System.out.println("f1's absolute path: " + f1.getPath());
//
//        File f2 = new File("LOL.txt");
//        System.out.println("f2's absolute path: " + f2.getAbsolutePath());
//
//        File f3 = new File(f1, "LOl.txt");
//        System.out.println("f3's absolute path: " + f3.getAbsolutePath());
//        File f = new File("/Users/frederick/Documents/Programming/LearnINg-java/how2j/LOL.txt");
//        System.out.println("current file is " + f);
//        System.out.println("Does f exist? " + f.exists());
//
//        System.out.println("Is f a folder? " + f.isDirectory());
//        System.out.println("Is f a file? " + f.isFile());
//
//        System.out.println("f's length " + f.length());
//
//        long time = f.lastModified();
//        Date d = new Date(time);
//        System.out.println("Last modified time: " + d);
//        f.setLastModified(0);
//
//        File f2 = new File("/Users/frederick/Documents/Programming/LearnINg-java/how2j/Dota.txt");
//        f.renameTo(f2);
////        System.out.println();
//        File f = new File("/Users/frederick/Documents/Programming/Learning-Java/how2j/LOLFolder");
////        f.mkdir();
//        f.list();
//        f.getParent();
//        f.mkdirs();
//        f.deleteOnExit();
//        f.createNewFile();
//        File f = new File("/Users/frederick");
//        File[] fs= f.listFiles();
//        System.out.println(fs);
//        for (File file : fs) {
//            System.out.println(file);
//        }
//        if (fs == null) return;
//        long minSize = Integer.MIN_VALUE;
//        long maxSize = 0;
//        File minFile = null;
//        File maxFile = null;
//        for (File file : fs) {
//            if (file.isDirectory()) continue;
//            if (file.length() > maxSize) {
//                maxSize = file.length();
//                maxFile=file;
//                System.out.println("here");
//            }
//            if (file.length()<minSize) {
//                minSize = file.length();
//                minFile = file;
//                System.out.println("here");
//            }
//        }
//        System.out.printf("Max file is %s, its size is %d byte %n",maxFile.getAbsolutePath(),maxFile.length());
//        System.out.printf("Min file is %s, its size is %,d byte %n",minFile.getAbsolutePath(),minFile.length());

    static long minSize = Integer.MAX_VALUE;
    static long maxSize = 0;
    static File minFile = null;
    static File maxFile = null;





    public static void listFiles(File file) {
        if (file.isFile()) {
            if (file.length() > maxSize) {
                maxSize = file.length();
                maxFile = file;
        }
        if (file.length() != 0 && file.length() < minSize) {
            minSize = file.length();
            minFile = file;
        }
        return;

    }

    if (file.isDirectory()) {
        File[] fs = file.listFiles();
        if (fs != null) {
            for (File f : fs) {
                listFiles(f);
            }
        }
    }


}

    public static void main(String[] args) {
        File f = new File("/users/frederick/documents");
        listFiles(f);
        System.out.printf("最大的文件是%s，其大小是%,d字节%n",maxFile.getAbsoluteFile(),maxFile.length());
        System.out.printf("最小的文件是%s，其大小是%,d字节%n",minFile.getAbsoluteFile(),minFile.length());



    }
}
