package com.constants.string;

public interface SearchBySpecificPropertyConstands {

	
	public static int cellno = 1;
	public static String TestData = "TestData",
			filepath=System.getProperty("user.dir")+"\\Bealls_Execution_Excel.xlsx";
	
	
	public static final String SEARCHBOX ="SimpleSearchForm_SearchTerm" ,SEARCHBUTTON="search-btn" ;
	
	
	//Find By Xpath
	public static final String WebIdFeildInPDP ="//p[@class='PDPwebID']",
			                   PDP_Rightsection="//div[@id='product-right']";
	
	
	
	public static int SearchByWebIdRow = 51,
						SearchBySKURow = 52;
}
