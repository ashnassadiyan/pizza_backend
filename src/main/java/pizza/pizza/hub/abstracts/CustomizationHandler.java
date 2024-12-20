package pizza.pizza.hub.abstracts;

import pizza.pizza.hub.interfaces.PizzaComponent;
import pizza.pizza.hub.model.CustomizationRequest;
import pizza.pizza.hub.model.Pizza;

public abstract class CustomizationHandler {
    protected CustomizationHandler nextHandler;

    public void setNextHandler(CustomizationHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(Pizza.PizzaBuilder pizzaBuilder, CustomizationRequest request);
}
