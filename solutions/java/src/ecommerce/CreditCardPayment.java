package ecommerce;

public class CreditCardPayment implements Payment {
    @Override
    public boolean processPayment(double amount) {
        return true;
    }
}
