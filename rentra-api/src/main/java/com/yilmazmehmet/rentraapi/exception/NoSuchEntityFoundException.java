package com.yilmazmehmet.rentraapi.exception;

@SuppressWarnings("serial")
public class NoSuchEntityFoundException extends RuntimeException {

	public NoSuchEntityFoundException(String message) {
		super(message);
	}

}