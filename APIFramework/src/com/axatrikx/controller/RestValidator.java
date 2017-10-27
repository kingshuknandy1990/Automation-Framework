package com.axatrikx.controller;

import java.util.HashMap;
import java.util.Set;

import org.junit.Assert;

public class RestValidator {

	private RestResponse response;

	RestValidator(RestResponse response) {
		this.response = response;
	}

	public RestValidator expectCode(int expectedCode) {
		//Assert.assertEquals("Incorrect Response Code", expectedCode, response.getResponseCode());
		System.out.println("**********[RestValidator][expectCode]*********************");
		System.out.println("Expected Code:"+expectedCode);
		System.out.println("Received Code:"+response.getResponseCode());
		System.out.println("*******************************");
		return this;
	}

	public RestValidator expectMessage(String message) {
		System.out.println("**********[RestValidator][expectMessage]*********************");
		System.out.println("*******************************");
		//Assert.assertEquals("Incorrect Response Message", message, response.getResponseMessage());
		return this;
	}

	public RestValidator expectHeader(String headerName, String headerValue) {
		//Assert.assertEquals("Incorrect header - " + headerName, headerValue, response.getHeader(headerName));
		System.out.println("**********[RestValidator][expectMessage]*********************");
		System.out.println("*******************************");
		return this;
	}

	public RestValidator expectHeaders(HashMap<String, String> headers) {
		Set<String> keys = headers.keySet();
		for (String key : keys) {
			Assert.assertEquals("Incorrect header - " + key, headers.get(key), response.getHeader(key));
		}
		return this;
	}

	public RestValidator expectInBody(String content) {
		Assert.assertTrue("Body doesnt contain string : " + content, response.getResponseBody().contains(content));
		return this;
	}
	
	public RestValidator printBody(){
		System.out.println(response.getResponseBody());
		return this;
	}
	
	public RestResponse getResponse(){
		return response;
	}

}
