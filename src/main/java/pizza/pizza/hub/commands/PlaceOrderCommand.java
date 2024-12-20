package pizza.pizza.hub.commands;

import pizza.pizza.hub.interfaces.Commands;

public class PlaceOrderCommand implements Commands {
    private PizzaShop pizzaShop;
    private String pizzaType;

    public PlaceOrderCommand(PizzaShop pizzaShop, String pizzaType) {
        this.pizzaShop = pizzaShop;
        this.pizzaType = pizzaType;
    }

    @Override
    public void execute() {
        pizzaShop.placeOrder(pizzaType);
    }
}
