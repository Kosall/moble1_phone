package com.kosal.modernPhoneshop.mobile_phone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosal.modernPhoneshop.mobile_phone.DTO.ModelDTO;
import com.kosal.modernPhoneshop.mobile_phone.entities.Model;
import com.kosal.modernPhoneshop.mobile_phone.mapper.ModeEntityMapper;
import com.kosal.modernPhoneshop.mobile_phone.service.BrandService;
import com.kosal.modernPhoneshop.mobile_phone.service.ModelService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("models")
@RequiredArgsConstructor
public class ModelController {
	@Autowired
	private final ModelService modelService;
	

	@PostMapping
	public ResponseEntity<?> create(@RequestBody ModelDTO modelDTO) {
		Model model = ModeEntityMapper.CREATION.toModel(modelDTO);
		model = modelService.create(model);
		return ResponseEntity.ok(ModeEntityMapper.CREATION.toModelDTO(model));

	}

	@GetMapping("{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		Model model = modelService.getModelById(id);

		return ResponseEntity.ok(model);
	}

	@GetMapping("brands/{id}")
	public ResponseEntity<?> getModelByBrandId(@PathVariable Long id) {

		List<Model> list = modelService.getModelByBrandId(id);//.stream()
				//.map(mr -> ModeEntityMapper.CREATION.toModelDTO(mr)).toList();

		return ResponseEntity.ok(list);
	}
	@PutMapping("{id}")
	public ResponseEntity<?>update(@PathVariable Long id,@RequestBody ModelDTO modelDTO){
		Model model = modelService.getModelById(id);
		 model=ModeEntityMapper.CREATION.toModel(modelDTO);
		Model updateModel = modelService.updatebyid(id, model);
		
		return ResponseEntity.ok(ModeEntityMapper.CREATION.toModelDTO(updateModel));
		
			
	}
	

}
