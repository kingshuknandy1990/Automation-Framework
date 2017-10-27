package com.Pages.AllBealls;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericFunctions.WebDriver.GenericFunctionsExtra;
import com.GenericFunctions.WebDriver.GenericWebDriverFunctions;
import com.constants.string.HomePageExtendedConstands;
import com.constants.string.ShoppingCartPageConstands;
import com.constants.string.StringConstants;
import com.reports.beallsCustom.CustomReporter;
//import com.sun.org.apache.bcel.internal.generic.Select;
import org.openqa.selenium.support.ui.Select;
public class ShoppingCartPage {

	@FindBy(xpath=ShoppingCartPageConstands.CartPageHeading)
	public static WebElement CartPageHeading;
	
	@FindBy(xpath=ShoppingCartPageConstands.CartPageHeading)
	public static List <WebElement> CartPageHeadinglist;
	
	@FindBy(xpath=ShoppingCartPageConstands.Shoppingbag)
	public static WebElement Shoppingbag;
	
	@FindBy(xpath=ShoppingCartPageConstands.Shoppingbag)
	public static List <WebElement> Shoppingbaglist;
	
	
	@FindBy(xpath=ShoppingCartPageConstands.ItemDescription)
	public static WebElement ItemDescription;
	
	@FindBy(xpath=ShoppingCartPageConstands.ItemDescription)
	public static List <WebElement> ItemDescriptionlist;
	
	@FindBy(xpath=ShoppingCartPageConstands.Shipping)
	public static WebElement Shipping;
	
	@FindBy(xpath=ShoppingCartPageConstands.Shipping)
	public static List <WebElement> Shippinglist;
	
	@FindBy(xpath=ShoppingCartPageConstands.Quantity)
	public static WebElement Quantity;
	
	@FindBy(xpath=ShoppingCartPageConstands.Quantity)
	public static List <WebElement> Quantitylist;
	
	@FindBy(xpath=ShoppingCartPageConstands.Price)
	public static WebElement Price;
	
	@FindBy(xpath=ShoppingCartPageConstands.Price)
	public static List <WebElement> Pricelist;
	
	@FindBy(xpath=ShoppingCartPageConstands.Subtotal)
	public static WebElement Subtotal;
	
	@FindBy(xpath=ShoppingCartPageConstands.Subtotal)
	public static List <WebElement> Subtotallist;
	
	@FindBy(xpath=ShoppingCartPageConstands.promotionSection)
	public static WebElement promotionSection;
	
	@FindBy(xpath=ShoppingCartPageConstands.promotionSection)
	public static List <WebElement> promotionSectionlist;
	
	@FindBy(xpath=ShoppingCartPageConstands.OrderTotalSection)
	public static WebElement OrderTotalSection;
	
	@FindBy(xpath=ShoppingCartPageConstands.OrderTotalSection)
	public static List <WebElement>OrderTotalSectionlist;
	
	@FindBy(xpath=ShoppingCartPageConstands.AccountsLogin)
	public static WebElement AccountsLogin;
	
	@FindBy(xpath=ShoppingCartPageConstands.AccountsLogin)
	public static List <WebElement>AccountsLoginlist;
	
	@FindBy(xpath=ShoppingCartPageConstands.ShippingAndDelivery)
	public static WebElement ShippingAndDelivery;
	
	@FindBy(xpath=ShoppingCartPageConstands.ShippingAndDelivery)
	public static List <WebElement>ShippingAndDeliverylist;
	
	@FindBy(xpath=ShoppingCartPageConstands.PaymentAndBilling)
	public static WebElement PaymentAndBilling;
	
	@FindBy(xpath=ShoppingCartPageConstands.PaymentAndBilling)
	public static List <WebElement>PaymentAndBillinglist;
	
	@FindBy(xpath=ShoppingCartPageConstands.ConfirmOrder)
	public static WebElement ConfirmOrder;
	
	@FindBy(xpath=ShoppingCartPageConstands.ConfirmOrder)
	public static List <WebElement>ConfirmOrderlist;

	@FindBy(xpath=ShoppingCartPageConstands.ItemBlock)
	public static WebElement ItemBlock;
	
	@FindBy(xpath=ShoppingCartPageConstands.ItemBlock)
	public static List <WebElement>ItemBlocklist;
	

	/**
	 * Initializing the web elements
	 */
	public ShoppingCartPage(){
		PageFactory.initElements(GenericWebDriverFunctions.driver,this);
	}
	
	public static void VerificationOfCartPage() throws InterruptedException{
		if(CustomReporter.currentTestCase.contains("Checking the various Sections of Shopping Cart Page")){
			GenericFunctionsExtra.parentReportName="Checking the various Sections of Shopping Cart Page";
			
			GenericFunctionsExtra.parentReportDescription="Verifying The Shopping Cart Page is displaying the Proper Feilds or Not(Heading,Shopping Bag,Item Detail,Shipping,Quantity,Price ,subtotal,Promotion section,Order Total section).Also verifying Accounts Login ,Shipping And Delivery, Payment & Billing and confirm Order Section is getting Displayed In the right hand side or not";
			
		}
		CustomReporter.startChild("Checking The Shopping Cart Page", "");
		try {
			boolean heading=false,shoppBag=false,items=false,accountslogin=false,shippinganddeli=false,payandbill=false,
					promotionSectionother=false,OrderTotalSectionother=false,subtotalOther=false;
			
			
			if(GenericFunctionsExtra.ElementVisibility(CartPageHeadinglist)  && GenericFunctionsExtra.ElementVisibility(Shoppingbaglist)){
				GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, CartPageHeading, "");
				CustomReporter.addChildInfo("Shopping Cart Page Header:"+GenericWebDriverFunctions.getText);
				
				GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, Shoppingbag, "");
				CustomReporter.addChildInfo("Shopping Bag Content:"+GenericWebDriverFunctions.getText);
				heading=true;
				shoppBag=true;
			}
				if(ItemBlocklist.size()>0){
					StringBuffer ItemDescriptionBuffer = new StringBuffer();
					for (int i = 1; i <=ItemBlocklist.size(); i++) {
						String itemName=GenericWebDriverFunctions.driver.findElement(By.xpath("(//div[@class='items']//div[@class='item row']//p[@class='strong_content'])["+i+"]")).getText();
					  String output="Item Name :" + itemName+ "<br/>"+
											"***********************************************************************";
					  GenericFunctionsExtra.Concatenation(ItemDescriptionBuffer, output);   
					}
					
					//String str=ItemDescription;
					CustomReporter.addChildInfo(""+ItemDescriptionBuffer);
				}else{
					CustomReporter.addChildInfo("Items are not properly displayed");
				}
				
				if(GenericFunctionsExtra.ElementVisibility(AccountsLoginlist)){
					GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, AccountsLogin, "");
					if(GenericWebDriverFunctions.getText.contains("Account Login")){
					accountslogin=true;
					CustomReporter.addChildInfo("Displaying 'Account Login' section in right side of Cart Page");
					}
				}
				
				if(GenericFunctionsExtra.ElementVisibility(ShippingAndDeliverylist)){
					GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, ShippingAndDelivery, "");
					if(GenericWebDriverFunctions.getText.contains("Shipping & Delivery")){
					shippinganddeli=true;
					CustomReporter.addChildInfo("Displaying 'Shipping & Delivery' section in right side of Cart Page");
					}
				}
				
				
				if(GenericFunctionsExtra.ElementVisibility(PaymentAndBillinglist)){
					GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, PaymentAndBilling, "");
					if(GenericWebDriverFunctions.getText.contains("Payment & Billing")){
					payandbill=true;
					CustomReporter.addChildInfo("Displaying 'Payment & Billing' section in right side of Cart Page");
					}
				}
				//-----------------------------------------
				/*Subtotal="//div//ul//li[@class='totals-subtotal']",
						promotionSection="//div[@class='action apply']",
						OrderTotalSection="//div//ul//li[@class='totals-total']"*/
				if(GenericFunctionsExtra.ElementVisibility(Subtotallist)){
					GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, Subtotal, "");
					
					subtotalOther=true;
					CustomReporter.addChildInfo("In Subtoltal Section:"+GenericWebDriverFunctions.getText+" is getting Displayed");
				
				}
				
				if(GenericFunctionsExtra.ElementVisibility(OrderTotalSectionlist)){
					GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, OrderTotalSection, "");
					OrderTotalSectionother=true;
					CustomReporter.addChildInfo("In Order Total Section:"+GenericWebDriverFunctions.getText+" is getting Displayed");
				}
				
				if(GenericFunctionsExtra.ElementVisibility(promotionSectionlist)){
					GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, promotionSection, "");
					promotionSectionother=true;
					CustomReporter.addChildInfo("Promotion Feild is getting Displayed");
				}
				
				//-----------------------------------------
				
				if(heading && shoppBag && accountslogin && shippinganddeli && payandbill && subtotalOther && OrderTotalSectionother  && promotionSectionother){
					CustomReporter.reportChild("pass", "Shopping Cart Page Attributes are properly displayed");
				}else{
					CustomReporter.reportChild("fail", "Shopping Cart Page Attributes are not getting properly displayed");
				}
			
			
		} catch (Exception e) {
			CustomReporter.reportChild("fail", "Exception occured while navigating to cart page   "+e);
		}
		CustomReporter.endChildTest();
	}
	
	public static void VerifyQtyDrpDownCartPage() throws InterruptedException{
		//Updating Quantity Dropdown in cart page

		if(CustomReporter.currentTestCase.contains("Updating Quantity Dropdown in cart page")){
			GenericFunctionsExtra.parentReportName="Checking Proper Total is getting displayed or not after updating the quantity ";
			
			GenericFunctionsExtra.parentReportDescription="In Shopping Cart Page ,altering the number of items from quantity dropdown,and verifying whether total price changing or not";
			
		}
		CustomReporter.startChild("Updating Quantity Dropdown in cart page", "");
		try {
			
				if(ItemBlocklist.size()>0){
					StringBuffer ItemDescriptionBuffer = new StringBuffer();
					
					
					for (int i = 1; i <=ItemBlocklist.size(); i++) {
						WebElement qtyElement=GenericWebDriverFunctions.driver.findElement(By.xpath("( //div[@class='items']//div[@class='item row']//div[4]//div[2]//select)["+i+"]"));
						Select option=new Select(qtyElement);
						option.selectByValue("3");
						Thread.sleep(2000);
						String qty=option.getFirstSelectedOption().getText();
						
						String perItemPrice=GenericWebDriverFunctions.driver.findElement(By.xpath("( //div[@class='items']//div[@class='item row']//div[4]//div//div[1])["+i+"]")).getText();
						
						String itemName=GenericWebDriverFunctions.driver.findElement(By.xpath("(//div[@class='items']//div[@class='item row']//p[@class='strong_content'])["+i+"]")).getText();
						
						String TotalPrice=GenericWebDriverFunctions.driver.findElement(By.xpath("(//div[@class='action gifting']//div)["+i+"]")).getText();
						//Select select = new Select(TotalPriceelement);
						
						
						
						
						String output="Item Name   :" + itemName+ "<br/>"+
							  		"Price/Item  :" + perItemPrice+ "<br/>"+
							  		"Quantity    :" + qty+ "<br/>"+
							  		"TotalPrice  :" + TotalPrice+ "<br/>"+
							  
											"***********************************************************************";
						CustomReporter.addChildInfo(output);
						List li=GenericFunctionsExtra.quantityPriceValidator(perItemPrice, qty, TotalPrice);
						boolean status=(boolean) li.get(0);
						double CalculatedTotalPrice=(double) li.get(1);
						CustomReporter.addChildInfo("Calculated Total Price: "+CalculatedTotalPrice);
						if(status){
							CustomReporter.reportChild("pass", "Proper Total is displayed");	
						}else{
							CustomReporter.reportChild("fail", "Proper Total is not displayed");
						}
					  //GenericFunctionsExtra.Concatenation(ItemDescriptionBuffer, output);   
					}
					
					//String str=ItemDescription;
					
				}else{
					//CustomReporter.addChildInfo("Items are not properly displayed");
					CustomReporter.reportChild("fail", "Items are not properly displayed");
				}
				
				
				//-----------------------------------------
				/*
				if(heading && shoppBag && accountslogin && shippinganddeli && payandbill && subtotalOther && OrderTotalSectionother  && promotionSectionother){
					CustomReporter.reportChild("pass", "Shopping Cart Page Attributes are properly displayed");
				}else{
					CustomReporter.reportChild("fail", "Shopping Cart Page Attributes are not getting properly displayed");
				}*/
			
			
		} catch (Exception e) {
			CustomReporter.reportChild("fail", "Exception occured while navigating to cart page   "+e);
		}
		CustomReporter.endChildTest();
	
	}
	
	
	
	
	public static void ValidationOfRemoveLinkCartPage() throws InterruptedException{
		//Verifying the Remove link in Cart Page Items Block

		if(CustomReporter.currentTestCase.contains("Verifying the Remove link in Cart Page Items Block")){
			GenericFunctionsExtra.parentReportName="Verifying the Remove link in Cart Page Items Block";
			
			GenericFunctionsExtra.parentReportDescription="After clicking the Remove link in Cart Page Items Block,The particular product line should be removed from the cart and the Subtotal field should be updated accordingly";
			
		}
		CustomReporter.startChild("Verifying the Remove link in Cart Page Items Block", "");
		try {
			
				if(ItemBlocklist.size()>0){
					StringBuffer ItemDescriptionBuffer = new StringBuffer();
					for (int i = 1; i <=ItemBlocklist.size(); i++) {
						String itemName=GenericWebDriverFunctions.driver.findElement(By.xpath("(//div[@class='items']//div[@class='item row']//p[@class='strong_content'])["+i+"]")).getText();
					  String output="Item Name :" + itemName+ "<br/>"+
											"***********************************************************************";
					  GenericFunctionsExtra.Concatenation(ItemDescriptionBuffer, output);   
					}
					
					//String str=ItemDescription;
					CustomReporter.addChildInfo(""+ItemDescriptionBuffer);
				}else{
					CustomReporter.addChildInfo("Items are not properly displayed");
				}
				
				
				//-----------------------------------------
				/*
				if(heading && shoppBag && accountslogin && shippinganddeli && payandbill && subtotalOther && OrderTotalSectionother  && promotionSectionother){
					CustomReporter.reportChild("pass", "Shopping Cart Page Attributes are properly displayed");
				}else{
					CustomReporter.reportChild("fail", "Shopping Cart Page Attributes are not getting properly displayed");
				}*/
			
			
		} catch (Exception e) {
			CustomReporter.reportChild("fail", "Exception occured while navigating to cart page   "+e);
		}
		CustomReporter.endChildTest();
	
	}
	
	
	public static void removeAllItemfromCartPage() throws InterruptedException{
		//Remove all items from Cart Page

		if(CustomReporter.currentTestCase.contains("Remove all items from Cart Page")){
			GenericFunctionsExtra.parentReportName="Removing  all items from Cart Page and verifying the message";
			
			GenericFunctionsExtra.parentReportDescription="All the item should be removed from the cart and the message should be displayed on the screen 'Your shopping cart is empty.";
			
		}
		CustomReporter.startChild("Verifying the Remove link in Cart Page Items Block", "");
		try {
			
				if(ItemBlocklist.size()>0){
					StringBuffer ItemDescriptionBuffer = new StringBuffer();
					for (int i = 1; i <=ItemBlocklist.size(); i++) {
						String itemName=GenericWebDriverFunctions.driver.findElement(By.xpath("(//div[@class='items']//div[@class='item row']//p[@class='strong_content'])["+i+"]")).getText();
					  String output="Item Name :" + itemName+ "<br/>"+
											"***********************************************************************";
					  GenericFunctionsExtra.Concatenation(ItemDescriptionBuffer, output);   
					}
					
					//String str=ItemDescription;
					CustomReporter.addChildInfo(""+ItemDescriptionBuffer);
				}else{
					CustomReporter.addChildInfo("Items are not properly displayed");
				}
				
				
				//-----------------------------------------
				/*
				if(heading && shoppBag && accountslogin && shippinganddeli && payandbill && subtotalOther && OrderTotalSectionother  && promotionSectionother){
					CustomReporter.reportChild("pass", "Shopping Cart Page Attributes are properly displayed");
				}else{
					CustomReporter.reportChild("fail", "Shopping Cart Page Attributes are not getting properly displayed");
				}*/
			
			
		} catch (Exception e) {
			CustomReporter.reportChild("fail", "Exception occured while navigating to cart page   "+e);
		}
		CustomReporter.endChildTest();
	
	}
	
}
