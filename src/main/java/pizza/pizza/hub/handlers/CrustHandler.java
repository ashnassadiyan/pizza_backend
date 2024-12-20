package pizza.pizza.hub.handlers;

import pizza.pizza.hub.abstracts.CustomizationHandler;
import pizza.pizza.hub.model.CustomizationRequest;
import pizza.pizza.hub.model.Pizza;

public class CrustHandler extends CustomizationHandler {

    @Override
    public void handleRequest(Pizza.PizzaBuilder pizzaBuilder, CustomizationRequest request) {
        if ("crust".equalsIgnoreCase(request.getType())) {
            System.out.println("Setting crust: " + request.getValue());
            pizzaBuilder.setCrust(request.getValue());
        } else if (nextHandler != null) {
            nextHandler.handleRequest(pizzaBuilder, request);
        }
    }
}
