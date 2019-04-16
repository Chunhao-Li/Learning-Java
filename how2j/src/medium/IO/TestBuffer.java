package medium.IO;

import java.io.*;

public class TestBuffer {
    public static void main(String[] args) {
//        File f = new File("lol.txt");
//
//        try (
//            FileReader fr = new FileReader(f);
//            BufferedReader br = new BufferedReader(fr); )
//        {
//            while (true) {
//                String line = br.readLine();
//                if (null == line) {
//                    break;
//                }
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        File f = new File("lol2.txt");
//
//        try (
//        PrintWriter pw = new PrintWriter(f);) {
//            pw.println("hahaha line 1");
//            pw.flush();
//            pw.println("hahaha line 2");
//            pw.write("write test");
//            pw.println("hahaha line 3");
//        } catch (IOException e ) {
//            e.printStackTrace();
//        }
        File javaFile = new File("MyHashMap.java");
        removeComments(javaFile);

    }
    public static void removeComments(File javaFile) {
        StringBuffer sb = new StringBuffer();
        try (FileReader fr = new FileReader(javaFile);
        BufferedReader br = new BufferedReader(fr);) {
            while (true) {
                String line = br.readLine();
                if (null == line) {
                    break;
                }
                if (!line.trim().startsWith("//")) {
                    sb.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter pw = new PrintWriter(javaFile);) {
            pw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
