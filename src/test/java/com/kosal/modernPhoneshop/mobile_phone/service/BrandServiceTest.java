package com.kosal.modernPhoneshop.mobile_phone.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.http.HttpStatus;

import com.kosal.modernPhoneshop.mobile_phone.entities.Brand;
import com.kosal.modernPhoneshop.mobile_phone.exception.ResourceNotFoundException;
import com.kosal.modernPhoneshop.mobile_phone.repository.BrandRepository;
import com.kosal.modernPhoneshop.mobile_phone.service.impl.BrandServiceImpl;
@ExtendWith(MockitoExtension.class)
public class BrandServiceTest {
	@Mock
	private BrandRepository brandRepository;
	
	private BrandService service;
	@BeforeEach
	void setUp() {
		//service=new BrandServiceImpl(brandRepository);
		
	}
	/*@Test
	 void createTest() {
		//given
		Brand brand=new Brand();
		brand.setName("Apple");
		brand.setId(1);
		//when
		when(brandRepository.save(any(Brand.class))).thenReturn(brand);
		Brand create = service.create(new Brand());
		
		
		//then
		assertEquals(1, create.getId());
		
	}*/
	@Test
	void createTest() {
		//given
		Brand brand=new Brand();
		brand.setName("Apple");
		//when
		service.create(brand);
		//then
		verify(brandRepository,times(1)).save(brand);
		assertEquals("Apple", brand.getName());
		
		
	}
	@Test
	void getByIdTest() {
		//given
		Brand brand=new Brand();
		brand.setName("Apple");
		brand.setId(1l);
			
		
		//when
		
		when(brandRepository.findById(1l)).thenReturn(Optional.of(brand));
		Brand create = service.getById(1l);
		
		//then
		assertEquals(1, create.getId());
		assertEquals("Apple", create.getName());
	
	}
	@Test
	void getByIdTestFailure() {
		//given 
		
		//when 
		when(brandRepository.findById(2l)).thenReturn(Optional.empty());
		//Brand brand = service.getById(2);
		assertThatThrownBy(()->service.getById(2l)).isInstanceOf(ResourceNotFoundException.class)
		.hasMessage(String.format("%s with id :%d not found","Brand",2));
		
		//then
	}
}
