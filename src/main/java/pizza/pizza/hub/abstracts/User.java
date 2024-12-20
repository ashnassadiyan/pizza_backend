package pizza.pizza.hub.abstracts;

public abstract class User {
    private static int idCounter = 0;
    private final int id;
    private final String type;
    private final String email;
    private final String password;

    public User(String type,String email,String password){
        this.id = ++idCounter;
        this.email=email;
        this.password=password;
        this.type=type;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }
}
