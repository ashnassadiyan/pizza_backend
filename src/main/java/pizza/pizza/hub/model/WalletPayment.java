package pizza.pizza.hub.model;

import pizza.pizza.hub.interfaces.PaymentStrategy;

public class WalletPayment implements PaymentStrategy {
    private String walletId;

    public WalletPayment(String walletId) {
        this.walletId = walletId;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Wallet ID: " + walletId);
    }
}
