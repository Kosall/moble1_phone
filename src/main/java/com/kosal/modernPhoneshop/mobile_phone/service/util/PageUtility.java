package com.kosal.modernPhoneshop.mobile_phone.service.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface PageUtility {
	int DEFAULT_PAGE_NUMBER=2;
	int DEFAULT_PAGE_LIMIT=1;
	String PAGE_LIMIT="_limit";
	String PAGE_NUMBER="_page";
	static Pageable getPageable(int pageNumber,int pageSize) {
		if(pageNumber<DEFAULT_PAGE_NUMBER) {
			pageNumber=DEFAULT_PAGE_NUMBER;
		}
		if(pageSize<1) {
			pageSize=DEFAULT_PAGE_LIMIT;
		}
		Pageable pageable = PageRequest.of(pageNumber-1, pageSize);
		
		return pageable;
	}
	

}
