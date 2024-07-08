package com.kosal.modernPhoneshop.mobile_phone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.kosal.modernPhoneshop.mobile_phone.entities.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>,JpaSpecificationExecutor<Brand> {
	List<Brand> findByNameIgnoreCase(String name);

	List<Brand> findByNameLike(String name);

	List<Brand> findByNameContaining(String name);

}
