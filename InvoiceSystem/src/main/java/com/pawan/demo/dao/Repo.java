package com.pawan.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.data.re
import com.pawan.demo.model.Customer;

//@RepositoryRestResource(collectionResourceRel="customer", path="/customer")
public interface Repo extends JpaRepository<Customer, Integer> {
	
	Customer findBycName(String name) ;
	//@Query("from Customer where name=?1 ")
	Boolean existsBycName(String name);
}
