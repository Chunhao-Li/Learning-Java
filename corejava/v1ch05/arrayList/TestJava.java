package arrayList;
import java.util.*;

/**
 * @SuppressWarnings("unchecked") ArrayList<Employee> result = 
 * (ArrayList<Employee>) Test.find("test aa");
 */

public class TestJava
{
    public static void main(String[] args)
    {

    
      ArrayList<Employee> staff = new ArrayList<Employee>(10);
      Test.update(staff);
      ArrayList<Employee> result = (ArrayList<Employee>) Test.find("test aa");

    
    }
}