package com.kosal.modernPhoneshop.mobile_phone.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.kosal.modernPhoneshop.mobile_phone.DTO.ModelDTO;
import com.kosal.modernPhoneshop.mobile_phone.entities.Model;

@Mapper
public interface ModeEntityMapper {
	ModeEntityMapper CREATION=Mappers.getMapper(ModeEntityMapper.class);
	@Mapping(target = "brand.id",source = "brandId")
	Model toModel(ModelDTO modelDTO);
	@Mapping(target = "brandId",source = "brand.id")
	ModelDTO toModelDTO(Model model);

}
