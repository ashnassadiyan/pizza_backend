package pizza.pizza.hub.requests;

import pizza.pizza.hub.model.Pizza;

import java.util.ArrayList;

public class OrderRequest {
  private int customerId;
  private String deliveryMethod;
  private String paymentType;
  private String cardDetails;
  private double points;
  private ArrayList<PizzaRequest> pizzaList;

    public ArrayList<PizzaRequest> getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(ArrayList<PizzaRequest> pizzaList) {
        this.pizzaList = pizzaList;
    }

    public String getPayment() {
        return paymentType;
    }



    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCardDetails() {
        return cardDetails;
    }

    public void setCardDetails(String cardDetails) {
        this.cardDetails = cardDetails;
    }




    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public void getDetails(){
        System.out.println(customerId+""+deliveryMethod+""+paymentType+"");
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
