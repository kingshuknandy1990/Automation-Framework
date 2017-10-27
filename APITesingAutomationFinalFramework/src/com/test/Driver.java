package com.test;

import java.util.ArrayList;
import java.util.List;

import org.testng.SkipException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.access.library.ExcelLibrary;
import com.controller.RestResponse;
import com.controller.TestExecutor;


public class Driver {
	public static ExcelLibrary exe=new ExcelLibrary(System.getProperty("user.dir")+"\\Inputs\\Control.xls");
	//public static String url;
	public static String sheetName="InputDataSets";
	public static TestExecutor testExecutor;
	public static RestResponse res;
	/*@BeforeClass
	public void initializeApplication(){
		 url=(String) exe.getCellData("InputDataSets", 1, 1);
		System.out.println("**********initializeApplication*****************"+url);
	}
	*/
	@DataProvider
	public Object[][] getInputData(){
		int NowOfCases=exe.getRowCount(sheetName);
		Object[][] data = new Object[NowOfCases-1][6];
		for(int i = 1;i<NowOfCases;i++){
			
			data[i-1][0] = exe.getCellData(sheetName, i, 0);  //Getting the index
			data[i-1][1] = exe.getCellData(sheetName, i, 1);  //Getting the Execution Status
			data[i-1][2] = exe.getCellData(sheetName, i, 2);  //Getting the Request Type
			data[i-1][3] = exe.getCellData(sheetName, i, 3);  //Getting the Rest Url
			
			List<String> listHeaders=new ArrayList<String>();
			for (int k = 4; k <8 ; k++) {
				listHeaders.add((String) exe.getCellData(sheetName, i, k));	//Getting the Headers
			}
			data[i-1][4]=listHeaders;
			List<String> listInputs=new ArrayList<String>();
			int colCount=exe.getColumnCount(sheetName, i);
			for (int j = 8; j < colCount; j++) {
				listInputs.add((String) exe.getCellData(sheetName, i, j));	//Getting the Inputs
			}
			data[i-1][5]=listInputs;
		}
		return data;
	}
	
	@BeforeTest()
	public void beforeTEST(){
		
	}
	
	@Test(dataProvider="getInputData")
	public void testMethod(String index,String exeStatus,String methodType,String url,List headers,List inputs ){

	    testExecutor=new TestExecutor(url);
	    if(!exeStatus.equalsIgnoreCase("yes")){
	    System.out.println(url +" has execution status no");
	    throw new SkipException(url +" has execution status no");
	    }else{
	    	    if(methodType.equalsIgnoreCase("get")){
	    		testExecutor.testGETMethod(inputs);			
	    		}else if (methodType.equalsIgnoreCase("post")) {
	    			
	    		}else if (methodType.equalsIgnoreCase("put")) {
	    			
	    		}else if (methodType.equalsIgnoreCase("delete")) {
	    			
	    		}
	    }
		
		testExecutor=null;
	}
	
/*	@AfterClass
	public void closeApplication(){
		System.out.println("**********closeApplication*****************");
	}*/
}
