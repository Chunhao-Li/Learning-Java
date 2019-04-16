package medium.IO;

import java.io.*;
import java.util.Arrays;

public class PracticeSplitFile {
    public static void main(String[] args) {
//        File f = new File("haha.txt");
////        FileOutputStream fos = new FileOutputStream(f);
//        byte[] data = new byte[100*1024]; // 100k
//        int count = 0;
//        try {
//            FileInputStream fis = new FileInputStream(f);
//
//
//            try {
//                while (fis.available() > 0) {
//
//                    if (fis.available() < data.length) {
//                        data = new byte[fis.available()];
//                    }
//                    fis.read(data);
//                    File newFile = new File("haha.txt-" + count);
//                    FileOutputStream fos = new FileOutputStream(newFile);
//                    fos.write(data);
//                    count++;
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        int eachSize = 100 * 1024;
        File srcFile = new File("haha.txt");
        splitFile(srcFile, eachSize);
//        int i = 0;
//        String childFileName = "haha.txt" + "-" + i;
//        File f = new File(childFileName);
//        while (f.exists()) {
//            mergeFiles(f);
//            i++;
//            childFileName = "haha.txt" + "-" + i;
//            f = new File(childFileName);
//        }
        mergeFiles("haha.txt");

    }

    private static void splitFile(File srcFile, int eachSize) {
        if (srcFile.length() == 0) throw new RuntimeException("The file's length is 0.");
        byte[] fileContent = new byte[(int) srcFile.length()];
        // read the file input byte[]
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(srcFile);
            fis.read(fileContent);

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int fileNumber;
        if (fileContent.length % eachSize == 0) {
            fileNumber = (int) (fileContent.length / eachSize);
        }
        else {
            fileNumber = (int) (fileContent.length/ eachSize) + 1;

        }

        for (int i = 0; i < fileNumber; i++) {
            String eachFileName = srcFile.getName()+"-" + i;
            File eachFile = new File(srcFile.getParent(), eachFileName);
            byte[] eachContent;
            if (i != fileNumber-1)  {// not the last one
                eachContent = Arrays.copyOfRange(fileContent, eachSize*i, eachSize*(i+1));

        }
        else {
            eachContent = Arrays.copyOfRange(fileContent, eachSize*i, fileContent.length);
            }
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(eachFile);
                fos.write(eachContent);
                System.out.printf("Output the file%s, its size is %d bytes %n", eachFile.getAbsoluteFile(), eachFile.length());
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    if (fos != null) {
                        fos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }
}
//    private static void mergeFiles(File f) {
////        File f = new File(fileName);
////        if (!f.exists()) {return;}
//        byte[] data = new byte[(int) f.length()];
//        try {
//            FileInputStream fis = new FileInputStream(f);
//            fis.read(data);
//            FileOutputStream fos = new FileOutputStream("haha-merge.txt");
//            fos.write(data);
//
//            fis.close();
//            fos.close();
//            System.out.printf("merge file %s of %d bytes %n", f.getName(), f.length());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
    private static void mergeFiles(String fileName) {

        File destFile = new File(fileName+"-merge");
        try (FileOutputStream fos = new FileOutputStream(destFile);) {
            // 合并的目标文件


            int index = 0;
            while (true) {
                //子文件
                File eachFile = new File(fileName + "-" + index++);
                //如果子文件不存在了就结束
                if (!eachFile.exists())
                    break;

                //读取子文件的内容
                try (FileInputStream fis = new FileInputStream(eachFile)) {
                    byte[] eachContent = new byte[(int) eachFile.length()];
                    fis.read(eachContent);
//                fis.close();

                    //把子文件的内容写出去
                    fos.write(eachContent);
                    fos.flush();

                }
                System.out.printf("把子文件 %s写出到目标文件中%n", eachFile);
            }
        }
                catch (IOException e) {
                    e.printStackTrace();
                }


//            fos.close();
            System.out.printf("最后目标文件的大小：%,d字节" , destFile.length());



    }
}
