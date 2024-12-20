package pizza.pizza.hub.model;

import pizza.pizza.hub.abstracts.User;
import pizza.pizza.hub.interfaces.PaymentStrategy;
import pizza.pizza.hub.interfaces.PizzaComponent;

import java.util.ArrayList;

public class PromotionPayment  implements PaymentStrategy {
    ArrayList<PizzaComponent> pizzas = new ArrayList<>();
    private final int crustDiscount = 2;
    private final int sizeDiscount = 1;
    private final int toppingDiscount = 3;

    public PromotionPayment(ArrayList<PizzaComponent> pizzas){
        this.pizzas=pizzas;
    }


    public void pay(double amount) {
        double totalDiscount = 0;

        for (PizzaComponent pizza : pizzas) {
            Pizza newPizza= (Pizza) pizza;
            if (newPizza.getCrust() == crustDiscount && newPizza.getSize() == sizeDiscount) {
                totalDiscount += 5;
            } else if (newPizza.getTopping() == toppingDiscount) {
                totalDiscount += 3;
            } else {
                System.out.println("No discount for pizza: " + newPizza.getName());
            }
        }

                double finalAmount = amount - totalDiscount;
        System.out.println("Original amount: " + amount);
        System.out.println("Total discount: " + totalDiscount);
        System.out.println("Final amount to pay: " + finalAmount);

        if (finalAmount <= 0) {
            System.out.println("Amount covered by discounts. No payment needed.");
        }
    }
}
