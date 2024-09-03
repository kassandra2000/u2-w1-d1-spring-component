package kassandrafalsitta.u2w1d1;

import kassandrafalsitta.u2w1d1.entities.FoodAndDrink;
import kassandrafalsitta.u2w1d1.entities.Menu;
import kassandrafalsitta.u2w1d1.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    @Qualifier("getOrder")
    private Order order;
    @Autowired
    @Qualifier("getOrder1")
    private Order order1;
    @Autowired
    @Qualifier("getOrder2")
    private Order order2;
    @Autowired
    Menu menu;

    @Override
    public void run(String... args) throws Exception {


        System.out.println(order.printOrderDetails());
        System.out.println(order1.printOrderDetails());
        System.out.println(order2.printOrderDetails());

        printPizzas();
        printPizzasXL();
        printToppings();
        printDrinks();
        System.out.println(menu);


    }
    public  void printPizzas() {
        System.out.println("\n");
        System.out.println("Pizzas                                                        Calories            Price");
        menu.getPizze().forEach(pizza -> {
            String toppings = pizza.getToppings().stream()
                    .map(FoodAndDrink::getName)
                    .collect(Collectors.joining(", "));
            System.out.printf("%-10s %-45s %10d %18.2f\n", pizza.getName(), "(" + toppings + ")", pizza.getCalories(), pizza.getPrice());
        });
    }
    public  void printPizzasXL() {
        System.out.println("\n");
        System.out.println("Pizzas XL                                                     Calories            Price");

        menu.getPizzeXl().forEach(pizza -> {
            String toppings = pizza.getToppings().stream()
                    .map(FoodAndDrink::getName)
                    .collect(Collectors.joining(", "));
            System.out.printf("%-13s %-45s %8d %18.2f\n",pizza.getName(),"(" +toppings+")", pizza.getCalories(), pizza.getPrice());
        });
    }
    public  void printToppings() {
        System.out.println("\nToppings                                                      Calories            Price");
        menu.getToppings().forEach(topping ->
                System.out.printf("%-20s %46d %18.2f\n", topping.getName(), topping.getCalories(), topping.getPrice())
        );
    }
    public  void printDrinks() {
        System.out.println("\nDrinks                                                       Calories             Price");

        menu.getDrinks().forEach(drink ->
                System.out.printf("%-20s %46d %18.2f\n", drink.getName(), drink.getCalories(), drink.getPrice())
        );
    }

}
