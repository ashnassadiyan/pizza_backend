package pizza.pizza.hub.handlers;

import pizza.pizza.hub.abstracts.CustomizationHandler;
import pizza.pizza.hub.model.CustomizationRequest;
import pizza.pizza.hub.model.Pizza;

public class SizeHandler extends CustomizationHandler {

    @Override
    public void handleRequest(Pizza.PizzaBuilder pizzaBuilder, CustomizationRequest request) {
        if ("size".equalsIgnoreCase(request.getType())) {
            System.out.println("Selecting the size: " + request.getValue());
            pizzaBuilder.setSize(request.getValue());
        } else if (nextHandler != null) {
            nextHandler.handleRequest(pizzaBuilder, request);
        }
    }
}
