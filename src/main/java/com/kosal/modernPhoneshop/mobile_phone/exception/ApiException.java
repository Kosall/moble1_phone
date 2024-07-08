package com.kosal.modernPhoneshop.mobile_phone.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class ApiException extends RuntimeException{
	private final HttpStatus status;
	private final String message;

}
