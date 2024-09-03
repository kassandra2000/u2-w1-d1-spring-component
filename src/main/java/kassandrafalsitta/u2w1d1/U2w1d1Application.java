package kassandrafalsitta.u2w1d1;

import kassandrafalsitta.u2w1d1.entities.FoodAndDrink;
import kassandrafalsitta.u2w1d1.entities.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Collectors;

@SpringBootApplication
public class U2w1d1Application {


	static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(U2w1d1Application.class);
	static Menu menu = context.getBean(Menu.class);
	public static void main(String[] args) {
		SpringApplication.run(U2w1d1Application.class, args);
		printPizzas();
		printPizzasXL();
		printToppings();
		printDrinks();


		context.close();
	}

	public static void printPizzas() {
		System.out.println("\n");
		System.out.println("Pizzas                                                        Calories            Price");
		menu.getPizze().forEach(pizza -> {
			String toppings = pizza.getToppings().stream()
					.map(FoodAndDrink::getName)
					.collect(Collectors.joining(", "));
			System.out.printf("%-10s %-45s %10d %18.2f\n", pizza.getName(), "(" + toppings + ")", pizza.getCalories(), pizza.getPrice());
		});
	}
	public static void printPizzasXL() {
		System.out.println("\n");
		System.out.println("Pizzas XL                                                     Calories            Price");

		menu.getPizzeXl().forEach(pizza -> {
			String toppings = pizza.getToppings().stream()
					.map(FoodAndDrink::getName)
					.collect(Collectors.joining(", "));
			System.out.printf("%-13s %-45s %8d %18.2f\n",pizza.getName(),"(" +toppings+")", pizza.getCalories(), pizza.getPrice());
		});
	}
	public static void printToppings() {
		System.out.println("\nToppings                                                      Calories            Price");
		menu.getToppings().forEach(topping ->
				System.out.printf("%-20s %46d %18.2f\n", topping.getName(), topping.getCalories(), topping.getPrice())
		);
	}
	public static void printDrinks() {
		System.out.println("\nDrinks                                                       Calories             Price");

		menu.getDrinks().forEach(drink ->
				System.out.printf("%-20s %46d %18.2f\n", drink.getName(), drink.getCalories(), drink.getPrice())
		);
	}

}
