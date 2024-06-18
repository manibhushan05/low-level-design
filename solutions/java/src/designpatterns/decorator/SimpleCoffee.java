package designpatterns.decorator;

public class SimpleCoffee implements Coffee{
    private double amount;

    public SimpleCoffee(double amount){
        this.amount = amount;
    }

    @Override
    public double cost() {
        return amount;
    }

    @Override
    public String description() {
        return "Coffee: ";
    }
}
