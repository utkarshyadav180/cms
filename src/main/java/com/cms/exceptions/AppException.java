package com.cms.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "cause", "stackTrace", "suppressed", "localizedMessage" })
public class AppException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AppException(String errorType, String errorCode, String message) {
		super(message);
	}

	public AppException(String message) {
		super(message);
	}

}
