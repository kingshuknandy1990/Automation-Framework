package com.bealls.pojo;

import java.util.ArrayList;
import java.util.List;

import com.excellibrary.bealls.ExcelLibrary;

public class Sheet {
	
	 
 public static  List<ArrayList<String>> testCases = new ArrayList<ArrayList<String>>();	
	
	public  static void setTestCases()
	{
	   
	
		
	   ExcelLibrary excel = new ExcelLibrary(System.getProperty("user.dir") + "\\Bealls_Execution_Excel.xlsx");
	
		int rowCount = excel.getRowCount("Scenarios");
		 ArrayList <String> paths=null;
		for(int rowCounter =0;rowCounter<rowCount;rowCounter++)
		{
	 
			int colCount = excel.getColumnCount("Scenarios", rowCounter);
			 paths= new ArrayList<String>();
		for (int dataCounter = 0; dataCounter < colCount; dataCounter++) {
			String keyWord = (String)excel.getCellData("Scenarios", rowCounter, dataCounter);
			if(!keyWord.isEmpty())
			{
				paths.add(keyWord);
		 
			}
			 
		}
		if(paths!=null && paths.size()>0)
		{
	 testCases.add(paths);
		}
	   
		 
		}
	 
		
		
	}
	
	public static List<ArrayList<String>> getPaths()
	{
		return Sheet.testCases;
	}
 

}
