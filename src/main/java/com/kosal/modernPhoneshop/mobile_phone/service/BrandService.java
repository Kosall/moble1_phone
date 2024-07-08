package com.kosal.modernPhoneshop.mobile_phone.service;

import java.util.List;
import java.util.Map;

import com.kosal.modernPhoneshop.mobile_phone.entities.Brand;

public interface BrandService {
	Brand create(Brand brand);
	Brand getById(Integer id);
	Brand update(Integer id,Brand uptodate);
	//List<Brand>getBrands();
	void delete(Integer id);
	//List<Brand>getBrands(String name);
	//List<Brand> getBrand(String name);
	List<Brand>getBrands(Map<String, String> params);

}
