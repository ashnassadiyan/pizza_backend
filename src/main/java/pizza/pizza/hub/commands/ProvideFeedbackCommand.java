package pizza.pizza.hub.commands;

import pizza.pizza.hub.interfaces.Commands;

public class ProvideFeedbackCommand implements Commands {
    private PizzaShop pizzaShop;
    private String feedback;

    public ProvideFeedbackCommand(PizzaShop pizzaShop, String feedback) {
        this.pizzaShop = pizzaShop;
        this.feedback = feedback;
    }

    @Override
    public void execute() {
        pizzaShop.provideFeedback(feedback);
    }
}
