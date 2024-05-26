package ecommerce;

public class EcommerceDemo {
    public static void run() {
        User user1 = new User("Mani", "+918978937498");
        User user2 = new User("Deepak", "+919939717008");
        OrderManager orderManager = OrderManager.getInstance();
        orderManager.registerUser(user1);
        orderManager.registerUser(user2);

        Product product1 = new Product("iPhone", 50000, 10);
        Product product2 = new Product("MacBook Pro", 100000, 5);

        orderManager.addProduct(product1);
        orderManager.addProduct(product2);

        ShoppingCart cart1 = new ShoppingCart();
        cart1.addItem(product1, 2);
        cart1.addItem(product2, 3);

        Payment payment1 = new CreditCardPayment();

        Order order1 = orderManager.placeOrder(user1, cart1, payment1);
        System.out.println(order1.getId());
        System.out.println(product1.getQuantity());
        System.out.println(product2.getQuantity());
        System.out.println("Searching Product");
        for (Product product : orderManager.searchProduct("p")) {
            System.out.println(product.getName());
        }
    }
}
