import java.util.Scanner;
class Pizza {
    String Dough;
    String Sauce;
    String Topping;

    public void setDough(String dough) {
        Dough = dough;
    }

    public void setSauce(String sauce) {
        Sauce = sauce;
    }

    public void setTopping(String topping) {
        Topping = topping;
    }
}

abstract class PizzaBuilder
{
    protected Pizza pizza;

    public Pizza getPizza()
    {
        return pizza;
    }

    public void createNewPizzaProduct()
    {
        pizza = new Pizza();
    }

    public abstract void buildDough();
    public abstract void buildSauce();
    public abstract void buildTopping();
}

class SpicyPizzaBuilder extends PizzaBuilder
{
    @Override
    public void buildDough()
    {
        pizza.setDough("pan baked");
    }
    @Override
    public void buildSauce()
    {
        pizza.setSauce("hot");
    }
    @Override
    public void buildTopping()
    {
        pizza.setTopping("pepperoni+salami");
    }
}

class HawaiianPizzaBuilder extends PizzaBuilder
{
    @Override
    public void buildDough()
    {
        pizza.setDough("cross");
    }
    @Override
    public void buildSauce()
    {
        pizza.setSauce("mild");
    }
    @Override
    public void buildTopping()
    {
        pizza.setTopping("ham+pineapple");
    }
}

class Waiter
{
    private PizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder pb)
    {
        pizzaBuilder = pb;
    }
    public Pizza getPizza()
    {
        return pizzaBuilder.getPizza();
    }
    public void constructPizza()
    {
        pizzaBuilder.createNewPizzaProduct();
        pizzaBuilder.buildDough();
        pizzaBuilder.buildSauce();
        pizzaBuilder.buildTopping();
    }
}
public class Lab4_HandsOn2
{
    public static void main(String[] args)
    {
        Waiter waiter = new Waiter();
        PizzaBuilder hawaiianPizzaBuilder = new HawaiianPizzaBuilder();
        PizzaBuilder spicyPizzaBuilder = new SpicyPizzaBuilder();
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        if (n.equals("Hawaiian"))
        {
            waiter.setPizzaBuilder(hawaiianPizzaBuilder);
            waiter.constructPizza();
            Pizza pizza = waiter.getPizza();
            System.out.println(pizza.Dough);
            System.out.println(pizza.Sauce);
            System.out.println(pizza.Topping);
        }
        else if (n.equals("Spicy"))
        {
            waiter.setPizzaBuilder(spicyPizzaBuilder);
            waiter.constructPizza();
            Pizza pizza = waiter.getPizza();
            System.out.println(pizza.Dough);
            System.out.println(pizza.Sauce);
            System.out.println(pizza.Topping);
        }
    }
}