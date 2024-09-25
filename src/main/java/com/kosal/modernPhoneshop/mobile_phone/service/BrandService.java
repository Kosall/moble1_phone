package com.kosal.modernPhoneshop.mobile_phone.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.kosal.modernPhoneshop.mobile_phone.entities.Brand;
import com.kosal.modernPhoneshop.mobile_phone.entities.Model;

public interface BrandService {
	Brand create(Brand brand);
	Brand getById(Long id);
	Brand update(Long id,Brand uptodate);
	List<Brand>getBrands();
	void remove(Long id);
	List<Model>getModelByBrandId(Long id);
	//List<Brand>getBrands(String name);
	//List<Brand> getBrand(String name);
	//List<Brand>getBrands(Map<String, String> params);
	Page<Brand>getBrands(Map<String, String> params);


}
