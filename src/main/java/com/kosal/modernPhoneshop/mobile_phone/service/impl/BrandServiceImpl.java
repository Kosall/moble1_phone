package com.kosal.modernPhoneshop.mobile_phone.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.kosal.modernPhoneshop.mobile_phone.brandSpec.BrandFilter;
import com.kosal.modernPhoneshop.mobile_phone.brandSpec.BrandSpecification;
import com.kosal.modernPhoneshop.mobile_phone.entities.Brand;
import com.kosal.modernPhoneshop.mobile_phone.exception.ApiException;
import com.kosal.modernPhoneshop.mobile_phone.exception.ResourceNotFoundException;
import com.kosal.modernPhoneshop.mobile_phone.repository.BrandRepository;
import com.kosal.modernPhoneshop.mobile_phone.service.BrandService;
import com.kosal.modernPhoneshop.mobile_phone.service.util.PageUtility;

import net.bytebuddy.implementation.bytecode.Throw;
@Service
public class BrandServiceImpl implements BrandService{
	@Autowired
	private BrandRepository brandRepository;

	@Override
	public Brand create(Brand brand) {
		// TODO Auto-generated method stub
		return brandRepository.save(brand);
	}

	@Override
	public Brand getById(Integer id) {
		/*Optional<Brand> optional = brandRepository.findById(id);*/
		/*if(optional.isPresent()) {
			return optional.get();
			
		}
		
			//throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"Brand with id= "+id+"Not found!!");
		//throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"Brand with id=%dNot found!!".formatted(id));
		*/
		return brandRepository.findById(id)
				//.orElseThrow(()->new HttpClientErrorException(HttpStatus.NOT_FOUND,"Brand with id=%d Not found!!".formatted(id)));
				.orElseThrow(()->new ResourceNotFoundException("Brand", id));
	}

	@Override
	public Brand update(Integer id, Brand uptodate) {
		Brand brand = getById(id);
		brand.setName(uptodate.getName());//to Improve
   		return brandRepository.save(brand);
	}

	@Override
	public void delete(Integer id) {
		Brand brand = getById(id);
		if(brand!=null) {
			brandRepository.delete(brand);
		}
		
		
	}

	/*@Override
	public List<Brand> getBrands(Map<String, String> params) {
		BrandFilter filter =new BrandFilter();
		if(params.containsKey("name")) {
			String name = params.get("name");
			filter.setName(name);
		}
		if(params.containsKey("id")) {
			String id=params.get("id");
			filter.setId(Integer.parseInt(id));
		}
		int pageLimit=1;
		if(params.containsKey(PageUtility.PAGE_LIMIT)) {
			pageLimit=Integer.parseInt(params.get(PageUtility.PAGE_LIMIT));
			
		}
		int pageNumber=1;
		if(params.containsKey(PageUtility.PAGE_NUMBER)) {
			pageNumber=Integer.parseInt(params.get(PageUtility.PAGE_NUMBER));
			
		}
		BrandSpecification specification =new BrandSpecification(filter);
		Pageable pageable=PageUtility.getPageable(pageNumber, pageLimit);
		return brandRepository.findAll(specification);
	}*/
	@Override
	public Page<Brand> getBrands(Map<String, String> params) {
		BrandFilter filter =new BrandFilter();
		if(params.containsKey("name")) {
			String name = params.get("name");
			filter.setName(name);
		}
		if(params.containsKey("id")) {
			String id=params.get("id");
			filter.setId(Integer.parseInt(id));
		}
		int pageLimit=1;
		if(params.containsKey(PageUtility.PAGE_LIMIT)) {
			pageLimit=Integer.parseInt(params.get(PageUtility.PAGE_LIMIT));
			
		}
		int pageNumber=1;
		if(params.containsKey(PageUtility.PAGE_NUMBER)) {
			pageNumber=Integer.parseInt(params.get(PageUtility.PAGE_NUMBER));
			
		}
		BrandSpecification specification =new BrandSpecification(filter);
		Pageable pageable=PageUtility.getPageable(pageNumber, pageLimit);
		 Page<Brand> findAll = brandRepository.findAll(pageable);
		 return findAll;
	}


	/*@Override
	public List<Brand> getBrands() {
		// TODO Auto-generated method stub
		return brandRepository.findAll();
	}

	@Override
	public List<Brand> getBrands(String name) {
		// TODO Auto-generated method stub
		return brandRepository.findByNameContaining(name);
	}

	@Override
	public List<Brand> getBrand(String name) {
		// TODO Auto-generated method stub
		 return brandRepository.findByNameIgnoreCase("%" +name.toLowerCase() +"%");
	}
	*/

}
