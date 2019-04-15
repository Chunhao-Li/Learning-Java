package corejava.Chapter5.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CopyOfTest {
    /**
     * This method attempts to grow an array by allocating a new array and copying all elements.
     * @param a the array to grow
     * @param newLength the new length
     * @return a larger array that contains all elements of a. However, the returned array has
     * type Object[], not the same type as a
     */
    public static Object[] badCopyOf(Object[] a, int newLength) // not useful
    {
        Object[] newArray = new Object[newLength];
        System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
        return newArray;
    }

    /**
     *
     *
     */
    public static Object goodCopyOf(Object a, int newLength) {
        Class cl = a.getClass();
        if (!cl.isArray()) return null;
        Class componontType = cl.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componontType, newLength);
        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        a = (int[]) goodCopyOf(a, 10);
        System.out.println(Arrays.toString(a));

        String[] b = {"Tom", "Dick", "Harry"};
        b = (String[]) goodCopyOf(b, 10);
        System.out.println(Arrays.toString(b));

        System.out.println("The following call will generate an exception.");
        b = (String[]) badCopyOf(b, 10);
    }
}
