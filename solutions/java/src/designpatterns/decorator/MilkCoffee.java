package designpatterns.decorator;

public class MilkCoffee extends DecoratorCoffee {
    public MilkCoffee(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double cost() {
        return super.cost() + 4;
    }

    @Override
    public String description() {
        return super.description() + ", Milk";
    }
}
