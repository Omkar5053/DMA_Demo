package com.dma.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.dma.entities.CustomerMaster;

public interface CustomerMasterRepository extends JpaRepository<CustomerMaster, Long> {

	public CustomerMaster findCustomerMasterByEmail(String email);
}
