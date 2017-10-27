package com.controller;

import java.util.Iterator;
import java.util.List;

public class TestExecutor {
	
	public static TestMethods testMethods;
	public static String url;
	public static RestResponse res;
	
	
	public TestExecutor(String url){
		this.url=url;
	}
	
	public void testGETMethod(List inputs) {
		testMethods=new TestMethods(url);
		Iterator ite=inputs.iterator();
		int noOfinputs=inputs.size();
		System.out.println("No of inputs::"+noOfinputs);
		while (ite.hasNext()) {
			String path = (String) ite.next();
			//System.out.println("--------------");
			//System.out.println(path.trim().isEmpty());
			if(path.equalsIgnoreCase("")||path.equalsIgnoreCase(null)||path.trim().isEmpty()){
				System.out.println("Invalid Input");	
			}else{
				res=testMethods.get(path.trim());
				System.out.println("response::::"+res.getEntireResponseBody());	
			}
			res=null;
		}
	}
	
	public void testPOSTMethod() {
		
		
	}
	public void testPUTMethod() {
		
		
	}
	
	public void testDELETEMethod() {
		
		
	}
}
