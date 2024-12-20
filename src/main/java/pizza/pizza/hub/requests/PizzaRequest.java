package pizza.pizza.hub.requests;

public class PizzaRequest {
  private int cheese;
  private int crust;
  private String name;
  private int qty;
  private int sauce;
  private int topping;
  private int size;
  private String extra;
  private String packing;
  private double total;

    public int getCheese() {
        return cheese;
    }

    public void setCheese(int cheese) {
        this.cheese = cheese;
    }

    public int getCrust() {
        return crust;
    }

    public void setCrust(int crust) {
        this.crust = crust;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getExtra() {

        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
