package designpatterns.decorator;

public class DecoratorDemo {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee(100);
        System.out.println(coffee.cost());
        coffee = new MilkCoffee(coffee);
        System.out.println(coffee.cost());
        coffee = new SugarCoffee(coffee);
        System.out.println(coffee.cost());
    }
}
