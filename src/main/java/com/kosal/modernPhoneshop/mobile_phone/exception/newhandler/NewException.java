package com.kosal.modernPhoneshop.mobile_phone.exception.newhandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NewException  {
	@ExceptionHandler(ApiExcept.class)
	public ResponseEntity<?> exceptionHandler(ApiExcept e){
		Error2Response error2Response=new Error2Response(e.getHttpStatus(), e.getMessage());
		return ResponseEntity.status(e.getHttpStatus()).body(error2Response);
	}

}
