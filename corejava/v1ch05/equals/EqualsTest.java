package equals;

/**
 * This program demonstrates the equals method.
 * @version 1 2018-12-27
 * @author Cay Horstmann
 */
public class EqualsTest
{
   public static void main(String[] args)
   {
      Employee alice1 = new Employee("Alice Adams", 75000, 1987, 12, 15);
      Employee alice2 = alice1;
      Employee alice3 = new Employee("Alice Adams", 75000, 1987, 12, 15);
      Employee bob = new Employee("Bob Brandson", 50000, 1989, 10, 1);

      System.out.println("alice1 == alice2: " + (alice1 == alice2));

      System.out.println("alice1 == alice3: " + (alice1 == alice3));

      System.out.println("alice1.equals(alice3): " + alice1.equals(alice3));

      System.out.println("alice1.equals(bob): " + alice1.equals(bob));

      System.out.println("bob.toString(): " + bob); // bob.toString(): equals.Employee[name=Bob Brandson,salary=50000.0,hireDay=1989-10-01]
                                                // equals is the package name
      Manager carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
      Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
      boss.setBonus(5000);
      System.out.println("boss.toStirng(): " + boss);
      System.out.println("carl.equals(boss): " + carl.equals(boss));
      System.out.println("alice1.hashCode(): " + alice1.hashCode());
      System.out.println("alice2.hashCode(): " + alice2.hashCode());
      System.out.println("bob.hashCode(): " + bob.hashCode());
      System.out.println("carl.hashCode(): " + carl.hashCode());
      System.out.println("boss.hashCode(): " + boss.hashCode());


   }
}