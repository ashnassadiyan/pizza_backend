package pizza.pizza.hub.Services;

import pizza.pizza.hub.model.Topping;

import java.util.ArrayList;

public class ToppingService {

    private static final ArrayList<Topping> toppings = new ArrayList<>();


    static {
        Topping one = new Topping(1, "Spicy Fish", 1200.00);
        toppings.add(one);
        Topping two = new Topping(2, "Veggie Masala ", 1000.00);
        toppings.add(two);
        Topping three = new Topping(3, "Chilli Chicken", 900.00);
        toppings.add(three);
    }


    public static ArrayList<Topping> getToppings() {
        return toppings;
    }



}
