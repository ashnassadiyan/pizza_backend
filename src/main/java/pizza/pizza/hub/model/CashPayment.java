package pizza.pizza.hub.model;

import pizza.pizza.hub.interfaces.PaymentStrategy;

public class CashPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Cash.");
    }
}
