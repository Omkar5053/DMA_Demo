package com.dma.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_master")
public class CustomerMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customer_id;
	
	@Column(name = "customer_name")
	private String customer_name;
	@Column(name="email",unique = true)
	private String email;
	@Column(name="phone")
	private String phone;
	@Column(name="company")
	private String company;
}
