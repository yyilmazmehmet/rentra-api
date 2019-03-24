package com.yilmazmehmet.rentraapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestControllerExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(NoSuchEntityFoundException exc) {

		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage());

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

}