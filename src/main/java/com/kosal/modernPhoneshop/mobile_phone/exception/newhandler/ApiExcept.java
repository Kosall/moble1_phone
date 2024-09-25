package com.kosal.modernPhoneshop.mobile_phone.exception.newhandler;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data
@RequiredArgsConstructor
public class ApiExcept extends RuntimeException {
	private final HttpStatus httpStatus;
	private final String message;

}
