package pizza.pizza.hub.model;

import pizza.pizza.hub.interfaces.PaymentStrategy;

public class LoyaltyProgramPayment implements PaymentStrategy {
    private final Customer customer;

    public LoyaltyProgramPayment(Customer customer) {
        this.customer = customer;
    }

    public void pay(double amount) {
        if (customer.getLoyaltyPoints() >= amount) {
            customer.deductLoyaltyPoints(amount);
            System.out.println("Paid " + amount + " using Loyalty Points. Remaining points: " + customer.getLoyaltyPoints());
        } else {
            System.out.println("Not enough loyalty points. Payment failed.");
            throw new IllegalArgumentException("Not enough loyalty points. Required: " + amount + ", Available: " + customer.getLoyaltyPoints());

        }

    }
}
