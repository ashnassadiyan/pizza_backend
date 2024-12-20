package pizza.pizza.hub.handlers;

import pizza.pizza.hub.abstracts.CustomizationHandler;
import pizza.pizza.hub.model.CustomizationRequest;
import pizza.pizza.hub.model.Pizza;

public class CheeseHandler extends CustomizationHandler {
    @Override
    public void handleRequest(Pizza.PizzaBuilder pizzaBuilder, CustomizationRequest request) {
        if ("cheese".equalsIgnoreCase(request.getType())) {
            System.out.println("Adding cheese: " + request.getValue());
            pizzaBuilder.setSize(request.getValue());
        } else if (nextHandler != null) {
            nextHandler.handleRequest(pizzaBuilder, request);
        }
    }
}
