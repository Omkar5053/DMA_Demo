package com.dma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dma.entities.CustomerResponseMaster;

public interface CustomerResponseRepository extends JpaRepository<CustomerResponseMaster, Integer>{

}
