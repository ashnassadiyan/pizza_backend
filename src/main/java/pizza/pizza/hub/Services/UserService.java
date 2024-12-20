package pizza.pizza.hub.Services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pizza.pizza.hub.model.Admin;
import pizza.pizza.hub.model.Customer;
import pizza.pizza.hub.abstracts.User;
import pizza.pizza.hub.model.Favourite;
import pizza.pizza.hub.model.Order;
import pizza.pizza.hub.requests.FavouriteRequest;
import pizza.pizza.hub.response.ErrorResponse;

import java.util.ArrayList;
import java.util.HashMap;

public class UserService {

    public static final ArrayList<User> users=new ArrayList<>();
    private static final HashMap<String, ArrayList<Favourite>> favouriteList = new HashMap<>();

    static {
        Admin admin = new Admin( "admin","admin@gmail.com","123","admin");
        users.add(admin);
    }

    public static ResponseEntity<Object> registerUser(Customer user) {
        try {
            // checking user exist
            for (User u : users) {
                if (u.getEmail().equals(user.getEmail())) {
                    ErrorResponse errorResponse = new ErrorResponse("A user with this email already exists.", 400);
                    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
                }
            }
            Customer newCustomer = new Customer("customer", user.getEmail(), user.getPassword(), user.getName(),user.getAddress(),user.getPhone());
            users.add(newCustomer);
            return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse("An unexpected error occurred.", 500);
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static ResponseEntity<Object> login(Customer loginUser) {
        try {
            System.out.println(loginUser.getEmail());
            User foundUser = null;
            for (User user : users) {
                if (user.getEmail().equals(loginUser.getEmail())) {
                    foundUser = user;
                    break;
                }
            }
            if (foundUser != null) {
                if (foundUser.getPassword().equals(loginUser.getPassword())) {
                    return new ResponseEntity<>(foundUser, HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(
                            new ErrorResponse("Invalid password", 401),
                            HttpStatus.UNAUTHORIZED
                    );
                }
            }
            return new ResponseEntity<>(
                    new ErrorResponse("User not found", 404),
                    HttpStatus.NOT_FOUND
            );

        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse("An unexpected error occurred", 500);
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static ResponseEntity<Object> addFavourite(FavouriteRequest newFavourite) {
        try {
            Favourite favourite=new Favourite(
                newFavourite.getPizzaList().getCrust(),
                newFavourite.getPizzaList().getSauce(),
                newFavourite.getPizzaList().getTopping(),
                newFavourite.getPizzaList().getCheese(),
                newFavourite.getPizzaList().getSize(),
                newFavourite.getPizzaList().getName()
            );

            String customerId=String.valueOf(newFavourite.getCustomerId());

            if (favouriteList.containsKey(customerId)) {
                for (Favourite fav : favouriteList.get(customerId)) {
                    if (fav.getName().equalsIgnoreCase( newFavourite.getPizzaList().getName())) {
                        return new ResponseEntity<>("existing", HttpStatus.BAD_REQUEST);
                    }
                }
                favouriteList.get(customerId).add(favourite);
            } else {
                ArrayList<Favourite> arrayList=new ArrayList<>();
                arrayList.add(favourite);
                favouriteList.put(customerId,arrayList);
            }
            return new ResponseEntity<>("Success", HttpStatus.CREATED);

        } catch (Exception e) {
            System.out.println(e);
            ErrorResponse errorResponse = new ErrorResponse("An unexpected error occurred", 500);
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static ResponseEntity<Object> getFavourite(String customerId) {
        try {

            ArrayList<Favourite> myList=favouriteList.get(customerId);
            return new ResponseEntity<>(myList, HttpStatus.OK);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse("An unexpected error occurred", 500);
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static ResponseEntity<Object> getLoyaltyPoints(int customerId) {
        try {

            Customer customer =null;
            for (User cu: users ){
                if (cu instanceof Customer && cu.getId() == customerId) {
                    customer = (Customer) cu;
                    break;
                }
            }

            return new ResponseEntity<>(customer.getLoyaltyPoints(), HttpStatus.OK);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse("An unexpected error occurred", 500);
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
