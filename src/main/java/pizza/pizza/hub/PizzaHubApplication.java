package pizza.pizza.hub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pizza.pizza.hub.Services.ToppingService;

@SpringBootApplication
public class PizzaHubApplication {

	public static void main(String[] args) {

		SpringApplication.run(PizzaHubApplication.class, args);
		ToppingService toppingService =new ToppingService();
	}

}
