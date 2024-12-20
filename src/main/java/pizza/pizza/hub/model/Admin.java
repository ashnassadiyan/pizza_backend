package pizza.pizza.hub.model;

import pizza.pizza.hub.abstracts.User;

public class Admin extends User {
    private final String role;

    public Admin(String type,String email,String password,String role) {
        super( type, email,password);
        this.role=role;
    }

    public String getRole() {
        return role;
    }
}
