package pizza.pizza.hub.abstracts;

import pizza.pizza.hub.interfaces.PizzaComponent;

public abstract class PizzaDecorator implements PizzaComponent {
    protected final PizzaComponent decoratedPizza;


    public PizzaDecorator(PizzaComponent decoratedPizza) {
        this.decoratedPizza = decoratedPizza;
    }




}
