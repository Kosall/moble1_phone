package com.kosal.modernPhoneshop.mobile_phone.exception.newhandler;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Error2Response {
	private HttpStatus httpStatus;
	private String message;

}
