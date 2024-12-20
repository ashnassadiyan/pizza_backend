package pizza.pizza.hub.handlers;

import pizza.pizza.hub.abstracts.CustomizationHandler;
import pizza.pizza.hub.model.CustomizationRequest;
import pizza.pizza.hub.model.Pizza;

public class SauceHandler extends CustomizationHandler {
    @Override
    public void handleRequest(Pizza.PizzaBuilder pizzaBuilder, CustomizationRequest request) {
        if ("sauce".equalsIgnoreCase(request.getType())) {
            System.out.println("Adding sauce: " + request.getValue());
            pizzaBuilder.setSize(request.getValue());
        } else if (nextHandler != null) {
            nextHandler.handleRequest(pizzaBuilder, request);
        }
    }
}
