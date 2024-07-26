package com.kosal.modernPhoneshop.mobile_phone.sum;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class sumNumberTest {
	@Test
	public void testSum() {
		//Given
		int a=9;int b=8;
		
		//When
		int total=SumNumber.sum(a, b);
		//Then
		assertEquals(total,17);
		
		
	}

}
