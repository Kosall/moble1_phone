package com.kosal.modernPhoneshop.mobile_phone.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kosal.modernPhoneshop.mobile_phone.DTO.BrandDTO;
import com.kosal.modernPhoneshop.mobile_phone.entities.Brand;
import com.kosal.modernPhoneshop.mobile_phone.mapper.BrandMapper;
import com.kosal.modernPhoneshop.mobile_phone.service.BrandService;

@RestController
@RequestMapping("brands")
public class BrandController {
	@Autowired
	private BrandService service;
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?>create(@RequestBody BrandDTO brandDTO){
		Brand brand=BrandMapper.INSTANCE.toBrand(brandDTO);
		brand=service.create(brand);
		
		return ResponseEntity.ok(brand);
	}
	@GetMapping("{id}")
	public ResponseEntity<?>getOneBrand(@PathVariable Integer id){
		Brand brand = service.getById(id);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
		
	}
	/*@GetMapping
	public ResponseEntity<?>getAllBrands(){
		   List<Brand> brands = service.getBrands();
		   List<BrandDTO> dto = brands.stream()
		   		.map(n->BrandMapper.INSTANCE.toBrandDTO(n))
		   		.collect(Collectors.toList());
		return ResponseEntity.ok(dto);
		
	}*/
	@PutMapping("{id}")
	public ResponseEntity<?>updateBrand(@PathVariable Integer id,@RequestBody BrandDTO dto){
		Brand brand = BrandMapper.INSTANCE.toBrand(dto);
		Brand update = service.update(id, brand);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(update));
		
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?>delete(@PathVariable Integer id){
			service.delete(id);
		return ResponseEntity.ok().build();
		
		
	}
	
	
	/*@GetMapping("filter")
	public ResponseEntity<?>getBrands(@RequestParam("name") String name){
				List<BrandDTO> collect = service.getBrands(name.toUpperCase())
				.stream()
				.map(brand->BrandMapper.INSTANCE.toBrandDTO(brand))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(collect);
		
	}*/
	@GetMapping
	public ResponseEntity<?>getBrands(@RequestParam Map<String, String>params){
		List<BrandDTO> collect = service.getBrands(params)
		.stream()
		.map(brand->BrandMapper.INSTANCE.toBrandDTO(brand))
		.collect(Collectors.toList());
		return ResponseEntity.ok(collect);

}

}
