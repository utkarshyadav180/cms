package com.cms.response;

public class BaseApiResponse {

	private ResponseStatus responseStatus;
	private Object responseData;
	private String message;

	public BaseApiResponse(Object responseData) {

		this.responseData = responseData;
	}

	public BaseApiResponse() {

		this.responseData = null;
	}

	public BaseApiResponse(boolean error, ResponseStatus responseStatus, Object responseData, String message) {
		super();

		this.responseStatus = responseStatus;
		this.responseData = responseData;
		this.message = message;
	}

	public ResponseStatus getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(ResponseStatus responseStatus) {
		this.responseStatus = responseStatus;
	}

	public Object getResponseData() {
		return responseData;
	}

	public void setResponseData(Object responseData) {
		this.responseData = responseData;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setStatusCode(int success) {
		// TODO Auto-generated method stub

	}

}
