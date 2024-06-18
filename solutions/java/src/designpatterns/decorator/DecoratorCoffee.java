package designpatterns.decorator;

public abstract class DecoratorCoffee implements Coffee {
    private Coffee decoratedCoffee;

    public DecoratorCoffee(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost();
    }

    @Override
    public String description() {
        return decoratedCoffee.description();
    }
}
