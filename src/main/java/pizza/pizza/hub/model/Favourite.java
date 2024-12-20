package pizza.pizza.hub.model;

import pizza.pizza.hub.interfaces.PizzaComponent;

public class Favourite implements PizzaComponent {


    private final int crust;
    private final int sauce;
    private final int topping;
    private final int cheese;
    private final int size;
    private final String name;



    public Favourite(
            int crust,
            int sauce ,
            int topping ,
            int cheese,
            int size,
            String name){

        this.crust=crust;
        this.sauce=sauce;
        this.topping=topping;
        this.cheese=cheese;
        this.size=size;
        this.name=name;
    }

    public String getName() {
        return name;
    }


    public int getCrust() {
        return crust;
    }

    public int getCheese() {
        return cheese;
    }


    public int getSauce() {
        return sauce;
    }


    public int getTopping() {
        return topping;
    }

    @Override
    public String getDescription() {
        return getName();
    }


    public int getSize() {
        return size;
    }
}
