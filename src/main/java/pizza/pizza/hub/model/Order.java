package pizza.pizza.hub.model;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import pizza.pizza.hub.interfaces.OrderObserver;
import pizza.pizza.hub.interfaces.OrderStatus;
import pizza.pizza.hub.interfaces.PizzaComponent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderStatus;
    private final ArrayList<PizzaComponent> pizzaList;
    private final String paymentType;
    private final int customerId;
    private final String deliveryMethod;
    private final String orderId;
    private final double total;
    private final List<OrderObserver> observers = new ArrayList<>();
    private final SimpMessagingTemplate messagingTemplate;
    private OrderStatus state;

    public Order(ArrayList<PizzaComponent> pizzaList, String payment, int customerId, String deliveryMethod,
                 String orderId, double total, SimpMessagingTemplate messagingTemplate) {
        this.total = total;
        this.orderStatus = "accepted";
        this.pizzaList = pizzaList;
        this.paymentType = payment;
        this.customerId = customerId;
        this.deliveryMethod = deliveryMethod;
        this.orderId = orderId;
        this.messagingTemplate = messagingTemplate;
        this.state = new AcceptedState();
    }

    public void setState(OrderStatus state) {
        this.state = state;
    }

    public void updateOrderState(String newState) {
        state.updateState(this, newState);
        notifyObservers();
    }


    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(orderStatus, orderId);
        }
        notifyWebSocket();
    }

    private void notifyWebSocket() {
        String destination = "/topic/order/" + orderId;
        messagingTemplate.convertAndSend(destination, new OrderUpdate(orderId, orderStatus));
    }

    public void setOrderStatus(String newStatus) {
        this.orderStatus = newStatus;
        notifyObservers();
    }

    public String getOrderStatus() {
       return orderStatus;
    }

    public static String UniqueIdGenerator() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        LocalDateTime now = LocalDateTime.now();
        return now.format(formatter);
    }

    public String getOrderId() {
        return orderId;
    }

    public double getTotal() {
        return total;
    }

    public int getCustomerId() {
        return customerId;
    }

    public ArrayList<PizzaComponent> getPizzaList() {
        return pizzaList;
    }

    public String getPayment() {
        return paymentType;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }
}

class OrderUpdate {
    private final String orderId;
    private final String status;

    public OrderUpdate(String orderId, String status) {
        this.orderId = orderId;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }
}
