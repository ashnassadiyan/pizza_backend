package pizza.pizza.hub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pizza.pizza.hub.Services.*;
import pizza.pizza.hub.model.*;

import java.util.List;


@RestController
@RequestMapping("/pizza")
public class PizzaController {

    @GetMapping("/topping")
    public List<Topping> getToppingsList(){
        return ToppingService.getToppings();
    }

    @GetMapping("/sauces")
    public List<Sauce> getSauces(){
        return SauceService.getSauces();
    }

    @GetMapping("/crusts")
    public List<Crust> getCrusts(){
        return CrustService.getCrusts();
    }

    @GetMapping("/cheeses")
    public List<Cheese> getCheeses(){
        return CheeseService.getCheeses();
    }


    @GetMapping("/sizes")
    public List<Size> getSizes(){
        return SizeService.getSizes();
    }

    @GetMapping("/getPizza")
    public String getPizza(){
        return "its working";
    }

}
