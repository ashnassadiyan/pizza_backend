package pizza.pizza.hub.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import pizza.pizza.hub.abstracts.User;
import pizza.pizza.hub.commands.Manager;
import pizza.pizza.hub.commands.PizzaShop;
import pizza.pizza.hub.commands.PlaceOrderCommand;
import pizza.pizza.hub.commands.ProvideFeedbackCommand;
import pizza.pizza.hub.decorators.ExtraToppingsDecorator;
import pizza.pizza.hub.decorators.SpecialPackagingDecorator;
import pizza.pizza.hub.handlers.*;
import pizza.pizza.hub.interfaces.Commands;
import pizza.pizza.hub.interfaces.PizzaComponent;
import pizza.pizza.hub.model.*;
import pizza.pizza.hub.requests.FeedbackRequest;
import pizza.pizza.hub.requests.OrderRequest;
import pizza.pizza.hub.requests.PizzaRequest;
import pizza.pizza.hub.response.ErrorResponse;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class OrderService {

    private final SimpMessagingTemplate messagingTemplate;
    private final HashMap<String, Order> orderList = new HashMap<>();
    Manager manager = new Manager();
    PizzaShop pizzaShop = new PizzaShop();

    @Autowired
    public OrderService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public ResponseEntity<Object> createOrder(OrderRequest order) {
        try {
            ArrayList<PizzaRequest> pizzaRequestsList = order.getPizzaList();
            ArrayList<PizzaComponent> pizzas = new ArrayList<>();

            Customer customer =null;
            for (User cu: UserService.users ){
                if (cu instanceof Customer && cu.getId() == order.getCustomerId()) {
                    customer = (Customer) cu;
                    break;
                }
            }

            double total = 0;

            for (PizzaRequest pizzaRe : pizzaRequestsList) {
                for (int i = 0; i < pizzaRe.getQty(); i++) {
                    Pizza.PizzaBuilder pizzaBuilder = new Pizza.PizzaBuilder();
                    SizeHandler sizeHandler = new SizeHandler();
                    CrustHandler crustHandler = new CrustHandler();
                    ToppingHandler toppingHandler = new ToppingHandler();
                    SauceHandler sauceHandler = new SauceHandler();
                    CheeseHandler cheeseHandler=new CheeseHandler();


                    sizeHandler.setNextHandler(crustHandler);
                    crustHandler.setNextHandler(toppingHandler);
                    toppingHandler.setNextHandler(sauceHandler);

                    CustomizationRequest[] requests = {
                            new CustomizationRequest("size", pizzaRe.getSize()),
                            new CustomizationRequest("crust",pizzaRe.getCrust()),
                            new CustomizationRequest("topping", pizzaRe.getTopping()),
                            new CustomizationRequest("sauce", pizzaRe.getSauce()),
                            new CustomizationRequest("cheese", pizzaRe.getCheese()),
                    };

                    for (CustomizationRequest request : requests) {
                        sizeHandler.handleRequest(pizzaBuilder, request);
                    }
                    pizzaBuilder.setName(pizzaRe.getName());
                    PizzaComponent pizza=pizzaBuilder.build();
                    System.out.println(pizzaRe.getExtra());
                    System.out.println(pizzaRe.getPacking());

                    if(pizzaRe.getExtra() != null && !pizzaRe.getExtra().isEmpty()){
                        pizza=new ExtraToppingsDecorator(pizza,pizzaRe.getExtra());
                    }

                    if(pizzaRe.getPacking()!=null&& !pizzaRe.getPacking().isEmpty()){
                        pizza=new SpecialPackagingDecorator(pizza,pizzaRe.getPacking());
                    }

                    pizzas.add(pizza);
                }
                total += pizzaRe.getTotal();
            }

            PaymentContext paymentContext = new PaymentContext();

            System.out.println(order.getPayment());
            order.getDetails();

            if(order.getPayment().equals("cash")){
                paymentContext.setPaymentStrategy(new CashPayment());
                paymentContext.pay(total);
                customer.setLoyaltyPoints(total);
            }

            if(order.getPayment().equals("card")){
                paymentContext.setPaymentStrategy(new CreditCardPayment(order.getCardDetails()));
                paymentContext.pay(total);
                customer.setLoyaltyPoints(total);
            }

            if(order.getPayment().equals("wallet")){
                paymentContext.setPaymentStrategy(new WalletPayment(order.getCardDetails()));
                paymentContext.pay(total);
                customer.setLoyaltyPoints(total);
            }

            if(order.getPayment().equals("loyalty")){
                paymentContext.setPaymentStrategy(new LoyaltyProgramPayment(customer));
                paymentContext.pay(total/10);
            }

            if(order.getPayment().equals("promotion")){
                paymentContext.setPaymentStrategy(new PromotionPayment(pizzas));
                paymentContext.pay(total);
            }

            String orderId = Order.UniqueIdGenerator();
            Order newOrder = new Order(pizzas, order.getPayment(), order.getCustomerId(),
                    order.getDeliveryMethod(), orderId, total, messagingTemplate);
            orderList.put(orderId, newOrder);

            Commands placeOrder = new PlaceOrderCommand(pizzaShop, orderId);
            manager.addCommand(placeOrder);
            manager.executeCommands();
            return new ResponseEntity<>(orderId, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            ErrorResponse errorResponse = new ErrorResponse("An unexpected error occurred.", 500);
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> myOrders(int customerId) {
        try {
            return new ResponseEntity<>(orderList, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<Object> myOrder(String orderId) {
        try {
            Order order = orderList.get(orderId);
            if (order == null) {
                return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(orderList.get(orderId), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String updateOrderStatus(OrderStatusUpdate update) {
        try {
            Order order = orderList.get(update.getOrderId());
            order.updateOrderState(update.getStatus());

            return "Status updated";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<Object> getAllOrders() {
        try {
            return new ResponseEntity<>( orderList.values().toArray(new Order[0]), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String customerFeedback(FeedbackRequest feedback) {
        try {
                Commands provideFeedback = new ProvideFeedbackCommand(pizzaShop, feedback.getComment());
                manager.addCommand(provideFeedback);
                manager.executeCommands();

           return "updated";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
