package pizza.pizza.hub.model;

public class Cheese extends Customization {
    private static int counter = 0; // generate id auto

    public Cheese(String name, double price) {
        super(++counter, name, price); // Increment counter and assign as ID
    }
}