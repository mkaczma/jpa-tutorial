package com.acme;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.order.customer.Customer;
import com.acme.order.customer.CustomerRepository;
import com.acme.order.customer.CustomerTypeRepository;
import com.acme.order.pizza.PizzaOrderService;
import com.acme.order.pizza.PizzaType;
import com.google.common.collect.Lists;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JpaTutorialApplication.class)
public class JpaTutorialApplicationTests {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CustomerTypeRepository customerTypeRepository;
	@Autowired
	private PizzaOrderService orderService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void loadData() {
		Customer customer1 = new Customer(null, "John Smith", "john@smith.com", "Lodz, Jaracza 74",
				customerTypeRepository.findOne(1l));
		Customer customer2 = new Customer(null, "Jan Kowalski", "jan@kowalski.pl", "Lodz, Piotrkowska 100",
				customerTypeRepository.findOne(2l));
		customerRepository.save(Lists.newArrayList(customer1, customer2));

		orderService.createOrder(customer1, PizzaType.BIG);
		orderService.createOrder(customer1, PizzaType.SMALL);
		orderService.createOrder(customer2, PizzaType.LARGE);
		orderService.createOrder(customer2, PizzaType.LARGE);
		orderService.cancelOrder(3l);
		orderService.deliverOrder(2l);
	}

}
