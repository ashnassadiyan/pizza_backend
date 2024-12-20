package pizza.pizza.hub.interfaces;

import pizza.pizza.hub.model.Order;

public interface OrderStatus {
    void updateState(Order order, String newState);
}
