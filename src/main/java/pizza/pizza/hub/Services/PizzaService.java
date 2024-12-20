package pizza.pizza.hub.Services;

import pizza.pizza.hub.model.Pizza;

import java.util.ArrayList;

public class PizzaService {
    private final ArrayList<Pizza> pizzaList=new ArrayList<>();


    public ArrayList<Pizza> getPizzaList() {
        return pizzaList;
    }

    public void addPizza(Pizza pizza) {
        pizzaList.add(pizza);
    }




}
