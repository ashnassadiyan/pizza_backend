package pizza.pizza.hub.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pizza.pizza.hub.Services.UserService;
import pizza.pizza.hub.model.Customer;
import pizza.pizza.hub.requests.FavouriteRequest;
import pizza.pizza.hub.requests.LoginRequest;

@RestController
@RequestMapping("/customer")
public class UserController {

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody Customer customer){
        return UserService.registerUser(customer);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Customer customer){
        return UserService.login(customer);
    }

    @PostMapping("/addFavourite")
    public ResponseEntity<Object> addFavourite(@RequestBody FavouriteRequest newFavourite){
        return UserService.addFavourite(newFavourite);
    }


    @GetMapping("/getFavourite")
    public ResponseEntity<Object> getFavourite(@RequestParam String customerId){
        return UserService.getFavourite(customerId);
    }

    @GetMapping("/getLoyaltyPoints")
    public ResponseEntity<Object> getLoyaltyPoints(@RequestParam int customerId){
        return UserService.getLoyaltyPoints(customerId);
    }


//

}
