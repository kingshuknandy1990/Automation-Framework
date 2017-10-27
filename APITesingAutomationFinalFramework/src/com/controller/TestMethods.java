package com.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;



public class TestMethods {

	
	private HttpClient client;
	private String url;

	/**
	 * Constructor for RestExecutor
	 * @param url
	 */
	public TestMethods(String url) {
		client = HttpClientBuilder.create().build();
		this.url = url;
	}

	public RestResponse get(String path) {
		return get(path, null);
	}

	/**
	 * Executes GET req and returns response json.
	 * 
	 * @param path
	 * @param headers
	 * @return
	 */
	public RestResponse get(String path, HashMap<String, String> headers) {
		HttpGet request = new HttpGet(url + path);
		HttpResponse response;
		RestResponse resResponse=new RestResponse();
		try {
			/* Setting the headers for the request
			 */
			if (headers != null) {
				Set<String> keys = headers.keySet();
				for (String key : keys) {
					request.addHeader(key, headers.get(key));
				}
			}
			/*Executing the GET operation
			 */
			response = client.execute(request);
			
			/* Obtaining the response body from the response stream.
			 */
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			
			/* Storing the response  in response stream.
			 */
			StringBuffer responseString = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				responseString.append(line);
			}
			
			/* Setting values for the response object
			 */
			
			resResponse.setResponseCode(response.getStatusLine().getStatusCode());
			resResponse.setResponsePhrase(response.getStatusLine().getReasonPhrase());
			resResponse.setEntireResponseBody(responseString.toString());
			/*resResponse.setResponseCode(response.getStatusLine().getStatusCode());
			resResponse.setResponseMessage(response.getStatusLine().getReasonPhrase());*/
			Header[] rheaders = response.getAllHeaders();
			for (Header header : rheaders) {
				
				resResponse.setHeaders(header.getName(), header.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * Returns the RestValidator object providing the response object
		 */
		return resResponse;
	}
	/*public void testGETmethod(){
		
	}
	
	public void testPOSTmethod(){
		
	}*/
}
