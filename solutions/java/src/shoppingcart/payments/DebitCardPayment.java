package shoppingcart.payments;

public class DebitCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid via debit card" + amount);
    }
}
