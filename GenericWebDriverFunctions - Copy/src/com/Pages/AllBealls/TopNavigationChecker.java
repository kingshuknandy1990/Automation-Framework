package com.Pages.AllBealls;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GenericFunctions.WebDriver.GenericFunctionsExtra;
import com.GenericFunctions.WebDriver.GenericWebDriverFunctions;
import com.bealls.pojo.L1Pojo;
import com.bealls.pojo.L2Pojo;
import com.constants.string.SearchBySpecificPropertyConstands;
import com.constants.string.StringConstants;
import com.constants.string.TopNavigationConstands;
import com.excellibrary.bealls.ExcelLibrary;
import com.reports.beallsCustom.CustomReporter;

public class TopNavigationChecker {

	

	public static WebElement submenu=null;
	public static WebElement subl3menu=null;
	public static WebDriverWait wait= null;
	public static int StartCouterNo=1;
	public static int StartCouterNoForL2=1;
	public static int EndCouterNoForL2=1;
	public static String[] tokens;
	public static String URL;
	public static boolean status=false;
	public static int ProperTotal;
	public static int ImproperTotal;
	public static int UnableTotal;
	public static int AllTotal;
	
	
	//public static L2Pojo cat;
	//public static WebElement elementMother=null;
	public static String elementMotherTxt=null;
	@FindBy(className=StringConstants.POPUP)
	public static List<WebElement> popUplist;
	
	@FindBy(className=StringConstants.POPUP)
	public static WebElement popUp;
	
	@FindBy(xpath=TopNavigationConstands.TopNavigationLinks)
	public static List <WebElement> TopNavigationLinks;
	
	@FindBy(xpath=TopNavigationConstands.Brand)
	public static List <WebElement> Brand;
	
	@FindBy(xpath=TopNavigationConstands.Categories)
	public static List <WebElement> Categories;

	@FindBy(xpath=TopNavigationConstands.Espots)
	public static List <WebElement> Espots;
	
	@FindBy(xpath=TopNavigationConstands.L2NavigationLinks)
	public static List <WebElement> L2NavigationLinks;
	
	  @FindBy(className=TopNavigationConstands.ItemsBlock)
	  public static List <WebElement>  ItemsBlock;
	  
		@FindBy(xpath=TopNavigationConstands.L2NavigationLandingPageVerification)
		public static List <WebElement> L2NavLandingPageVerification;
		
		@FindBy(xpath=TopNavigationConstands.L2NavigationLandingPageVerification)
		public static WebElement L2NavPageVeri;
	
	public TopNavigationChecker(){
		PageFactory.initElements(GenericWebDriverFunctions.driver,this);
	}
	
	public static void L1NavigationlinkValidation() throws InterruptedException{
		CustomReporter.startChild("Top Navigation Check", "");
        try {
        	StringBuffer Proper=new StringBuffer();
    		StringBuffer ImProper=new StringBuffer();

    		for (int counter = 1; counter <=TopNavigationLinks.size(); counter++) {
    			WebElement element=GenericWebDriverFunctions.findElementsBy("(//a[@class='main-nav-link'])["+counter+"]");
    			String str = element.getText();
    			String[] tokens = GenericFunctionsExtra.Split(str);
    			
    	    	GenericWebDriverFunctions.performAction(StringConstants.MOUSEOVER, element, "");
    	    	Thread.sleep(3000);
    	    	GenericWebDriverFunctions.performAction(StringConstants.CLICK, element, "");
    	    	
    	    	if(GenericFunctionsExtra.ElementVisibility(popUplist)){
    	    		System.out.println("Popup is Present");
    	    		GenericWebDriverFunctions.performAction(StringConstants.CLICK, popUp, "");
    	    	}
    	    	
    	    	
    	    	/*if(GenericWebDriverFunctions.driver.findElements(By.className(StringConstants.POPUP)).size() != 0){
    	    		System.out.println("Popup is Present");
    	    		GenericWebDriverFunctions.driver.findElement(By.className(StringConstants.POPUP)).click();
    	    		}*/
    	    	
    	    	WebElement Expected = null;
    	    	boolean status=false;
    			for (int i = 0; i < tokens.length; i++) {
    				System.out.println("\\:" + tokens[i]);
    			    Expected=GenericWebDriverFunctions.findElementsBy("//h1[contains(text(),'" + tokens[i] + "')]");
    				
    				if (Expected.isDisplayed()) {
    					//status=true;
    					if(Expected.getText().equalsIgnoreCase("Markdowns")){
    						if(GenericFunctionsExtra.ElementVisibility(Espots)){
        						status=true;
        						GenericFunctionsExtra.Concatenation(Proper, str+",");
            				}else{
            					GenericFunctionsExtra.Concatenation(ImProper, str+",");
            				}
    					}else{
    						if(GenericFunctionsExtra.ElementVisibility(Categories) && GenericFunctionsExtra.ElementVisibility(Brand)  && GenericFunctionsExtra.ElementVisibility(Espots) ){
        						status=true;
        						GenericFunctionsExtra.Concatenation(Proper, str+",");
            				}else{
            					GenericFunctionsExtra.Concatenation(ImProper, str+",");
            				}
    					}
    					
    					//GenericFunctionsExtra.Concatenation(Proper, str+",");
    					break;
    				}else{
    					
    					GenericFunctionsExtra.Concatenation(ImProper, str+",");
    				}
    			}
    			
    			if(status){
    				System.out.println("It has landed to respective catagory");	
    				
    			}else{
    				System.out.println("It has not landed to respective catagory");
    			}
    		}
    		System.out.println("1:::"+Proper);
    		System.out.println("2:::"+ImProper);
    		CustomReporter.addChildInfo("The following Top Level Navigation has Landed to respective Landing Pages and displaying left navigation (category and brand) and landing page Espots::  "+Proper);
    		CustomReporter.addChildInfo("The following Top Level Navigation have not Landed to respective catagory::  "+ImProper);
    		CustomReporter.reportChild("pass", "Top-Level Navigation Has been verified");
		} catch (Exception e) {
			CustomReporter.reportChild("fail", "Error:Unable to verify Top-Level Navigation."+e);
		}
		
		CustomReporter.endChildTest();
	}
	
	
	
	public static void L2NavLinkValidation() throws InterruptedException{

		wait = new WebDriverWait(GenericWebDriverFunctions.driver, 15);
		ExcelLibrary exe=new ExcelLibrary(TopNavigationConstands.filepath);
		for (int counterMain = 1; counterMain <=TopNavigationLinks.size(); counterMain++) {
			String actualMenu=null;
		WebElement element11=GenericWebDriverFunctions.findElementsBy("(//a[@class='main-nav-link'])["+counterMain+"]");
		
		//starting Child report for Every top Level Navigation
		CustomReporter.startChild("L2 Navigation Check '"+element11.getText()+"' Catagory", "");
		StringBuffer ProperL2=new StringBuffer();
		StringBuffer ImProperL2=new StringBuffer();
		int L2CatagoryCoutercount=0;
		String ExceptionCatagoryBrandname=null;
		
		WebElement element=GenericWebDriverFunctions.findElementsBy("(//a[@class='main-nav-link'])["+counterMain+"]");
		GenericWebDriverFunctions.performAction(StringConstants.MOUSEOVER, element, "");
		Thread.sleep(3000);
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, element, "");
		
		List<WebElement> L2Navigator=GenericWebDriverFunctions.driver.findElements(By.xpath("//div[@class='left-nav']//a[@class='link-list-link']"));
		System.out.println("Counter Size::"+L2Navigator.size());
		int coutersize=L2Navigator.size()+1;
		CustomReporter.addChildInfo("The following L2 Level Navigation Landed ---'"+element11.getText()+"'--- has :  "+coutersize+"   Catagories & Brands");
		Double  StartCouterno11= (Double) exe.getCellData(TopNavigationConstands.TestData, TopNavigationConstands.StartCouterno, TopNavigationConstands.cellno);
		int StartCouterno=StartCouterno11.intValue();
		CustomReporter.addChildInfo("Starting from :  "+StartCouterno);
		for (int counter =StartCouterno; counter < coutersize; counter++) {

			L2CatagoryCoutercount=counter;
			System.out.println("Counter Value::  "+counter);
		   submenu=null;
		   submenu=GenericWebDriverFunctions.findElementsBy("(//div[@class='left-nav']//a[@class='link-list-link'])["+counter+"]");
		   
		   //Handling of viewMore
		   if(!submenu.isDisplayed()){
		    	List li=GenericWebDriverFunctions.driver.findElements(By.xpath("//a[contains(text(),'View More')]"));
		    	if(li.size()>0){
		    		for (int i = 1; i <=li.size(); i++) {
					WebElement ele=GenericWebDriverFunctions.findElementsBy("(//a[contains(text(),'View More')])["+i+"]");
					GenericWebDriverFunctions.performAction(StringConstants.CLICK, ele, "");
					}
		    		
		    	}
		    }
		   
		    GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, submenu, "");
			String str[]=GenericWebDriverFunctions.getText.split("\\(");
			actualMenu=str[0].trim();
		    System.out.println("///////::"+actualMenu);
		    ExceptionCatagoryBrandname=actualMenu;
		    
		    
		    GenericWebDriverFunctions.performAction(StringConstants.CLICK, submenu, "");
		    GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, GenericWebDriverFunctions.findElementsBy("//h1"), "");
		    if(GenericWebDriverFunctions.getText.equalsIgnoreCase(actualMenu)){
		    	
		    	try {
		    		if(TopNavigationChecker.NoOfItemsDisplayed()>0){
		    			System.out.println("Landed Page::"+GenericWebDriverFunctions.getText);
				    	System.out.println("You have landed to respective catagory");
				    	GenericFunctionsExtra.Concatenation(ProperL2, GenericWebDriverFunctions.getText+",");
		    		}else if (L2NavigationLinks.size()>0) {
		    			System.out.println("Landed Page::"+GenericWebDriverFunctions.getText);
				    	System.out.println("You have landed to respective catagory");
				    	GenericFunctionsExtra.Concatenation(ProperL2, GenericWebDriverFunctions.getText+",");
		    		}
				} catch (Exception e) {
					// TODO: handle exception
				}
		    	
	/*		    	System.out.println("Landed Page::"+GenericWebDriverFunctions.getText);
		    	System.out.println("You have landed to respective catagory");
		    	GenericFunctionsExtra.Concatenation(ProperL2, GenericWebDriverFunctions.getText+",");*/
		    }else{
		    	    WebElement element12=GenericWebDriverFunctions.driver.findElement(By.xpath("//div[@class='dropdowns-additional']"));
		    	   	//GenericWebDriverFunctions.performAction(StringConstants.GETTITLE, GenericWebDriverFunctions.findElementsBy("//div[@class='dropdowns-additional']"), "");
		    	    element12=wait.until(ExpectedConditions.visibilityOf(element12));
		    	    String title=element12.getAttribute("title");
		    	   	System.out.println("Landed Page::"+title);
		    	   	if(title.equalsIgnoreCase(actualMenu)){
		    	   		if(TopNavigationChecker.NoOfItemsDisplayed()>0){
		    	   			System.out.println("You have landed to respective catagory");
			    	   		GenericFunctionsExtra.Concatenation(ProperL2, title+",");
			    		}
		    	   		/*
		    	   		System.out.println("You have landed to respective catagory");
		    	   		GenericFunctionsExtra.Concatenation(ProperL2, title+",");*/
		    	   	}else{
		    	   		//System.out.println("Landed Page::"+GenericWebDriverFunctions.getTitle);
		    	   		System.out.println("Error: You have landed to wrong catagory");
		    	   		GenericFunctionsExtra.Concatenation(ImProperL2, actualMenu+",");
		    	   	}
		    }
		    GenericWebDriverFunctions.driver.navigate().back();
		    //Thread.sleep(500);
	    	if(GenericWebDriverFunctions.driver.findElements(By.className(StringConstants.POPUP)).size() != 0){
	    		System.out.println("Popup is Present");
	    		GenericWebDriverFunctions.driver.findElement(By.className(StringConstants.POPUP)).click();
	    		}
		
			
		}
		
		
		//Stopping Child report for Every top Level Navigation
		CustomReporter.endChildTest();
		}

	}
	
public static void L1NavagationAllCheck() throws InterruptedException{
	ExcelLibrary exe=new ExcelLibrary(TopNavigationConstands.filepath);
	int L1CatagoryIndex=1;
	String L1catagoryNameIP=(String) exe.getCellData(TopNavigationConstands.TestData, TopNavigationConstands.L1catagoryNameRow, TopNavigationConstands.cellno);
	Double  StartCouterno11= (Double) exe.getCellData(TopNavigationConstands.TestData, TopNavigationConstands.StartCouterno, TopNavigationConstands.cellno);
	StartCouterNo=StartCouterno11.intValue();
	
	if(L1catagoryNameIP.equalsIgnoreCase("for home")){
		L1CatagoryIndex=1;
	}else if (L1catagoryNameIP.equalsIgnoreCase("bed & bath")) {
		L1CatagoryIndex=2;
	}else if (L1catagoryNameIP.equalsIgnoreCase("women")) {
		L1CatagoryIndex=3;
	}else if (L1catagoryNameIP.equalsIgnoreCase("plus size")) {
		L1CatagoryIndex=4;
	}else if (L1catagoryNameIP.equalsIgnoreCase("lingerie")) {
		L1CatagoryIndex=5;
	}else if (L1catagoryNameIP.equalsIgnoreCase("men")) {
		L1CatagoryIndex=6;
	}else if (L1catagoryNameIP.equalsIgnoreCase("juniors")) {
		L1CatagoryIndex=7;
	}else if (L1catagoryNameIP.equalsIgnoreCase("kids")) {
		L1CatagoryIndex=8;
	}else if (L1catagoryNameIP.equalsIgnoreCase("shoes & sandals")) {
		L1CatagoryIndex=9;
	}else if (L1catagoryNameIP.equalsIgnoreCase("accessories")) {
		L1CatagoryIndex=10;
	}else if (L1catagoryNameIP.equalsIgnoreCase("markdowns")) {
		L1CatagoryIndex=11;
	}
	
	for (int i = L1CatagoryIndex; i <=11; i++) {	
		L1NavigationlinkValidationCheckGeneric(i);
		StartCouterNo=1;
	}
}

public static void L1NavagationSpecificCheck() throws InterruptedException{
	ExcelLibrary exe=new ExcelLibrary(TopNavigationConstands.filepath);
	int L1CatagoryIndex=1;
	int CatagorycolCount = exe.getColumnCount("TestData", 53);
	for (int dataCounter = 1; dataCounter <=CatagorycolCount; dataCounter++) {
	
		String L1catagoryNameIP=(String) exe.getCellData(TopNavigationConstands.TestData, TopNavigationConstands.L1catagorySpecificNameRow,dataCounter);
		Double  StartCouterno11= (Double) exe.getCellData(TopNavigationConstands.TestData, TopNavigationConstands.StartSpecificCouterno, dataCounter);
		StartCouterNo=StartCouterno11.intValue();
		if(L1catagoryNameIP.equalsIgnoreCase("for home")){
			L1CatagoryIndex=1;
		}else if (L1catagoryNameIP.equalsIgnoreCase("bed & bath")) {
			L1CatagoryIndex=2;
		}else if (L1catagoryNameIP.equalsIgnoreCase("women")) {
			L1CatagoryIndex=3;
		}else if (L1catagoryNameIP.equalsIgnoreCase("plus size")) {
			L1CatagoryIndex=4;
		}else if (L1catagoryNameIP.equalsIgnoreCase("lingerie")) {
			L1CatagoryIndex=5;
		}else if (L1catagoryNameIP.equalsIgnoreCase("men")) {
			L1CatagoryIndex=6;
		}else if (L1catagoryNameIP.equalsIgnoreCase("juniors")) {
			L1CatagoryIndex=7;
		}else if (L1catagoryNameIP.equalsIgnoreCase("kids")) {
			L1CatagoryIndex=8;
		}else if (L1catagoryNameIP.equalsIgnoreCase("shoes & sandals")) {
			L1CatagoryIndex=9;
		}else if (L1catagoryNameIP.equalsIgnoreCase("accessories")) {
			L1CatagoryIndex=10;
		}else if (L1catagoryNameIP.equalsIgnoreCase("markdowns")) {
			L1CatagoryIndex=11;
		}
		L1NavigationlinkValidationCheckGeneric(L1CatagoryIndex);
	}
		
}

	
public static void L1NavigationlinkValidationCheckGeneric(int index) throws InterruptedException{
		
	    
		wait = new WebDriverWait(GenericWebDriverFunctions.driver, 15);
		ExcelLibrary exe=new ExcelLibrary(TopNavigationConstands.filepath);
		String  L1catagoryName=null;
		boolean status=false;
		//String  L1catagoryName=(String) exe.getCellData(TopNavigationConstands.TestData, TopNavigationConstands.L1catagoryNameRow, TopNavigationConstands.cellno);
		//CustomReporter.startChild("L2 Navigation Check '"+L1catagoryName+"' Catagory", "");
		StringBuffer ProperL2=new StringBuffer();
		StringBuffer ImProperL2=new StringBuffer();
		int L2CatagoryCoutercount=0;
		String ExceptionCatagoryBrandname=null;
		
		try{

		String actualMenu=null;
		
    	
		WebElement elementName=GenericWebDriverFunctions.findElementsBy("(//a[@class='main-nav-link'])["+index+"]");
		L1catagoryName=elementName.getText();
		CustomReporter.startChild("L1 Navigation Check '"+elementName.getText()+"' Catagory", "");
    	GenericWebDriverFunctions.performAction(StringConstants.MOUSEOVER, elementName, "");
		Thread.sleep(3000);
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, elementName, "");
		
		List<WebElement> L2Navigator=GenericWebDriverFunctions.driver.findElements(By.xpath("//div[@class='left-nav']//a[@class='link-list-link']"));
		System.out.println("Counter Size::"+L2Navigator.size());
		int coutersize=L2Navigator.size()+1;
		CustomReporter.addChildInfo("The following L1 Level Navigation Landed ---'"+L1catagoryName+"'--- has :  "+coutersize+"   Catagories & Brands");
		//Double  StartCouterno11= (Double) exe.getCellData(TopNavigationConstands.TestData, TopNavigationConstands.StartCouterno, TopNavigationConstands.cellno);
		//int StartCouterno=StartCouterno11.intValue();
		CustomReporter.addChildInfo("Starting from :  "+StartCouterNo);
		for (int counter =StartCouterNo; counter < coutersize; counter++) {
			L2CatagoryCoutercount=counter;
			System.out.println("Counter Value::  "+counter);
		   submenu=null;
		   submenu=GenericWebDriverFunctions.findElementsBy("(//div[@class='left-nav']//a[@class='link-list-link'])["+counter+"]");
		   
		   //Handling of viewMore
		   if(!submenu.isDisplayed()){
		    	List li=GenericWebDriverFunctions.driver.findElements(By.xpath("//a[contains(text(),'View More')]"));
		    	if(li.size()>0){
		    		for (int i = 1; i <=li.size(); i++) {
					WebElement ele=GenericWebDriverFunctions.findElementsBy("(//a[contains(text(),'View More')])["+i+"]");
					GenericWebDriverFunctions.performAction(StringConstants.CLICK, ele, "");
					}
		    		
		    	}
		    }
		   
		    GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, submenu, "");
			String str[]=GenericWebDriverFunctions.getText.split("\\(");
			actualMenu=str[0].trim();
		    System.out.println("///////::"+actualMenu);
		    ExceptionCatagoryBrandname=actualMenu;
		    
		    
		    GenericWebDriverFunctions.performAction(StringConstants.CLICK, submenu, "");
		    GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, GenericWebDriverFunctions.findElementsBy("//h1"), "");
		    if(GenericWebDriverFunctions.getText.equalsIgnoreCase(actualMenu)){
		    	
		    	try {
		    		if(TopNavigationChecker.NoOfItemsDisplayed()>0){
		    			System.out.println("Landed Page::"+GenericWebDriverFunctions.getText);
				    	System.out.println("You have landed to respective catagory");
				    	GenericFunctionsExtra.Concatenation(ProperL2, GenericWebDriverFunctions.getText+" ,  ");
		    		}else if (L2NavigationLinks.size()>0) {
		    			System.out.println("Landed Page::"+GenericWebDriverFunctions.getText);
				    	System.out.println("You have landed to respective catagory");
				    	GenericFunctionsExtra.Concatenation(ProperL2, GenericWebDriverFunctions.getText+" ,  ");
		    		}
				} catch (Exception e) {
					// TODO: handle exception
				}
		    	
/*		    	System.out.println("Landed Page::"+GenericWebDriverFunctions.getText);
		    	System.out.println("You have landed to respective catagory");
		    	GenericFunctionsExtra.Concatenation(ProperL2, GenericWebDriverFunctions.getText+",");*/
		    }else{
		    	    WebElement element11=GenericWebDriverFunctions.driver.findElement(By.xpath("//div[@class='dropdowns-additional']"));
		    	   	//GenericWebDriverFunctions.performAction(StringConstants.GETTITLE, GenericWebDriverFunctions.findElementsBy("//div[@class='dropdowns-additional']"), "");
		    	    element11=wait.until(ExpectedConditions.visibilityOf(element11));
		    	    String title=element11.getAttribute("title");
		    	   	System.out.println("Landed Page::"+title);
		    	   	if(title.equalsIgnoreCase(actualMenu)){
		    	   		if(TopNavigationChecker.NoOfItemsDisplayed()>0){
		    	   			System.out.println("You have landed to respective catagory");
			    	   		GenericFunctionsExtra.Concatenation(ProperL2, title+" ,  ");
			    		}
		    	   		/*
		    	   		System.out.println("You have landed to respective catagory");
		    	   		GenericFunctionsExtra.Concatenation(ProperL2, title+",");*/
		    	   	}else{
		    	   		//System.out.println("Landed Page::"+GenericWebDriverFunctions.getTitle);
		    	   		System.out.println("Error: You have landed to wrong catagory");
		    	   		GenericFunctionsExtra.Concatenation(ImProperL2, actualMenu+" ,  ");
		    	   	}
		    }
		    GenericWebDriverFunctions.driver.navigate().back();
		    //Thread.sleep(500);
	    	if(GenericWebDriverFunctions.driver.findElements(By.className(StringConstants.POPUP)).size() != 0){
	    		System.out.println("Popup is Present");
	    		GenericWebDriverFunctions.driver.findElement(By.className(StringConstants.POPUP)).click();
	    		}
	    	
	    	if(counter==(coutersize-1)){
	    		status=true;
	    	}
		}
		
		System.out.println("1::: "+ProperL2);
		System.out.println("2::: "+ImProperL2);
		CustomReporter.addChildInfo("The following  L1  Level Navigation Landed  ---'"+L1catagoryName+"'---  has landed to respective pages::  ---"+ProperL2);
		CustomReporter.addChildInfo("The following  L1  Level Navigation Landed ---'"+L1catagoryName+"'--- has not landed to respective pages:: ---"+ImProperL2);
		if(status){
			CustomReporter.addChildInfo("Traversed all "+L2Navigator.size()+"  L1 Catagories" );
			CustomReporter.addChildInfo("Successfully traversed all  L1  Level Navigation of "+L1catagoryName );	
		}
		
		if(ProperL2.length()==0){
			CustomReporter.reportChild("fail", "Error:Unable to verify  L1 Level Navigation of "+L1catagoryName+"Catagory.  ");
		}
		
		} catch (Exception e) {
			
			CustomReporter.addChildInfo("The following  L1  Level Navigation Landed ---'"+L1catagoryName+"'--- has landed to respective pages::  ---"+ProperL2);
			CustomReporter.addChildInfo("The following  L1  Level Navigation Landed ---'"+L1catagoryName+"'--- has not landed to respective pages:: ---"+ImProperL2);
			CustomReporter.addChildInfo("Exception occured while executing Counter No : ----"+L2CatagoryCoutercount+"----. In Catagory or Brand name  ---"+ExceptionCatagoryBrandname);
			CustomReporter.reportChild("fail", "Error:Unable to verify L1-Level Navigation of "+L1catagoryName+"Catagory.  "+e);
			CustomReporter.addChildInfo("Traversed Till "+L2CatagoryCoutercount+"  L1 Catagories" );
			CustomReporter.addChildInfo("Un-Successfully .Did not traversed all  L1  Level Navigation of  "+L1catagoryName );
		
		}
		
		CustomReporter.endChildTest();
		


	}


public static void L2NavCheck(){

	   
    


	for (int counter = 1; counter <=TopNavigationLinks.size(); counter++) {
    	StringBuffer Proper=new StringBuffer();
		StringBuffer ImProper=new StringBuffer();
		StringBuffer UnableProper=new StringBuffer();
		WebElement elementMother=GenericWebDriverFunctions.findElementsBy("(//a[@class='main-nav-link'])["+counter+"]");
		elementMotherTxt=elementMother.getText();
		CustomReporter.startChild("L2 Navigation Check for ---   "+elementMotherTxt+"   ------- Catagory", "");
		try {
		
		

		
		
    	GenericWebDriverFunctions.performAction(StringConstants.MOUSEOVER, elementMother, "");
    	Thread.sleep(500);
    	
    	int sizee=GenericWebDriverFunctions.driver.findElements(By.xpath("//nav//div//div//div//span//li")).size();
    	List<WebElement> li=GenericWebDriverFunctions.driver.findElements(By.xpath("//nav//div//div//div//span//li"));
    	System.out.println("size::"+sizee);
    	for (int i =1; i <45; i++) {
    		L2Pojo cat=new L2Pojo() ;
    		if(!li.get(i).getText().equalsIgnoreCase("") && !li.get(i).getText().equalsIgnoreCase(" ")){
			System.out.println("Actual Menu::"+li.get(i).getText());
			String actualMenu=li.get(i).getText();
  			//String str = element.getText();
			 tokens = GenericFunctionsExtra.Split(actualMenu);
			 try {
					List<WebElement> uu=GenericWebDriverFunctions.driver.findElements(By.xpath("//nav//div//div//div//span//li//a"));
					 URL=uu.get(i).getAttribute("href");
					 System.out.println("URL:"+URL);
			} catch (Exception e) {
				System.out.println("URL:"+URL);
			}

			li.get(i).click();
			if(GenericWebDriverFunctions.driver.findElements(By.className(StringConstants.POPUP)).size() != 0){
	    		System.out.println("Popup is Present");
	    		GenericWebDriverFunctions.driver.findElement(By.className(StringConstants.POPUP)).click();
	    		}
/*			
			cat.setCouterNo(i);
			cat.setCatagoryName(actualMenu);
			cat.setLink(URL);
			cat.toStringUnableToVerify();
			//GenericFunctionsExtra.Concatenation(UnableProper, actualMenu+" :: "+URL+"   ,   "); 
			GenericFunctionsExtra.Concatenation(UnableProper, cat.toStringUnableToVerify()); */
			//Code Starts here-------------------
			
			if(!actualMenu.equalsIgnoreCase("Home Décor")){
				 GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, GenericWebDriverFunctions.findElementsBy("//h1"), "");
				 System.out.println(GenericWebDriverFunctions.getText);
				 WebElement Expected = null;
	    	    	//boolean status=false;
				 for (int z = 0; z <tokens.length; z++) {
					// Expected=GenericWebDriverFunctions.findElementsBy("//h1[contains(text(),'" + tokens[j] + "')]");
					 status=GenericWebDriverFunctions.getText.contains(tokens[z]);
					// System.out.println("///////////////"+z);
				
				 }
				 tokens=null;
				 
				 
				 GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, GenericWebDriverFunctions.findElementsBy("//h1"), "");
				 if(status){
					 if(TopNavigationChecker.NoOfItemsDisplayed()>0){
			    			System.out.println("Landed Page::"+GenericWebDriverFunctions.getText);
					    	System.out.println("You have landed to respective SRP Page");
					    	GenericFunctionsExtra.Concatenation(Proper, GenericWebDriverFunctions.getText+"  ,  ");
			    		}else if (L2NavigationLinks.size()>0) {
			    			System.out.println("Landed Page::"+GenericWebDriverFunctions.getText);
					    	System.out.println("You have landed to respective Next-Level catagory");
					    	GenericFunctionsExtra.Concatenation(Proper, GenericWebDriverFunctions.getText+"  ,  ");
			    		}

			    	 System.out.println("******11*******");
				 }else if (GenericFunctionsExtra.ElementVisibility(L2NavLandingPageVerification)) {
					 WebElement element11=GenericWebDriverFunctions.driver.findElement(By.xpath("//div[@class='dropdowns-additional']"));
			    	    String title=element11.getAttribute("title");
			    	   	System.out.println("Landed Page Brand Name::"+title);
			    	   	if(title.equalsIgnoreCase(actualMenu)){
			    	   		if(TopNavigationChecker.NoOfItemsDisplayed()>0){
			    	   			System.out.println("You have landed to respective  catagory SRP-Page");
				    	   		GenericFunctionsExtra.Concatenation(Proper, title+"  ,  ");
				    		}

			    	   	}else{
			    	   		System.out.println("Error: You have landed to proper page.But it Does not contains items");
			    	   		GenericFunctionsExtra.Concatenation(ImProper, actualMenu+"  ,  ");
			    	   	}
			    	    System.out.println("*****22********");
				}else{
					System.out.println("Unable to verify:"+actualMenu);
					cat.setCouterNo(i);
					cat.setCatagoryName(actualMenu);
					cat.setLink(URL);
					cat.toStringUnableToVerify();
					//GenericFunctionsExtra.Concatenation(UnableProper, actualMenu+" :: "+URL+"   ,   "); 
					GenericFunctionsExtra.Concatenation(UnableProper, cat.toStringUnableToVerify()); 
					//cat=null;
					System.out.println("UnableProper String Buffer   :" +UnableProper);
					System.out.println("******33*******");
				}
					
			}else {
				System.out.println("Unable to verify:"+actualMenu);
				
				cat.setCouterNo(i);
				cat.setCatagoryName(actualMenu);
				cat.setLink(URL);
				cat.toStringUnableToVerify();
				//GenericFunctionsExtra.Concatenation(UnableProper, actualMenu+" :: "+URL+"   ,   "); 
				GenericFunctionsExtra.Concatenation(UnableProper, cat.toStringUnableToVerify()); 
				//cat=null;
				System.out.println("UnableProper String Buffer   :" +UnableProper);
				System.out.println("******44*******");
				Thread.sleep(1000);
			}
		   
			//Code Ends here-------------------
			//GenericWebDriverFunctions.driver.navigate().back();
			Thread.sleep(1500);
			if(GenericWebDriverFunctions.driver.findElements(By.className(StringConstants.POPUP)).size() != 0){
	    		System.out.println("Popup is Present");
	    		GenericWebDriverFunctions.driver.findElement(By.className(StringConstants.POPUP)).click();
	    		}
			elementMother=GenericWebDriverFunctions.findElementsBy("(//a[@class='main-nav-link'])["+counter+"]");
			GenericWebDriverFunctions.performAction(StringConstants.MOUSEOVER, elementMother, "");
	    	Thread.sleep(500);
	    	sizee=GenericWebDriverFunctions.driver.findElements(By.xpath("//nav//div//div//div//span//li")).size();
	    	li=GenericWebDriverFunctions.driver.findElements(By.xpath("//nav//div//div//div//span//li"));
			
    		}
    		status=false;
    		if(Proper.length()==0){
    			CustomReporter.reportChild("fail", "Error:Unable to verify  L2 Level Navigation of "+elementMotherTxt+"Catagory.  ");
    		}
	}
    	CustomReporter.addChildInfo("The following L2 Level Navigation Landed  ---'"+elementMotherTxt+"'---  has landed to respective pages::  ---"+Proper);
		CustomReporter.addChildInfo("The following L2 Level Navigation Landed ---'"+elementMotherTxt+"'--- has not landed to respective pages:: ---"+ImProper);
		CustomReporter.addChildInfo("Unable tp verify ----- Please Check Manually:: ---"+UnableProper);
    	
} catch (Exception e) {
	CustomReporter.reportChild("fail", "Error:Unable to verify L2-Level Navigation."+e);
	CustomReporter.addChildInfo("The following L2 Level Navigation Landed  ---'"+elementMotherTxt+"'---  has landed to respective pages::  ---"+Proper);
	CustomReporter.addChildInfo("The following L2 Level Navigation Landed ---'"+elementMotherTxt+"'--- has not landed to respective pages:: ---"+ImProper);
	CustomReporter.addChildInfo("Unable tp verify ----- Please Check Manually:: ---"+UnableProper);
	
	
}
		CustomReporter.endChildTest();
}


}
public static  int NoOfItemsDisplayed(){
	int size=ItemsBlock.size();
    return size;
	
}

public static String menuactual=null;
public static List<L2Pojo> list=new ArrayList<L2Pojo>();
public static List<L1Pojo> listforL1=new ArrayList<L1Pojo>();

public static void L2NavagationAllCheck() throws InterruptedException{
	ExcelLibrary exe=new ExcelLibrary(TopNavigationConstands.filepath);
	int L2CatagoryIndex=1;
	ProperTotal=0;
	ImproperTotal=0;
	UnableTotal=0;
	AllTotal=0;
	String L2catagoryNameIP=(String) exe.getCellData(TopNavigationConstands.TestData, TopNavigationConstands.L2catagoryNameRow, TopNavigationConstands.cellno);
	//Double  StartCouterno22= (Double) exe.getCellData(TopNavigationConstands.TestData, TopNavigationConstands.StartCouterno, TopNavigationConstands.cellno);
	//StartCouterNo=StartCouterno22.intValue();
	
	if(L2catagoryNameIP.equalsIgnoreCase("for home")){
		L2CatagoryIndex=1;
	}else if (L2catagoryNameIP.equalsIgnoreCase("bed & bath")) {
		L2CatagoryIndex=2;
	}else if (L2catagoryNameIP.equalsIgnoreCase("women")) {
		L2CatagoryIndex=3;
	}else if (L2catagoryNameIP.equalsIgnoreCase("plus size")) {
		L2CatagoryIndex=4;
	}else if (L2catagoryNameIP.equalsIgnoreCase("lingerie")) {
		L2CatagoryIndex=5;
	}else if (L2catagoryNameIP.equalsIgnoreCase("men")) {
		L2CatagoryIndex=6;
	}else if (L2catagoryNameIP.equalsIgnoreCase("juniors")) {
		L2CatagoryIndex=7;
	}else if (L2catagoryNameIP.equalsIgnoreCase("kids")) {
		L2CatagoryIndex=8;
	}else if (L2catagoryNameIP.equalsIgnoreCase("shoes & sandals")) {
		L2CatagoryIndex=9;
	}else if (L2catagoryNameIP.equalsIgnoreCase("accessories")) {
		L2CatagoryIndex=10;
	}else if (L2catagoryNameIP.equalsIgnoreCase("markdowns")) {
		L2CatagoryIndex=11;
	}
	
	for (int i = L2CatagoryIndex; i <=11; i++) {	
		L2NavigationChecker(i,-1,-1);
		//StartCouterNo=1;
	}
}


public static void L2NavagationSpecificCheck() throws InterruptedException{
	ExcelLibrary exe=new ExcelLibrary(TopNavigationConstands.filepath);
	int L2CatagoryIndex=1;
	int StartCouterNoForL2_11=0;
	int EndCouterNoForL2_11=0;
	ProperTotal=0;
	ImproperTotal=0;
	UnableTotal=0;
	AllTotal=0;
	
	int CatagorycolCount = exe.getColumnCount("TestData", 65);
	for (int dataCounter = 1; dataCounter <CatagorycolCount; dataCounter++) {
		try {
			String  StartCouternospecificString= (String) exe.getCellData(TopNavigationConstands.TestData, TopNavigationConstands.StartCouternoL2Specific, dataCounter);
			if(StartCouternospecificString.isEmpty()){
				StartCouterNoForL2_11=-1;
			}	
		
		} catch (Exception e) {
			Double  StartCouternospecific= (Double) exe.getCellData(TopNavigationConstands.TestData, TopNavigationConstands.StartCouternoL2Specific, dataCounter);
			StartCouterNoForL2_11=StartCouternospecific.intValue();
		}
		
		try {
			String  EndCouternospecificString = (String) exe.getCellData(TopNavigationConstands.TestData, TopNavigationConstands.EndCouternoL2Specific, dataCounter);
			if (EndCouternospecificString.isEmpty()) {
				EndCouterNoForL2_11=-1;
			}
		} catch (Exception e) {
			Double  EndCouternospecific= (Double) exe.getCellData(TopNavigationConstands.TestData, TopNavigationConstands.EndCouternoL2Specific, dataCounter);
			EndCouterNoForL2_11=EndCouternospecific.intValue();
		}
		
		
		String L2catagoryNameIP11=(String) exe.getCellData(TopNavigationConstands.TestData, TopNavigationConstands.L2catagoryNameRowSpecific, dataCounter);
		/*String  StartCouternospecificString= (String) exe.getCellData(TopNavigationConstands.TestData, TopNavigationConstands.StartCouternoL2Specific, dataCounter);
		
		String  EndCouternospecificString = (String) exe.getCellData(TopNavigationConstands.TestData, TopNavigationConstands.EndCouternoL2Specific, dataCounter);
		if(StartCouternospecificString.isEmpty()){
			StartCouterNoForL2_11=-1;
		}else{
			Double  StartCouternospecific= (Double) exe.getCellData(TopNavigationConstands.TestData, TopNavigationConstands.StartCouternoL2Specific, dataCounter);
			StartCouterNoForL2_11=StartCouternospecific.intValue();
		}
		
		if (EndCouternospecificString.isEmpty()) {
			EndCouterNoForL2_11=-1;
		} else {
			Double  EndCouternospecific= (Double) exe.getCellData(TopNavigationConstands.TestData, TopNavigationConstands.EndCouternoL2Specific, dataCounter);
			EndCouterNoForL2_11=EndCouternospecific.intValue();
		}*/
		/*Double  StartCouternospecific= (Double) exe.getCellData(TopNavigationConstands.TestData, TopNavigationConstands.StartCouternoL2Specific, dataCounter);
		StartCouterNoForL2_11=StartCouternospecific.intValue();
		
		Double  EndCouternospecific= (Double) exe.getCellData(TopNavigationConstands.TestData, TopNavigationConstands.EndCouternoL2Specific, dataCounter);
		EndCouterNoForL2_11=EndCouternospecific.intValue();*/
		
		if(L2catagoryNameIP11.equalsIgnoreCase("for home")){
			L2CatagoryIndex=1;
		}else if (L2catagoryNameIP11.equalsIgnoreCase("bed & bath")) {
			L2CatagoryIndex=2;
		}else if (L2catagoryNameIP11.equalsIgnoreCase("women")) {
			L2CatagoryIndex=3;
		}else if (L2catagoryNameIP11.equalsIgnoreCase("plus size")) {
			L2CatagoryIndex=4;
		}else if (L2catagoryNameIP11.equalsIgnoreCase("lingerie")) {
			L2CatagoryIndex=5;
		}else if (L2catagoryNameIP11.equalsIgnoreCase("men")) {
			L2CatagoryIndex=6;
		}else if (L2catagoryNameIP11.equalsIgnoreCase("juniors")) {
			L2CatagoryIndex=7;
		}else if (L2catagoryNameIP11.equalsIgnoreCase("kids")) {
			L2CatagoryIndex=8;
		}else if (L2catagoryNameIP11.equalsIgnoreCase("shoes & sandals")) {
			L2CatagoryIndex=9;
		}else if (L2catagoryNameIP11.equalsIgnoreCase("accessories")) {
			L2CatagoryIndex=10;
		}else if (L2catagoryNameIP11.equalsIgnoreCase("markdowns")) {
			L2CatagoryIndex=11;
		}
		
		L2NavigationChecker(L2CatagoryIndex,StartCouterNoForL2_11,EndCouterNoForL2_11);
		
	}
	
	
		
}


public static void L2NavigationChecker(int counter,int startCounter,int EndCounter){
	System.out.println("************************"+counter+"**********"+startCounter+"******"+ EndCounter);
	//int counter=3;
	WebElement elementMother=GenericWebDriverFunctions.findElementsBy("(//a[@class='main-nav-link'])["+counter+"]");
	elementMotherTxt=elementMother.getText();
	StringBuffer Checker=new StringBuffer();
	
	StringBuffer Proper=new StringBuffer();
	StringBuffer ImProper=new StringBuffer();
	StringBuffer UnableProper=new StringBuffer();

	
	CustomReporter.startChild("L2 Navigation Check for ---   "+elementMotherTxt+"   ------- Catagory", "");
	try {
		GenericWebDriverFunctions.performAction(StringConstants.MOUSEOVER, elementMother, "");
    	Thread.sleep(1000);
    	//int sizee=GenericWebDriverFunctions.driver.findElements(By.xpath("//nav//div//div//div//span//li")).size();
    	//List<WebElement> li=GenericWebDriverFunctions.driver.findElements(By.xpath("//nav//div//div//div//span//li"));
    	List<WebElement> uu=GenericWebDriverFunctions.driver.findElements(By.xpath("//nav//div//div//div//span//li//a"));
    	int start=0;
    	int end=uu.size();
    	//System.out.println("size::"+sizee);
    	if(startCounter==-1 && EndCounter==-1){
    		start=0;
        	end=uu.size();
    	}else if(startCounter==-1 && EndCounter!=-1){
    		start=0;
    		end=EndCounter+1;
    	}else if(startCounter!=-1 && EndCounter==-1){
    		start=startCounter;
    		end=uu.size();
    	}else{
    		start=startCounter;
        	end=EndCounter+1;
    	}
    	//for (int i = 0; i <uu.size(); i++) {
    	for (int i = start; i <end; i++) {
    		
			 URL=uu.get(i).getAttribute("href");
			 menuactual=uu.get(i).getText();
    		 L2Pojo cat=new L2Pojo() ;
    		if(!menuactual.isEmpty()){
    		cat.setCouterNo(i);
			cat.setCatagoryName(menuactual);
			cat.setLink(URL);
			list.add(cat);
			//cat.toStringUnableToVerify();
			//GenericFunctionsExtra.Concatenation(Checker, cat.toStringUnableToVerify());
    		}
		}
    	System.out.println("Total size of"+elementMotherTxt+"Catagory is  ::"+list.size());
    	AllTotal=AllTotal+list.size();
    	
    	CustomReporter.addChildInfo("Total size of"+elementMotherTxt+"Catagory is  ::"+list.size());
    	//----------------------------------For Loop Starts Here---------------------
    	
    	for (int j = 0; j < list.size(); j++) {
			GenericWebDriverFunctions.driver.get(list.get(j).getLink());
    		System.out.println("=="+list.get(j).getCatagoryName());
			//-------------------Code starts Here
			

			try {
				
				if(!list.get(j).getCatagoryName().equalsIgnoreCase("Home Décor")){
					 GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, GenericWebDriverFunctions.findElementsBy("//h1"), "");
					// System.out.println(GenericWebDriverFunctions.getText);
					 WebElement Expected = null;
					 tokens = GenericFunctionsExtra.Split(list.get(j).getCatagoryName());
					 for (int z = 0; z <tokens.length; z++) {
						status=GenericWebDriverFunctions.getText.contains(tokens[z]);
					 }
					 tokens=null;
					 
					 
					 GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, GenericWebDriverFunctions.findElementsBy("//h1"), "");
					 if(status){
						 if(TopNavigationChecker.NoOfItemsDisplayed()>0){
				    			System.out.println("Landed Page::"+GenericWebDriverFunctions.getText);
						    	System.out.println("You have landed to respective SRP Page");
						    	//GenericFunctionsExtra.Concatenation(Proper, GenericWebDriverFunctions.getText+"  ,  ");
						    	GenericFunctionsExtra.Concatenation(Proper, list.get(j).toStringUnableToVerify());
						    	ProperTotal=ProperTotal+1;
				    		}else if (L2NavigationLinks.size()>0) {
				    			System.out.println("Landed Page::"+GenericWebDriverFunctions.getText);
						    	System.out.println("You have landed to respective Next-Level catagory");
						    	GenericFunctionsExtra.Concatenation(Proper, list.get(j).toStringUnableToVerify());
						    	ProperTotal=ProperTotal+1;
				    		}

				    	 System.out.println("******11*******");
					 }else if (GenericFunctionsExtra.ElementVisibility(L2NavLandingPageVerification)) {
						 WebElement element11=GenericWebDriverFunctions.driver.findElement(By.xpath("//div[@class='dropdowns-additional']"));
				    	    String title=element11.getAttribute("title");
				    	   	System.out.println("Landed Page Brand Name::"+title);
				    	   	if(title.equalsIgnoreCase(list.get(j).getCatagoryName())){
				    	   		if(TopNavigationChecker.NoOfItemsDisplayed()>0){
				    	   			System.out.println("You have landed to respective  catagory SRP-Page");
					    	   		GenericFunctionsExtra.Concatenation(Proper,list.get(j).toStringUnableToVerify());
					    	   		ProperTotal=ProperTotal+1;
					    		}

				    	   	}else{
				    	   		System.out.println("Error: You have landed to proper page.But it Does not contains items");
				    	   		GenericFunctionsExtra.Concatenation(ImProper, list.get(j).toStringUnableToVerify());
				    	   		ImproperTotal=ImproperTotal+1;
				    	   	}
				    	    System.out.println("*****22********");
					}else{
						//GenericWebDriverFunctions.driver.getTitle();
						System.out.println("Title::::::"+GenericWebDriverFunctions.driver.getTitle());
						tokens = GenericFunctionsExtra.Split(list.get(j).getCatagoryName());
						boolean status2=false;
						for (int count = 0; count < tokens.length; count++) {
							System.out.println("tokens::///"+tokens[count]);
							if(GenericWebDriverFunctions.driver.getTitle().contains(tokens[count])){
								status2=true;	
								break;
							}
						}
						tokens=null;
						if(status2){
						GenericFunctionsExtra.Concatenation(Proper, list.get(j).toStringUnableToVerify()); 
						ProperTotal=ProperTotal+1;
						System.out.println("******33-1*******");
						}else{
							GenericFunctionsExtra.Concatenation(UnableProper, list.get(j).toStringUnableToVerify()); 
							UnableTotal=UnableTotal+1;
							System.out.println("******33-2*******");	
						}
						status2=false;
					}
						
				}else {

					GenericFunctionsExtra.Concatenation(UnableProper,  list.get(j).toStringUnableToVerify());
					UnableTotal=UnableTotal+1;

					System.out.println("******44*******");
					
				}
				status=false;
				
			} catch (Exception e) {
				CustomReporter.addChildInfo("Exception:"+e);
				GenericFunctionsExtra.Concatenation(UnableProper,  list.get(j).toStringUnableToVerify());
				UnableTotal=UnableTotal+1;
			}
			
			//-------------------Code Ends Here
			Thread.sleep(1000);
			
		}
    	list.clear();
    	//----------------------------------For Loop Ends Here---------------------
    	
    	if(Proper.length()==0){
			CustomReporter.reportChild("fail", "Error:Unable to verify  L2 Level Navigation of "+elementMotherTxt+"Catagory.  ");
		}
    	CustomReporter.addChildInfo("The following L2 Level Navigation ---'"+elementMotherTxt+"'---  has landed to respective pages::  ---"+Proper);
		CustomReporter.addChildInfo("The following L2 Level Navigation ---'"+elementMotherTxt+"'---  has not landed to respective pages:: ---"+ImProper);
		CustomReporter.addChildInfo("Unable to verify ----- Please Check Manually:: ---"+UnableProper);
    	
    	//CustomReporter.addChildInfo("Catagory:: ---"+Checker);
	} catch (Exception e) {
/*		CustomReporter.addChildInfo("Exception:"+e);
		CustomReporter.addChildInfo("Catagory:: ---"+Checker);*/
		CustomReporter.reportChild("fail", "Error:Unable to verify L2-Level Navigation."+e);
		CustomReporter.addChildInfo("The following L2 Level Navigation  ---'"+elementMotherTxt+"'---  has landed to respective pages::  ---"+Proper);
		CustomReporter.addChildInfo("The following L2 Level Navigation  ---'"+elementMotherTxt+"'---  has not landed to respective pages:: ---"+ImProper);
		CustomReporter.addChildInfo("Unable to verify ----- Please Check Manually:: ---"+UnableProper);
	}
	CustomReporter.endChildTest();
}

public static void L1NavagationAllCheckrevised()
		{ProperTotal=0;
		ImproperTotal=0;
		UnableTotal=0;
		AllTotal=0;
	ExcelLibrary exe=new ExcelLibrary(TopNavigationConstands.filepath);
	int L1CatagoryIndex=1;
	String L1catagoryNameIP=(String) exe.getCellData(TopNavigationConstands.TestData, TopNavigationConstands.L1catagoryNameRow, TopNavigationConstands.cellno);
	if(L1catagoryNameIP.isEmpty()){
		L1CatagoryIndex=1;
	}
	//Double  StartCouterno11= (Double) exe.getCellData(TopNavigationConstands.TestData, TopNavigationConstands.StartCouterno, TopNavigationConstands.cellno);
	//StartCouterNo=StartCouterno11.intValue();
	
	if(L1catagoryNameIP.equalsIgnoreCase("for home")){
		L1CatagoryIndex=1;
	}else if (L1catagoryNameIP.equalsIgnoreCase("bed & bath")) {
		L1CatagoryIndex=2;
	}else if (L1catagoryNameIP.equalsIgnoreCase("women")) {
		L1CatagoryIndex=3;
	}else if (L1catagoryNameIP.equalsIgnoreCase("plus size")) {
		L1CatagoryIndex=4;
	}else if (L1catagoryNameIP.equalsIgnoreCase("lingerie")) {
		L1CatagoryIndex=5;
	}else if (L1catagoryNameIP.equalsIgnoreCase("men")) {
		L1CatagoryIndex=6;
	}else if (L1catagoryNameIP.equalsIgnoreCase("juniors")) {
		L1CatagoryIndex=7;
	}else if (L1catagoryNameIP.equalsIgnoreCase("kids")) {
		L1CatagoryIndex=8;
	}else if (L1catagoryNameIP.equalsIgnoreCase("shoes & sandals")) {
		L1CatagoryIndex=9;
	}else if (L1catagoryNameIP.equalsIgnoreCase("accessories")) {
		L1CatagoryIndex=10;
	}else if (L1catagoryNameIP.equalsIgnoreCase("markdowns")) {
		L1CatagoryIndex=11;
	}
	
	for (int i = L1CatagoryIndex; i <=10; i++) {	
		L1Revised(i);
		//StartCouterNo=1;
	}
}

public static void L1Revised(int index){
	
	String  L1catagoryName=null;
	StringBuffer ProperBufferL1=new StringBuffer();
	StringBuffer ImProperBufferL1=new StringBuffer();
	StringBuffer UnableBufferL1=new StringBuffer();
	try {
		//int index=1;
		WebElement elementName=GenericWebDriverFunctions.findElementsBy("(//a[@class='main-nav-link'])["+index+"]");
		L1catagoryName=elementName.getText();
		CustomReporter.startChild("L1 Navigation Check '"+elementName.getText()+"' Catagory", "");
    	GenericWebDriverFunctions.performAction(StringConstants.MOUSEOVER, elementName, "");
		Thread.sleep(3000);
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, elementName, "");
		List<WebElement> L2Navigator=GenericWebDriverFunctions.driver.findElements(By.xpath("//div[@class='left-nav']//a[@class='link-list-link']"));
		
		List li=GenericWebDriverFunctions.driver.findElements(By.xpath("//a[contains(text(),'View More')]"));
    	if(li.size()>0){
    		for (int i = 1; i <=li.size(); i++) {
			WebElement ele=GenericWebDriverFunctions.findElementsBy("(//a[contains(text(),'View More')])["+i+"]");
			GenericWebDriverFunctions.performAction(StringConstants.CLICK, ele, "");
			}
    		
    	}
		
		
		
		System.out.println("Total size:"+L2Navigator.size());
		//CustomReporter.addChildInfo(description);
		
		for (int i = 0; i < L2Navigator.size(); i++) {
			L1Pojo l1obj=new L1Pojo();
			
			String str[]=L2Navigator.get(i).getText().split("\\(");
			String stt=str[0].trim();
			l1obj.setIndex(i);
			l1obj.setCatagoryName(stt);
			l1obj.setCatagorylink(L2Navigator.get(i).getAttribute("href"));
			listforL1.add(l1obj);
			System.out.println(i+"::"+stt);
		}
		
		System.out.println("Total size 111:"+listforL1.size());
		CustomReporter.addChildInfo("Total size   :  "+listforL1.size());
		AllTotal=AllTotal+listforL1.size();
		for (int j = 0; j < listforL1.size(); j++) {
			//System.out.println("---"+listforL1.get(j).getIndex()+"--"+listforL1.get(j).getCatagoryName()+"--"+listforL1.get(j).getCatagorylink());
		    GenericWebDriverFunctions.driver.get(listforL1.get(j).getCatagorylink());
		    //verification code starts here-------------------
		    try{

				
				//if(!list.get(j).getCatagoryName().equalsIgnoreCase("Home Décor")){
					 GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, GenericWebDriverFunctions.findElementsBy("//h1"), "");
					// System.out.println(GenericWebDriverFunctions.getText);
					 WebElement Expected = null;
					 tokens = GenericFunctionsExtra.Split(listforL1.get(j).getCatagoryName());
					 for (int z = 0; z <tokens.length; z++) {
						status=GenericWebDriverFunctions.getText.contains(tokens[z]);
					 }
					 tokens=null;
					 
					 
					 GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, GenericWebDriverFunctions.findElementsBy("//h1"), "");
					 if(status){
						 if(TopNavigationChecker.NoOfItemsDisplayed()>0){
				    			System.out.println("Landed Page::"+GenericWebDriverFunctions.getText);
						    	System.out.println("You have landed to respective SRP Page");
						    	//GenericFunctionsExtra.Concatenation(Proper, GenericWebDriverFunctions.getText+"  ,  ");
						    	GenericFunctionsExtra.Concatenation(ProperBufferL1, listforL1.get(j).getStringL1Catagories());
						    	ProperTotal=ProperTotal+1;
				    		}else if (L2NavigationLinks.size()>0) {
				    			System.out.println("Landed Page::"+GenericWebDriverFunctions.getText);
						    	System.out.println("You have landed to respective Next-Level catagory");
						    	GenericFunctionsExtra.Concatenation(ProperBufferL1, listforL1.get(j).getStringL1Catagories());
						    	ProperTotal=ProperTotal+1;
				    		}

				    	 System.out.println("******11*******");
					 }else if (GenericFunctionsExtra.ElementVisibility(L2NavLandingPageVerification)) {
						 WebElement element11=GenericWebDriverFunctions.driver.findElement(By.xpath("//div[@class='dropdowns-additional']"));
				    	    String title=element11.getAttribute("title");
				    	   	System.out.println("Landed Page Brand Name::"+title);
				    	   //	System.out.println("Landed Page Brand Name got::"+listforL1.get(j).getCatagoryName());
				    	   	
				    	   	if(title.equalsIgnoreCase(listforL1.get(j).getCatagoryName())){
				    	   		//System.out.println("Items displayed in SRP page: "+TopNavigationChecker.NoOfItemsDisplayed());
				    	   		if(TopNavigationChecker.NoOfItemsDisplayed()>0){
				    	   			System.out.println("You have landed to respective  catagory SRP-Page");
					    	   		GenericFunctionsExtra.Concatenation(ProperBufferL1, listforL1.get(j).getStringL1Catagories());
					    	   		ProperTotal=ProperTotal+1;
					    		}

				    	   	}else{
				    	   		System.out.println("Error: You have landed to proper page.But it Does not contains items");
				    	   		GenericFunctionsExtra.Concatenation(ImProperBufferL1, listforL1.get(j).getStringL1Catagories());
				    	   		ImproperTotal=ImproperTotal+1;
				    	   	}
				    	    System.out.println("*****22********");
					}else{
						//GenericWebDriverFunctions.driver.getTitle();
						System.out.println("Title::::::"+GenericWebDriverFunctions.driver.getTitle());
						tokens = GenericFunctionsExtra.Split(listforL1.get(j).getCatagoryName());
						boolean status2=false;
						for (int count = 0; count < tokens.length; count++) {
							System.out.println("tokens::///"+tokens[count]);
							if(GenericWebDriverFunctions.driver.getTitle().contains(tokens[count])){
								status2=true;	
								break;
							}
						}
						tokens=null;
						if(status2){
						GenericFunctionsExtra.Concatenation(ProperBufferL1, listforL1.get(j).getStringL1Catagories()); 
						ProperTotal=ProperTotal+1;
						System.out.println("******33-1*******");
						}else{
							GenericFunctionsExtra.Concatenation(UnableBufferL1, listforL1.get(j).getStringL1Catagories()); 
							UnableTotal=UnableTotal+1;
							System.out.println("******33-2*******");	
						}
						status2=false;
					}
						
				status=false;
				
			
		    }catch (Exception e) {
				CustomReporter.addChildInfo("Exception:"+e);
				GenericFunctionsExtra.Concatenation(UnableBufferL1, listforL1.get(j).getStringL1Catagories());
				UnableTotal=UnableTotal+1;
			}
		    
		  //verification code ends here-------------------
		}
		
		listforL1.clear();
		if(ProperBufferL1.length()==0){
			CustomReporter.reportChild("fail", "Error:Unable to verify  L1 Level Navigation of "+L1catagoryName+"Catagory.  ");
		}
		CustomReporter.addChildInfo("The following L1 Level Navigation ---'"+L1catagoryName+"'---  has landed to respective pages::  ---"+ProperBufferL1);
		CustomReporter.addChildInfo("The following L1 Level Navigation ---'"+L1catagoryName+"'---  has not landed to respective pages:: ---"+ImProperBufferL1);
		CustomReporter.addChildInfo("Unable to verify ----- Please Check Manually:: ---"+UnableBufferL1);
		
	} catch (Exception e) {
		//System.out.println("exception::"+e);
		CustomReporter.reportChild("fail", "Error:Unable to verify L1-Level Navigation."+e);
		CustomReporter.addChildInfo("The following L1 Level Navigation ---'"+L1catagoryName+"'---  has landed to respective pages::  ---"+ProperBufferL1);
		CustomReporter.addChildInfo("The following L1 Level Navigation ---'"+L1catagoryName+"'---  has not landed to respective pages:: ---"+ImProperBufferL1);
		CustomReporter.addChildInfo("Unable to verify ----- Please Check Manually:: ---"+UnableBufferL1);
	}
	CustomReporter.endChildTest();
}

}
