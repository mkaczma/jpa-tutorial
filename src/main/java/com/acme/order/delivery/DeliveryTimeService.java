package com.acme.order.delivery;

import java.util.Date;

import com.acme.order.customer.Customer;
import com.acme.order.pizza.PizzaType;

public interface DeliveryTimeService {

	Date getTime(Customer customer, PizzaType type);

}
