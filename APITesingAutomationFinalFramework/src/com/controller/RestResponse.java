package com.controller;

import java.util.HashMap;

public class RestResponse {
	private HashMap<String, String> headers;
	
	private int responseCode;
	private String responsePhrase;
	private String entireResponseBody;

	public RestResponse() {
		headers = new HashMap<String, String>();
	}
	
	public HashMap<String, String> getHeaders() {
		return headers;
	}
	@Override
	public String toString() {
		return "RestResponse [headers=" + headers + ", responseCode="
				+ responseCode + ", responsePhrase=" + responsePhrase
				+ ", entireResponseBody=" + entireResponseBody + "]";
	}

	public void setHeaders(String headerKey, String value) {
		this.headers.put(headerKey, value);
	}
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponsePhrase() {
		return responsePhrase;
	}
	public void setResponsePhrase(String responsePhrase) {
		this.responsePhrase = responsePhrase;
	}
	public String getEntireResponseBody() {
		return entireResponseBody;
	}
	public void setEntireResponseBody(String entireResponseBody) {
		this.entireResponseBody = entireResponseBody;
	}

}
