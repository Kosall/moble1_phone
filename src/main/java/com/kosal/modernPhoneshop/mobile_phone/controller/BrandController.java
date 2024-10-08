package com.kosal.modernPhoneshop.mobile_phone.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import com.kosal.modernPhoneshop.mobile_phone.entities.Model;
import com.kosal.modernPhoneshop.mobile_phone.mapper.BrandMapper;
import com.kosal.modernPhoneshop.mobile_phone.mapper.ModeEntityMapper;
import com.kosal.modernPhoneshop.mobile_phone.page.DTO.PageDTO;
import com.kosal.modernPhoneshop.mobile_phone.service.BrandService;
import com.kosal.modernPhoneshop.mobile_phone.service.ModelService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("brands")
@RequiredArgsConstructor
public class BrandController {
	//@Autowired
	private final BrandService service;
	//@Autowired
	private final ModelService modelService;
	private final ModeEntityMapper entityMapper;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO) {
		Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
		brand = service.create(brand);

		return ResponseEntity.ok(brand);
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getOneBrand(@PathVariable Long id) {
		Brand brand = service.getById(id);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));

	}

	/*
	 * @GetMapping public ResponseEntity<?>getAllBrands(){ List<Brand> brands =
	 * service.getBrands(); List<BrandDTO> dto = brands.stream()
	 * .map(n->BrandMapper.INSTANCE.toBrandDTO(n)) .collect(Collectors.toList());
	 * return ResponseEntity.ok(dto);
	 * 
	 * }
	 */
	@PutMapping("{id}")
	public ResponseEntity<?> updateBrand(@PathVariable Long id, @RequestBody BrandDTO dto) {
		Brand brand = BrandMapper.INSTANCE.toBrand(dto);
		Brand update = service.update(id, brand);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(update));

	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.remove(id);
		return ResponseEntity.ok().build();

	}

	/*
	 * @GetMapping("filter") public ResponseEntity<?>getBrands(@RequestParam("name")
	 * String name){ List<BrandDTO> collect = service.getBrands(name.toUpperCase())
	 * .stream() .map(brand->BrandMapper.INSTANCE.toBrandDTO(brand))
	 * .collect(Collectors.toList());
	 * 
	 * return ResponseEntity.ok(collect);
	 * 
	 * }
	 */

	@GetMapping
	public ResponseEntity<?> getBrands(@RequestParam Map<String, String> params) {

		Page<Brand> brands = service.getBrands(params);
		PageDTO dto = new PageDTO(brands);

		return ResponseEntity.ok(dto);

	}

	/*
	 * @GetMapping public ResponseEntity<?> getAll() { List<Brand> brands =
	 * service.getBrands(); // .stream().map(br ->
	 * BrandMapper.INSTANCE.toBrandDTO(br)).toList(); // List<Brand>brands=new
	 * ArrayList<>(); // Brand brand = new Brand(); // for(BrandDTO dto:list) { //
	 * brand = BrandMapper.INSTANCE.toBrand(dto); // brands.add(brand); // } //
	 * return ResponseEntity.ok(brands); }
	*/
	@GetMapping("{id}/models")
	public ResponseEntity<?>getByBrandId(@PathVariable("id") Long id){
		List<Model> models = modelService.getModelByBrandId(id);
		models.stream().map(entityMapper::toModelDTO).toList();
		return ResponseEntity.ok(models);
		
	}

}
