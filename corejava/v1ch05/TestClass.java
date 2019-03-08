import java.lang.*;
import java.util.*;

public class TestClass 
{
    public static void main(String[] args)
    {
        try
        {
            Class clb;
            String className = "java.util.Random";
            clb = Class.forName(className);
            System.out.println("Here!");
        }
        catch (Exception e)
        {
            System.out.println("This is catch!");
            e.printStackTrace();
        }

        // String className = ;
        // Class clb = Class.forName("java.util.Random");
        Random generator = new Random();
        Class cl = generator.getClass();
        String name = cl.getName();
        System.out.println(cl);
    }
}