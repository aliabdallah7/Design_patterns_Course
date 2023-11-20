interface GermantType{
    public String print();
}

class Trouser implements GermantType{
    @Override
    public String print() {
        return "Trouser";
    }
}

class Shirt implements GermantType
{
    @Override
    public String print() {
        return "Shirt";
    }
}

class Factory
{
    public static GermantType getGermantType(String type)
    {
        if(type == null){
            return null;
        }
        if(type.equalsIgnoreCase("Trouser")){
            return new Trouser();
        }
        else if(type.equalsIgnoreCase("Shirt")){
            return new Shirt();
        }
        return null;
    }
}

public class Lab4_HandsOn1 {
    public static void main(String[] args)
    {
        GermantType obj = Factory.getGermantType("Trouser");
        GermantType obj2 = Factory.getGermantType("Shirt");
        System.out.println(obj.print());
        System.out.println(obj2.print());
    }
}
