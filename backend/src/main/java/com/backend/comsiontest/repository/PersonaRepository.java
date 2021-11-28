package com.backend.comsiontest.repository;


import com.backend.comsiontest.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PersonaRepository extends JpaRepository<Persona, Integer> {

	
	
	

	/*@Query(value="SELECT nextval('ecommercelogistic.order_id_seq')",nativeQuery = true)
	public Integer getNumberOrder();*/


}
