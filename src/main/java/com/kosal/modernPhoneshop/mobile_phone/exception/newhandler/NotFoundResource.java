package com.kosal.modernPhoneshop.mobile_phone.exception.newhandler;

import org.springframework.http.HttpStatus;

public class NotFoundResource extends ApiExcept {

	public NotFoundResource(String httpStatus, Integer id) {
		super(HttpStatus.NOT_FOUND, String.format("%s with id= %d not found", httpStatus,id));
		// TODO Auto-generated constructor stub
	}

	

}
