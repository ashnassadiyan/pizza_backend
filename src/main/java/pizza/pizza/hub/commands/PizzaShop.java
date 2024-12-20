package pizza.pizza.hub.commands;

public class PizzaShop {
    public void placeOrder(String orderId) {
        System.out.println("Start the order for " + orderId + ".");
    }

    public void provideFeedback(String feedback) {
        System.out.println("Feedback received: " + feedback);
    }

    public void cancelOrder(String orderId) {
        System.out.println("Order for " + orderId + " pizza has been canceled.");
    }
}
