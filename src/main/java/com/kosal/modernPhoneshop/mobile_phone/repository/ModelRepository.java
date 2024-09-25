package com.kosal.modernPhoneshop.mobile_phone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kosal.modernPhoneshop.mobile_phone.entities.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long>{
	List<Model>findByBrandId(Long id);
	
	

}
