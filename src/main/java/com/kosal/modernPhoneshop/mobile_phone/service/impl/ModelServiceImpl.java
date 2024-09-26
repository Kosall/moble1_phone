package com.kosal.modernPhoneshop.mobile_phone.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosal.modernPhoneshop.mobile_phone.entities.Brand;
import com.kosal.modernPhoneshop.mobile_phone.entities.Model;
import com.kosal.modernPhoneshop.mobile_phone.exception.ResourceNotFoundException;
import com.kosal.modernPhoneshop.mobile_phone.repository.BrandRepository;
import com.kosal.modernPhoneshop.mobile_phone.repository.ModelRepository;
import com.kosal.modernPhoneshop.mobile_phone.service.BrandService;
import com.kosal.modernPhoneshop.mobile_phone.service.ModelService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {
	@Autowired
	private final ModelRepository modelRepository;
	@Autowired
	private final BrandService brandService;
	@Autowired
	private final BrandRepository brandRepository;
	
	

	@Override
	public Model create(Model model) {
		// TODO Auto-generated method stub
		
		/*
		 * Long brandId = model.getBrand().getId(); brandService.getById(brandId);
		 */
		 
		return modelRepository.save(model);
	}

	@Override
	public Model getModelById(Long id) {
		// TODO Auto-generated method stub
		return modelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Model", id));
	}

	@Override
	public List<Model> getModelByBrandId(Long id) {
		brandService.getById(id);
		 List<Model> list = modelRepository.findByBrandId(id);

		return list;
	}

	@Override
	public Model updatebyid(Long id, Model forUpdate) {
		// TODO Auto-generated method stub
		 Model model = modelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Model", id));
		
		Long lon = model.getBrand().getId();
		Brand brand = brandRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Brand", lon));
		model.setName(forUpdate.getName());
		model.setBrand(brand);
		return model;
	}

	
}
