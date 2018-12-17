/**
 * This is the first sample program in Core Java Chapter 3
 * @version 1.01 1997-03-22
 * @author Gary Cornell
 */
public class FirstSample
{
   public static void main(String[] args)
   {
      System.out.println("We will not use 'Hello, World!'");

//      double x=9.997;
//      int nx = (int) Math.round(x);
//      System.out.println(nx); // pirnts 2.0

//
//      double y1 = Math.pow(x, 3);
//      System.out.println(y1);

//      int n = 123456789;
//      float f = n;
//      System.out.println(f);

//      boolean test = 7 == 3;
//      int test = "".length();System.out.println(test);
//      String greeting = "Hello";
//      int n = greeting.length();
//      double x = 100000.0/3.0;
//      System.out.printf("%tc", new Date());
//        for (int i = 10; i > 0; i--)
//            System.out.println("Counting down ..." + i);
//        System.out.println("Blastoff!");
       for (double x = 0; x != 10; x += 0.1)
           System.out.println(x);
   }
}