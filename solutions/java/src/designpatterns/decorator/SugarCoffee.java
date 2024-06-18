package designpatterns.decorator;

public class SugarCoffee extends DecoratorCoffee {
    public SugarCoffee(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double cost() {
        return super.cost() + 5;
    }
}
