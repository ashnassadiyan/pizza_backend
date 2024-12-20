package pizza.pizza.hub.model;

import pizza.pizza.hub.interfaces.PizzaComponent;

public class Pizza implements PizzaComponent  {
    private static int idCounter = 0;
    private final int id;
    private final int size;
    private final int crust;
    private final int sauce;
    private final int topping;
    private final int cheese;
    private final String name;

    private Pizza(PizzaBuilder builder) {
        this.id = ++idCounter;
        this.crust = builder.crust;
        this.size=builder.size;
        this.cheese = builder.cheese;
        this.sauce = builder.sauce;
        this.topping = builder.topping;
        this.name = builder.name;
    }


    public int getId() {
        return id;
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
        return name+"Pizza";
    }

    public int getSize() {
        return size;
    }


    public static class PizzaBuilder {
        private int size;
        private int crust;
        private int sauce;
        private int topping;
        private int cheese;
        private String name;

        public PizzaBuilder setSize(int size) {
            this.size = size;
            return this;
        }

        public PizzaBuilder setCrust(int crust) {
            this.crust = crust;
            return this;
        }

        public PizzaBuilder setCheese(int cheese) {
            this.cheese = cheese;
            return this;
        }

        public PizzaBuilder setSauce(int sauce) {
            this.sauce = sauce;
            return this;
        }

        public PizzaBuilder setTopping(int topping) {
            this.topping = topping;
            return this;
        }

        public PizzaBuilder setName(String name) {
            this.name = name;
            return this;
        }






        public Pizza build() {
            return new Pizza(this);
        }
    }
}
