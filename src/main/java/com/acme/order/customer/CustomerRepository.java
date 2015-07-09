package com.acme.order.customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	public List<Customer> findByCustomerTypeName(@Param("name")String name);

	@Query(value = "select * from customer_t c inner join customer_type ct where c.type_id=ct.type_id and ct.name='INDIVIDUAL'", nativeQuery=true)
	public List<Customer> findIndividual();
}
