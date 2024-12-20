package pizza.pizza.hub.model;

public class Crust extends Customization {
//    sausage and pan
    private final String crustType;

    public Crust(int id, String name, double price,String crustType) {
        super(id, name, price);
        this.crustType=crustType;
    }

    public String getType() {
        return crustType;
    }
}
