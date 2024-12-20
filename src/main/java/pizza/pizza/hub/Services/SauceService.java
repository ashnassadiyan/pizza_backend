package pizza.pizza.hub.Services;


import pizza.pizza.hub.model.Crust;
import pizza.pizza.hub.model.Sauce;

import java.util.ArrayList;

public class SauceService {
    private static final ArrayList<Sauce> sauces = new ArrayList<>();

    static {
        Sauce one = new Sauce(1, "Spicy Red Sauce", 1200.00);
        sauces.add(one);
        Sauce two = new Sauce(2, "Garlic sauce", 1000.00);
        sauces.add(two);
        Sauce three = new Sauce(2, "Alfredo sauce", 700.00);
        sauces.add(three);
    }


    public static ArrayList<Sauce> getSauces() {
        return sauces;
    }
}
