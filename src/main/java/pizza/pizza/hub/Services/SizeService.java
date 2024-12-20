package pizza.pizza.hub.Services;
import pizza.pizza.hub.model.Size;

import java.util.ArrayList;

public class SizeService {
    private static final ArrayList<Size> sizes = new ArrayList<>();

    public static ArrayList<Size> getSizes() {
        return sizes;
    }

    static {
        Size one = new Size( 1,"Large",500);
        sizes.add(one);
        Size two = new Size( 2,"Medium",300);
        sizes.add(two);
    }

}
