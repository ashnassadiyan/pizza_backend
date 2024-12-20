package pizza.pizza.hub.Services;

import pizza.pizza.hub.model.Crust;

import java.util.ArrayList;

public class CrustService {
    private static final ArrayList<Crust> crusts = new ArrayList<>();

    static {
        Crust one = new Crust(1, "Pan", 1200.00,"Pan");
        crusts.add(one);
        Crust two = new Crust(2, "Sausage", 1000.00,"Sausage");
        crusts.add(two);

    }

    public static ArrayList<Crust> getCrusts() {
        return crusts;
    }
}
