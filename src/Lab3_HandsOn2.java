import java.util.HashMap;

abstract class Device implements Cloneable
{
    private String manufacturerName;
    private String screenSize;
    private String RAM;
    private String OS;
    private double capacity;
    private double price;
    private double quantity = 0;
     public void showTotalPrice()
     {
         System.out.println("Total Price: " + price * quantity);
     }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

     Device(String manufacturerName, String screenSize, String RAM, String OS, double capacity, double price, double quantity) {
         this.manufacturerName = manufacturerName;
         this.screenSize = screenSize;
         this.RAM = RAM;
         this.OS = OS;
         this.capacity = capacity;
         this.price = price;
         this.quantity = quantity;
     }


    public void displayCharacteristics() {
        System.out.println("Manufacturer Name: " + manufacturerName);
        System.out.println("Screen Size: " + screenSize);
        System.out.println("RAM: " + RAM);
        System.out.println("OS: " + OS);
        System.out.println("Capacity: " + capacity);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}

class Labtop extends Device
{
    private String keyboardType;
    Labtop (String manufacturerName, String screenSize, String RAM, String OS, double capacity, double price, double quantity , String keyboardType) {
        super(manufacturerName, screenSize, RAM, OS, capacity, price, quantity);
        this.keyboardType = keyboardType;
    }

    public String getKeyboardType() {
        return keyboardType;
    }

    public void setKeyboardType(String keyboardType) {
        this.keyboardType = keyboardType;
    }

    @Override
    public void displayCharacteristics() {
        super.displayCharacteristics();
        System.out.println("Keyboard Type: " + getKeyboardType());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Tablet extends Device
{
    Tablet (String manufacturerName, String screenSize, String RAM, String OS, double capacity, double price, double quantity) {
        super(manufacturerName, screenSize, RAM, OS, capacity, price, quantity);
    }
    @Override
    public void displayCharacteristics() {
        super.displayCharacteristics();
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Register
{
    private static HashMap<String, Device> deviceMap = new HashMap<String, Device>();

    static
    {
        deviceMap.put("labtop", new Labtop("Dell", "15.6", "8GB", "Windows 10", 1, 10000, 1, "Mechanical"));
        deviceMap.put("tablet", new Tablet("Samsung", "10.1", "4GB", "Android", 1, 5000, 1));
    }
    public Device getDevice(String deviceName)
    {
        Object clone = null;
        try
        {
            clone = deviceMap.get(deviceName).clone();
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
        return (Device) clone;
    }
}
public class Lab3_HandsOn2 {
    public static void main(String[] args)
    {
        Register r  = new Register();
        Device obj = r.getDevice("laptop");
        obj.setManufacturerName("HP");
        obj.setScreenSize("15.6");
        obj.setRAM("8GB");
        obj.setOS("Windows 10");
        obj.setCapacity(1);
        obj.setPrice(10000);
        obj.setQuantity(1);
        obj.displayCharacteristics();
        obj.showTotalPrice();

        Device obj2 = r.getDevice("tablet");
        obj2.setManufacturerName("Samsung");
        obj2.setScreenSize("10.1");
        obj2.setRAM("4GB");
        obj2.setOS("Android");
        obj2.setCapacity(1);
        obj2.setQuantity(7);
        obj2.setPrice(5000);
        obj2.displayCharacteristics();
        obj2.showTotalPrice();
    }
}
