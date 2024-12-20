package pizza.pizza.hub.requests;

import java.util.ArrayList;

public class FavouriteRequest {
    private int customerId;
    private PizzaRequest pizzaList;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public PizzaRequest getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(PizzaRequest pizzaList) {
        this.pizzaList = pizzaList;
    }
}
