package pizza.pizza.hub.decorators;

import pizza.pizza.hub.abstracts.PizzaDecorator;
import pizza.pizza.hub.interfaces.PizzaComponent;

public class ExtraToppingsDecorator extends PizzaDecorator {

    private String extra;
    public ExtraToppingsDecorator(PizzaComponent decoratedPizza,String extra ) {
        super(decoratedPizza);
        this.extra=extra;
    }

    @Override
    public String getDescription() {
        return decoratedPizza.getDescription()+" "+extra;
    }


    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }


}
