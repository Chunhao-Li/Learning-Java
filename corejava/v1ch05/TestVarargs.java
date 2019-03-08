import java.util.*;

public class TestVarargs
{
    public static void main(String[] args)
    {
        int[] luckeyNumbers = new int[30];
        for (int i = 0; i < luckeyNumbers.length; i++)
            luckeyNumbers[i] = i + 1;
        String s = Arrays.toString(luckeyNumbers);
        System.out.println(s);

        double largest = max(1.3, 35.2, 4.4, -2345,0, 342);
        // System.out.printf("%.1f\n", largest);
        // System.out.println("");    
    }

    public static double max(double... values)
    {
        double largest = Double.NEGATIVE_INFINITY;
        for (double v : values)
            if (v > largest)
                largest = v;
        return largest;
    }
}