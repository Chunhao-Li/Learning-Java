package medium.IO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestReader {
    public static void main(String[] args) {
//        File f = new File("lol.txt");
//        try (FileWriter fr = new FileWriter(f);) {
////            char[] all = new char[(int) f.length()];
//            String data = "abcdefg1234567890";
////            fr.read(all);
//            char[] cs = data.toCharArray();
//            fr.write(data);
////            for (char b : all) {
////                System.out.println(b);
////            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        File encodingFile = new File("lol.txt");
        File encodedFile = new File("test2.txt");
        encodeFile(encodingFile, encodedFile);
    }

    /**
     *
     * @param encodingFile File needs to be encoded
     * @param encodedFile encoded file
     */
    public static void encodeFile(File encodingFile, File encodedFile) {
        try (FileReader fr = new FileReader(encodingFile);
        FileWriter fw = new FileWriter(encodedFile)) {

            char[] fileContent = new char[(int) encodingFile.length()];
            fr.read(fileContent);
            System.out.println("contents before encoding: ");
            System.out.println(new String(fileContent));

            // encode
            encode(fileContent);
            System.out.println("contents after encoding: ");
            System.out.println(new String(fileContent));

            fw.write(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void encode(char[] fileContent) {
        for (int i = 0; i < fileContent.length; i++) {
            char c = fileContent[i];
            if (isLetterOrDigit(c)) {
                switch (c) {
                    case '9':
                        c = '0';
                        break;
                    case 'z':
                        c = 'a';
                        break;
                    case 'Z':
                        c = 'A';
                        break;
                    default:
                        c++;
                        break;
                }
            }
            fileContent[i] = c;
        }
    }

    public static boolean isLetterOrDigit(char c) {
        String letterOrDigital = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        return -1 != letterOrDigital.indexOf(c) ;
    }
}
