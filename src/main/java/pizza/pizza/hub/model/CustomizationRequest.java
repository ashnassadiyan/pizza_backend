package pizza.pizza.hub.model;

public class CustomizationRequest {
    private final String type;
    private final int value;

    public CustomizationRequest(String type, int value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
}
