package com.kosal.modernPhoneshop.mobile_phone.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.kosal.modernPhoneshop.mobile_phone.utils.GeneralUtils;

public class GeneralUtilsTest {
	@Test
	public void testConversion() {
		//Given 
		List<String>names=List.of("Socheata","Leakhina","Bopha","Sina");
		
		
		//When
		
		List<Integer>list=GeneralUtils.conversion(names);
		
		//Then
		assertEquals(4,list.size());
		assertEquals(8,list.get(0));
		assertEquals(8,list.get(1));
		assertEquals(5,list.get(2));
		assertEquals(4,list.get(3));
	}

}
