package pizza.pizza.hub.model;

import pizza.pizza.hub.interfaces.OrderStatus;

public class AcceptedState implements OrderStatus {
    @Override
    public void updateState(Order order, String newState) {
        order.setState(new PreparingState());
        order.setOrderStatus("preparing");
    }
}

class PreparingState implements OrderStatus {
    @Override
    public void updateState(Order order, String newState) {
        if (order.getDeliveryMethod().equalsIgnoreCase("delivery")) {
            order.setState(new DeliveringState());
            order.setOrderStatus("delivering");
        } else {
            order.setState(new DoneState());
            order.setOrderStatus("done");
        }
    }
}

class DeliveringState implements OrderStatus {
    @Override
    public void updateState(Order order, String newState) {
        order.setState(new CompletedState());
        order.setOrderStatus("completed");
    }
}

class DoneState implements OrderStatus {
    @Override
    public void updateState(Order order, String newState) {
        order.setState(new CompletedState());
        order.setOrderStatus("completed");
    }
}

class CompletedState implements OrderStatus {
    @Override
    public void updateState(Order order, String newState) {
        throw new IllegalStateException("cannot go further");
    }
}
