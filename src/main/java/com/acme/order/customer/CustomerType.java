package com.acme.order.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "customer_type")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerType {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long type_id;

	@Column
	private String name;

}
