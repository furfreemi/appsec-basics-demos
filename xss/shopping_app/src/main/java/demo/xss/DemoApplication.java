package demo.xss;

import demo.xss.shopping.model.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public LinkedList<Order> ordersList() {
		LinkedList<Order> orders = new LinkedList<>();
		orders.add(new Order("Philip Fry", "12345 W. Springfield, VA", "13243546576879", "57.34"));
		orders.add(new Order("Bender Rodriguez", "52431 East Main, VA", "6545345470990", "23.75"));
		return orders;
	}
}
