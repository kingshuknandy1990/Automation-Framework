package com.Pages.AllBealls;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericFunctions.WebDriver.GenericFunctionsExtra;
import com.GenericFunctions.WebDriver.GenericWebDriverFunctions;
import com.collection.garbage.Constants;
import com.constants.string.HomePageExtendedConstands;
import com.constants.string.PromotionConstants;

import com.constants.string.StringConstants;
import com.excellibrary.bealls.ExcelLibrary;
import com.reports.beallsCustom.CustomReporter;

public class PromotionChecker {

	@FindBy(xpath=HomePageExtendedConstands.ShoppingBagButton)
	public static WebElement ShoppingBagButton;
	
	@FindBy(xpath=HomePageExtendedConstands.ChecOutButton)
	public static WebElement ChecOutButton;
	
	@FindBy(id=PromotionConstants.SEARCHBOX)
	public static WebElement searchBox;
	
	@FindBy(id=PromotionConstants.SEARCHBUTTON)
	public static WebElement searchButton;
	
	
	@FindBy(xpath=PromotionConstants.RandomProduct)
	public static WebElement Product;
	
	@FindBy(xpath=PromotionConstants.CheckOutInPDP)
	public static WebElement checkOut;
	
	
	@FindBy(xpath=PromotionConstants.CheckOutInPDP)
	public static List <WebElement> checkOutlist;
	
	@FindBy(xpath=HomePageExtendedConstands.CartPageTitle)
	public static List <WebElement> CartPageTitle;
	/**
	 * Initializing the web elements
	 */
	public PromotionChecker(){
		PageFactory.initElements(GenericWebDriverFunctions.driver,this);
	}
	
	/**
	 * searching any item in search box
	 */
	public static void SearchItems(){
		CustomReporter.startChild("Search Items", "");
		try {
			ExcelLibrary exe=new ExcelLibrary(PromotionConstants.filepath);
			String  keyWord=(String) exe.getCellData(PromotionConstants.TestData, PromotionConstants.mainCatagoryRow, PromotionConstants.cellno);
			GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, searchBox, keyWord);
			GenericWebDriverFunctions.performAction(StringConstants.CLICK, searchButton, "");
			CustomReporter.reportChild("pass", keyWord +"/t"+" item has been searched successfully");
			CustomReporter.addChildInfo(keyWord +"item has been searched");
		} catch (Exception e) {
			CustomReporter.reportChild("fail", "Unable to Search item ");
		}

		CustomReporter.endChildTest();
		
	}
	
	public static void selectAProduct(){
		GenericWebDriverFunctions.performAction(StringConstants.CLICK,Product, "");
	}
	
	public static void addtoCart() throws InterruptedException{
		CustomReporter.startChild("Navigating to Cart Page", "");
		try {
			/*Thread.sleep(2000);
			ProductDisplayPage.selectRandomSize();
			Thread.sleep(2000);
			ProductDisplayPage.addToCart_PDP();
			Thread.sleep(2000);*/
			//PromotionChecker.checkOutinPDP();
			if(GenericFunctionsExtra.ElementVisibility(checkOutlist)){
				checkOutinPDP();
				CustomReporter.reportChild("pass", "Successfully navigated to cart page");
			}else{
				GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, ShoppingBagButton, "");
				int NoOfItems=Integer.parseInt(GenericWebDriverFunctions.getText);
				if(NoOfItems>0){
					System.out.println("There is items  in Cart=====");
					GenericWebDriverFunctions.performAction(StringConstants.CLICK, ShoppingBagButton, "");	
					GenericWebDriverFunctions.performAction(StringConstants.CLICK, ChecOutButton, "");
					//Thread.sleep(1000);
					CustomReporter.reportChild("pass", "Successfully navigated to cart page");
				}else{
					CustomReporter.reportChild("fail", "Unable to navigate to cart page, as there in no items in Cart");
				}
			}
			//CustomReporter.reportChild("pass", "A random item has been added to Cart");
		} catch (Exception e) {
			CustomReporter.reportChild("fail", "Exception occured while navigating to cart page   "+e);
		}
		CustomReporter.endChildTest();
	}
	
	public static void addToCartContinueShopping() throws InterruptedException{
		CustomReporter.startChild("Adding Item from to Cart", "");
		try {
			if(GenericFunctionsExtra.ElementVisibility(checkOutlist)){
				ContinueShoppinginPDP();
				CustomReporter.reportChild("pass", "Successfully Added product to cart ");
			}else{
				GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, ShoppingBagButton, "");
				int NoOfItems=Integer.parseInt(GenericWebDriverFunctions.getText);
				if(NoOfItems>0){
					System.out.println("There is items  in Cart=====");
					GenericWebDriverFunctions.performAction(StringConstants.CLICK, ShoppingBagButton, "");	
					//GenericWebDriverFunctions.performAction(StringConstants.CLICK, ChecOutButton, "");
					GenericWebDriverFunctions.driver.findElement(By.xpath(Constants.ContinueShoppingButton)).click();
					//Thread.sleep(1000);
					CustomReporter.reportChild("pass", "Successfully navigated to cart page");
				}else{
					CustomReporter.reportChild("fail", "Unable to navigate to cart page, as there in no items in Cart");
				}
			}
			//CustomReporter.reportChild("pass", "A random item has been added to Cart");
		} catch (Exception e) {
			CustomReporter.reportChild("fail", "Exception occured while navigating to cart page   "+e);
		}
		CustomReporter.endChildTest();
	}
	
	public static void ClickOnMiniCart() throws InterruptedException{
		if(CustomReporter.currentTestCase.contains("Funtionality of Checkout Button in minicart Page")){
			GenericFunctionsExtra.parentReportName="Minicart Functionlity Checker";
			
			GenericFunctionsExtra.parentReportDescription="After adding an item to cart,the minicart should display the item.And after clicking on the Checkout of Mini-Cart it should Navigate to Cart Page";
			
		}
		CustomReporter.startChild("Navigating to Cart Page", "");
		try {
			
				GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, ShoppingBagButton, "");
				int NoOfItems=Integer.parseInt(GenericWebDriverFunctions.getText);
				if(NoOfItems>0){
					System.out.println("There is items  in Cart=====");
					CustomReporter.addChildInfo("Items are getting Displayed in Mini Cart Page");
					GenericWebDriverFunctions.performAction(StringConstants.CLICK, ShoppingBagButton, "");	
					GenericWebDriverFunctions.performAction(StringConstants.CLICK, ChecOutButton, "");
					//GenericWebDriverFunctions.driver.findElement(By.xpath(Constants.ContinueShoppingButton)).click();
					//Thread.sleep(1000);
					CustomReporter.reportChild("pass", "Clicked on Check Out Button in minicart");
				}else{
					CustomReporter.reportChild("fail", "Items are not getting Displayed in Mini Cart Page");
				}
			
			//CustomReporter.reportChild("pass", "A random item has been added to Cart");
		} catch (Exception e) {
			CustomReporter.reportChild("fail", "Exception occured while navigating to cart page   "+e);
		}
		CustomReporter.endChildTest();
	}
	
	
	
	
	public static void VerificationOfCartPageHeader() throws InterruptedException{
		CustomReporter.startChild("Checking the Shopping Cart Page Header", "");
		try {
			
				if(GenericFunctionsExtra.ElementVisibility(CartPageTitle)){
					CustomReporter.reportChild("pass", "Succesfully Navigated to cart Page");
				}else{
					CustomReporter.reportChild("fail", "Unable To Navigate to cart Page");
				}
			
			//CustomReporter.reportChild("pass", "A random item has been added to Cart");
		} catch (Exception e) {
			CustomReporter.reportChild("fail", "Exception occured while navigating to cart page   "+e);
		}
		CustomReporter.endChildTest();
	}
	
	
	
	
	public static void checkOutinPDP()
	{
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, checkOut, "");
		
	}
	
	public static void ContinueShoppinginPDP()
	{
		//GenericWebDriverFunctions.performAction(StringConstants.CLICK, checkOut, "");
		GenericWebDriverFunctions.driver.findElement(By.xpath(Constants.ContinueShoppingButton)).click();
		
	}
	public static void waitTime() throws InterruptedException{
		Thread.sleep(10000);
	}
	

}
