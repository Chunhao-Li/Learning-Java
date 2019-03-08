package Chapter5.inheritance;

// import java.util.*;
import java.time.*;

class Employee
{
    // private static int nextId;

    private String name ;
    private double salary;
    private LocalDate hireDay;


    // static initialization block
    // static
    // {
    //     Random generator = new Random();
    //     // set nextId to a random number between 0 and 9999
    //     nextId = generator.nextInt(10000);
    // }

    // // object initialization block
    // {
    //     id = nextId;
    //     nextId++;
    // }

    // three overloaded constructors
    

    public Employee(String name, double salary, int year, int month, int day)
    {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);

    }

    // public Employee(double s)
    // {
    //     // calls the Employee(String, double) constructor
    //     this("Employee #" + nextId, s);
    // }

    // // the default constructor 
    // public Employee()
    // {
    //     // name initialized to ""
    //     // salary not explicitly set--initialized to 0
    //     // id initialized in initialization block
    // }

    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    // public int getId()
    // {
    //     return id;
    // }
    // 
    public LocalDate getHireDay()
    {
        return hireDay;
    }

    // public void setId()
    // {
    //     id = nextId;
    //     nextId++;
    // }

    // public static int getNextId()
    // {
    //     return nextId;
    // }

    // public static void main(String[] args)
    // {
    //     Employee e = new Employee("Harry", 50000);
    //     System.out.println(e.getName() + " " + e.getSalary());
    // }
    // 
    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent /100;
        salary += raise;
    }
}