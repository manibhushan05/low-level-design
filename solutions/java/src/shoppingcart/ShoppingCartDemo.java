package shoppingcart;

import parkinglot.vehicletype.Car;
import shoppingcart.payments.DebitCardPayment;
import shoppingcart.payments.PaypalPayment;

public class ShoppingCartDemo {
    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.addItem(new Item("Item 1"));
        cart.addItem(new Item("Item 2"));
        cart.makePayment(new PaypalPayment("mani@gmail.com"), 100);
        cart.makePayment(new DebitCardPayment(), 110);
    }
}
