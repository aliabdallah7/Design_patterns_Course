class Accounter {
    public String firstName;
    public String lastName;
    public int salary;

    private static Accounter instance = null;
    public static Accounter getInstance(String firstName, String lastName, int salary)
    {
        if (instance == null)
            instance = new Accounter(firstName, lastName, salary);
        return instance;
    }

    private Accounter(String firstName, String lastName, int salary)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }
    public void info()
    {
        System.out.println("First name: " + firstName);
        System.out.println("Last name: " + lastName);
        System.out.println("Salary: " + salary);
    }
}

public class Lab3_HandsOn1
{
    public static void main(String[] args)
    {
        Accounter obj = Accounter.getInstance("Ali", "Abdallah", 1000);
        obj.info();

        // hashCode() is a method inherited from the Object class.
        // It returns an integer representation of an object's memory address.
        System.out.println("Hashcode of obj = " + obj.hashCode());
        Accounter newObj = Accounter.getInstance("Hussein", "Fathy", 2000);
        newObj.info();
        System.out.println("Hashcode of newobj = " + newObj.hashCode());
    }
}