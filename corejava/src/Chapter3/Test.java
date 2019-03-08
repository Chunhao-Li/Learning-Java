import java.util.Date;
import java.math.*;
import java.util.Arrays;
import java.util.*;
import java.time.LocalDate;

public class Test{

public static void main(String[] args) {
    // System.out.printf("%tc", new Date());
    // System.out.println();
    // System.out.println("-------------");
    // System.out.printf("%1$s %2$tB %2$te, %2$tY", "Due date:", new Date());
    // System.out.printf("%s %tB %<te, %<tY", "Due date:", new Date());
    // System.out.println();
    
    // String dir = System.getProperty("user.dir"); // get the current directory
    // System.out.println(dir);

    // for (int i = 1; i <= 10; i++)
        // System.out.println(i); 
    // for (int i = 10; i > 0; i--)
    //     System.out.println("Counting down . . ." + i);
    // System.out.println("Blastoff!");
    // for (double x = 0; x != 10; x += 0.1) 
        // System.out.println(x);  // never ends
    // BigInteger a = BigInteger.valueOf(100);
    // BigInteger c = a.add(BigInteger.valueOf(2));
    // System.out.println(a);
    // System.out.println(c);
    // BigInteger b = a.multiply(c);
    // System.out.println(b);
    // 
//    for (int i = 0; i < 10; i++) names[i] = ""; // create an array of empty strings (default is null)
// //    
//     int[] smallPrimes = {2, 3, 5, 7, 11, 13 };
//     System.out.println(Arrays.toString(smallPrimes));

    /* Print all values of an array */
    // double[] doubleTest = new double[10];
    // for (int i = 0; i < 5; i++)
        // doubleTest[i] = i;
    // System.out.println(Arrays.toString(doubleTest));
/* Array Initializers */
    // int[] smallPrimes = {2, 3, 5, 7, 11, 13};
    // smallPrimes = new int[] {17, 19, 23, 29, 31, 37};
    // 
//    System.out.println(new Date()); // Date is the constructor
//    
    // String s = new Date().toString();
    // Date birthday = new Date();
    // System.out.println(birthday);
    // 
    // 
    // Date deadline = new Date();
    // birthday = null;
    // String s = birthday.toString;
    // System.out.println(LocalDate.now());
    // System.out.println(LocalDate.of(1999,12, 31));
    // LocalDate newYearsEve = LocalDate.of(1999, 12, 31);
    // 
    // System.out.println(Strings.repeat("*", 4));
    // System.out.println(-5/2);
    // double test = 1;
    // System.out.println(5/2);
    // 
    // System.out.println(1 / 2);




    double percent = 10;
    System.out.println(percent);
    tripleValue(percent);
    System.out.println(percent);

//    
}


public static void tripleValue(double x)
    {
        System.out.println("x:" + x);
        x = 3 * x;
        System.out.println("After x:" + x);
    }
    

}