package pizza.pizza.hub.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class OrderStatusController {

    @MessageMapping("/order/status")
    @SendTo("/topic/order")
    public String updateOrderStatus(@Payload String orderStatus) {
        return "Order status updated to: " + orderStatus;
    }
}
