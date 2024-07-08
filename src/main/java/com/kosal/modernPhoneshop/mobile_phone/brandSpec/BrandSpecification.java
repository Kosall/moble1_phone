package com.kosal.modernPhoneshop.mobile_phone.brandSpec;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.kosal.modernPhoneshop.mobile_phone.entities.Brand;

import lombok.Data;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Data
public class BrandSpecification implements Specification<Brand>{
		private final BrandFilter brandFilter;
		List<Predicate>predicates=new ArrayList<>();

	@Override
	public Predicate toPredicate(Root<Brand> brand, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(brandFilter.getName()!=null) {
			Predicate name = cb.like(brand.get("name"),"%" + brandFilter.getName()+"%");
			predicates.add(name);
			
		}
		/*if(brandFilter.getName()!=null) {
			Predicate name = brand.get("name").in(brandFilter.getName());
			predicates.add(name);
		}*/
		if(brandFilter.getId()!=null) {
			Predicate id = brand.get("id").in(brandFilter.getId());
			predicates.add(id);
		}
		
		return cb.and(predicates.toArray(Predicate[]::new));
	}

}
