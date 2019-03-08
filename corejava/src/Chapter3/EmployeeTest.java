import java.time.*;

/**
 * 
 */









public class EmployeeTest
{
    public static void main(String[] args) {
        // fill the staff array with three Employee objects
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Porter", 5090,1924,2,3);


        for (Employee e : staff)
            System.out.println(e);
            // System.out.println(e.getName());
    }
}