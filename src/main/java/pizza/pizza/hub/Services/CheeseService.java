package pizza.pizza.hub.Services;
import pizza.pizza.hub.model.Cheese;

import java.util.ArrayList;

public class CheeseService {
    private static final ArrayList<Cheese> cheeses = new ArrayList<>();

    public static ArrayList<Cheese> getCheeses() {
        return cheeses;
    }

    static {
        Cheese one = new Cheese( "Mozzarella", 500.00);
        cheeses.add(one);
        Cheese two = new Cheese( "Cheddar", 700.00);
        cheeses.add(two);

    }

}
