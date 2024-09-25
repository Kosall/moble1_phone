package com.kosal.modernPhoneshop.mobile_phone.service;

import java.util.List;

import com.kosal.modernPhoneshop.mobile_phone.entities.Model;

public interface ModelService {
	Model create(Model model);
	Model getModelById(Long id);
	List<Model>getModelByBrandId(Long id);
	Model updatebyid(Long id,Model forUpdate);
	

}
