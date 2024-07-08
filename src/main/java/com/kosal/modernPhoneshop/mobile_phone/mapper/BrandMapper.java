package com.kosal.modernPhoneshop.mobile_phone.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kosal.modernPhoneshop.mobile_phone.DTO.BrandDTO;
import com.kosal.modernPhoneshop.mobile_phone.entities.Brand;

@Mapper
public interface BrandMapper {
	BrandMapper INSTANCE=Mappers.getMapper(BrandMapper.class);
	Brand toBrand(BrandDTO dto);
	BrandDTO toBrandDTO(Brand brand);
}
