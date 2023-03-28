package com.cms.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "cause", "stackTrace", "suppressed", "localizedMessage" })
public class InvalidInputException extends AppException {

	private static final long serialVersionUID = 1L;

	public InvalidInputException(String errorType, String errorCode, String message) {
		super(errorType, errorCode, message);
	}
}
