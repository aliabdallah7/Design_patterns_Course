class Singleton
{
    private static Singleton instance = null;
    private Singleton() {}
    public static Singleton getInstance()
    {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }
}
public class Singletonn
{
    public static void main(String[] args)
    {
        Singleton obj = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        Singleton obj3 = Singleton.getInstance();
        System.out.println("Hashcode of obj = " + obj.hashCode());
        System.out.println("Hashcode of obj2 = " + obj2.hashCode());
        System.out.println("Hashcode of obj3 = " + obj3.hashCode());
    }
}