package pizza.pizza.hub.decorators;

import pizza.pizza.hub.abstracts.PizzaDecorator;
import pizza.pizza.hub.interfaces.PizzaComponent;

public class SpecialPackagingDecorator extends PizzaDecorator {

    private String packageName;

    public SpecialPackagingDecorator(PizzaComponent decoratedPizza, String packageName) {
        super(decoratedPizza);
        this.packageName=packageName;
    }


    @Override
    public String getDescription() {
        return decoratedPizza.getDescription()+" "+ packageName;
    }



    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

}
