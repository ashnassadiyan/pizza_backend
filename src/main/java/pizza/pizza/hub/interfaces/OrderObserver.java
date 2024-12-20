package pizza.pizza.hub.interfaces;

public interface OrderObserver {
    void update(String orderStatus, String orderId);
}
