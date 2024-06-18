package shoppingcart.payments;

public class PaypalPayment implements PaymentStrategy {
    private String userId;

    public PaypalPayment(String userId) {
        this.userId = userId;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid via PaypalPayment for " + userId + ":-> " + amount);
    }
}
