package pizza.pizza.hub.model;

import pizza.pizza.hub.abstracts.User;
import pizza.pizza.hub.interfaces.OrderObserver;

public class Customer extends User implements OrderObserver {
    private String name;
    private String address;
    private String phone;
    private double loyaltyPoints;



    public Customer(String type, String email, String password, String name, String address, String phone) {
        super(type, email, password);
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.loyaltyPoints=0;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void update(String orderStatus, String orderId) {
        System.out.println("Hello " + name + ", your order (" + orderId + ") is now: " + orderStatus);
    }

    public double getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(double points) {
        loyaltyPoints += calculateLoyaltyPoints(points);
    }

    public void deductLoyaltyPoints(double points){
        loyaltyPoints -= points;
    }

    public double calculateLoyaltyPoints(double total) {
        if (total > 10000) {
            return 6;
        } else if (total > 5000) {
            return 5;
        } else if (total > 3000) {
            return 3;
        } else if (total > 1000) {
            return 2;
        } else {
            return 1;
        }
    }

    }
