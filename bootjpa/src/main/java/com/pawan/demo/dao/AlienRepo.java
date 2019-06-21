package com.pawan.demo.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pawan.demo.model.Alien;
// TO SAVE DATA INTO DATABASE
public interface AlienRepo extends JpaRepository<Alien, Integer> {

	//Naminig convention should be followed
	List<Alien> findByTech(String ntech);
	List<Alien> findByAidGreaterThan(int aid);
	
	@Query("from Alien where tech=?1 order by aname") //WE ARE WORKING WITH JPA THEREFORE THE QUERY SHOULD BE WRITEEN IN JPQL similar to sql
	List<Alien> findByTechSorted(String tech);
	
}
