package com.kosal.modernPhoneshop.mobile_phone.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.kosal.modernPhoneshop.mobile_phone.DTO.ModelDTO;
import com.kosal.modernPhoneshop.mobile_phone.entities.Model;
import com.kosal.modernPhoneshop.mobile_phone.service.BrandService;

@Mapper(componentModel = "spring",uses= {BrandService.class})
public interface ModeEntityMapper {
	ModeEntityMapper CREATION=Mappers.getMapper(ModeEntityMapper.class);
	@Mapping(target = "brand",source = "brandId")
	Model toModel(ModelDTO modelDTO);
	
	//
	
	@Mapping(target = "brandId",source = "model.id") 
	ModelDTO toModelDTO(Model model);
	 

}
