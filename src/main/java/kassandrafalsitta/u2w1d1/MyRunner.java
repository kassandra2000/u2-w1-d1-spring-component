package kassandrafalsitta.u2w1d1;

import kassandrafalsitta.u2w1d1.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

    @Override
    public void run(String... args) throws Exception {


        System.out.println(order.printOrderDetails());
        System.out.println(order1.printOrderDetails());
        System.out.println(order2.printOrderDetails());


    }

}
