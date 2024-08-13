package com.kosal.modernPhoneshop.mobile_phone.test.repository;

import static org.assertj.core.api.Assertions.as;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.kosal.modernPhoneshop.mobile_phone.entities.Brand;
import com.kosal.modernPhoneshop.mobile_phone.repository.BrandRepository;
@DataJpaTest
public class BrandRepositoryTest {
	@Autowired
	private BrandRepository brandRepository;
	//@Test
	public void testfindByNameLike() {
		//given 
		Brand brand=new Brand();
		brand.setName("Apple");
		brandRepository.save(brand);
		
		//when
		List<Brand> brands = brandRepository.findByNameLike("%A%");
		
		//then
		assertEquals(1, brands.size());
		assertEquals(brands.get(0).getName(), "Apple");
		assertEquals(1, brands.get(0).getId());
	}
	@Test
	public void testfindByNameContaining() {
		//given
			Brand brand =new Brand();
			brand.setName("Google-Xperia".toLowerCase());
			Brand brand2 =new Brand();
			brand2.setName("Apple".toLowerCase());
			
			brandRepository.save(brand);
			brandRepository.save(brand2);
		
		
		//when
			List<Brand> names = brandRepository.findByNameContaining("e");
		
		//then
			assertEquals(2, names.size());
			assertEquals(names.get(0).getName(), "Google-Xperia".toLowerCase());
			assertEquals(1, names.get(0).getId());
			assertEquals(names.get(1).getName(), "Apple".toLowerCase());
			assertEquals(2, names.get(1).getId());
	}

}
