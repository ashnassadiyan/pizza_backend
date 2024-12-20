package pizza.pizza.hub.responses;

public class PizzaResponse {
    private String name;
    private int crust;
    private int cheese;
    private int sauce;
    private int topping;
    private String extra;
    private String packageName;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCrust() {
        return crust;
    }

    public void setCrust(int crust) {
        this.crust = crust;
    }

    public int getCheese() {
        return cheese;
    }

    public void setCheese(int cheese) {
        this.cheese = cheese;
    }

    public int getSauce() {
        return sauce;
    }

    public void setSauce(int sauce) {
        this.sauce = sauce;
    }

    public int getTopping() {
        return topping;
    }

    public void setTopping(int topping) {
        this.topping = topping;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
