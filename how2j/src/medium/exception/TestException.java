package medium.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestException {
    public static void main(String[] args) {
//        File f = new File("d:/LOL.exe");
//        try{
////            new FileInputStream(f);
////            System.out.println("success");
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            Date d = sdf.parse("2016-06-03");
//        }
//            catch (ParseException e)
//        {
//            System.out.println("failed!");
//            e.printStackTrace();
//
//        }
//        finally {
//            System.out.println("here");
//        }
        method1();
    }

    private static void method1() {
        try {
            method2();
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void method2() throws FileNotFoundException {
        File f = new File("~/Downloads/HelloWorld.txt");
        System.out.println("try openning");
        new FileInputStream(f);
        System.out.println("success");
    }
}
