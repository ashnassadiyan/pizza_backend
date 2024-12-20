package pizza.pizza.hub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pizza.pizza.hub.Services.OrderService;
import pizza.pizza.hub.model.OrderStatusUpdate;
import pizza.pizza.hub.requests.FeedbackRequest;
import pizza.pizza.hub.requests.OrderRequest;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService; // Inject the OrderService

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody OrderRequest order) {
        return orderService.createOrder(order); // Call the instance method
    }

    @GetMapping("/myOrders")
    public ResponseEntity<Object> myOrders(@RequestParam int id) {
        return orderService.myOrders(id);
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<Object> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/myOrder")
    public ResponseEntity<Object> myOrder(@RequestParam String id) {
        return orderService.myOrder(id);
    }


    @PostMapping("/status")
    public String updateOrderStatus(@RequestBody OrderStatusUpdate update) {
        return orderService.updateOrderStatus(update);
    }

    @PostMapping("/customerFeedback")
    public String customerFeedback(@RequestBody FeedbackRequest feedbackRequest) {
        return orderService.customerFeedback(feedbackRequest);
    }
}
