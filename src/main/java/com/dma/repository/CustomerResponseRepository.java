package com.dma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dma.entities.CustomerResponseMaster;

public interface CustomerResponseRepository extends JpaRepository<CustomerResponseMaster, Integer>{

	@Query(value = "SELECT * FROM customer_responsemaster c where c.section_id=:section_id", nativeQuery = true)
	public List<CustomerResponseMaster> findCustomerResponseMastersBySectionId(@Param("section_id") long section_id);
}
