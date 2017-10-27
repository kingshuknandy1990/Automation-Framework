package com.Pages.AllBealls;

import java.awt.AWTException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.GenericFunctions.WebDriver.GenericWebDriverFunctions;
import com.classs.usage.TestClass;
import com.constants.string.OrderItemDisplayConstants;
import com.constants.string.OrderShippingConstants;
import com.constants.string.StringConstants;
import com.reports.beallsCustom.CustomReporter;

public class OrderShippingPage {
	
	@FindBy(name=OrderShippingConstants.SHIPSAMEBILL)
	public static WebElement shipSameBill; 
	
	 @FindBy(xpath=OrderShippingConstants.CONCHECKOUT) 
	public static  WebElement  checkOut;
	
	@FindAll({@FindBy(xpath=OrderShippingConstants.SUBTOTALS)})
	public static List <WebElement> subTotals;
	
	@FindBy(xpath=OrderShippingConstants.SUBTOTAL)
	public static WebElement subTotal;
	
	@FindBy(xpath=OrderShippingConstants.EDITSHIPOPC)
	public static WebElement editShipAddOpc;
	
	@FindBy(xpath=OrderShippingConstants.EDITBILLING)
	public static WebElement editBilling;
	
	@FindBy(xpath=OrderShippingConstants.STATE)
	public static WebElement state;
	
	@FindBy(xpath=OrderShippingConstants.CITY)
	public static WebElement city;
	@FindBy(xpath=OrderShippingConstants.STATEOPC)
	public static WebElement stateOpc;
	
	@FindBy(xpath=OrderShippingConstants.CITYOPC)
	public static WebElement cityOpc;
	
	@FindBy(xpath=OrderShippingConstants.ZIPCODE)
	public static WebElement zipCode;
	

	@FindBy(xpath=OrderShippingConstants.PHONE)
	public static WebElement phone;
	@FindBy(xpath=OrderShippingConstants.ZIPCODEOPC)
	public static WebElement zipCodeOpc;
	

	@FindBy(xpath=OrderShippingConstants.PHONEOPC)
	public static WebElement phoneOpc;
	@FindBy(xpath=OrderShippingConstants.EDITSHIPPING)
	public static WebElement editShipping;
	
	@FindBy(xpath=OrderShippingConstants.SSTATE)
	public static WebElement shipState;
	
	@FindBy(xpath=OrderShippingConstants.ORDERCONFIRM)
	public static WebElement orderConfirmOpc;
	@FindBy(xpath=OrderShippingConstants.SCITY)
	public static WebElement shipCity;
	
	@FindBy(xpath=OrderShippingConstants.SZIPCODE)
	public static WebElement shipCode;
	
	@FindBy(xpath=OrderShippingConstants.USEMYENTRY)
	public static WebElement useMyEntry;
	@FindBy(xpath=OrderShippingConstants.GIFTSUBTOTAL)
	public static WebElement giftSubTotal;
	
	@FindBy(xpath=OrderShippingConstants.SHIPADDRESS)
	public static WebElement shipAdd;
	
	@FindBy(xpath=OrderShippingConstants.BILLADDRESS)
	public static WebElement billAdd;
	
	@FindBy(xpath=OrderShippingConstants.SAMESHIPBILL)
	public static WebElement sameShipBillOcp;
	
	public static String billState ,billZip ,billCity ;
	
	@FindBy(xpath=OrderShippingConstants.SAMESHIPBILL)
	public static WebElement billAddOption;
	
	@FindBy(xpath=OrderShippingConstants.PLACEORDEROPC)
	public static WebElement placeOrderOpc; 
	
	@FindBy(xpath=OrderShippingConstants.CITY_OPC_ES)
	public static WebElement cityOpcEs;
	
	@FindBy(xpath=OrderShippingConstants.STATE_OPC_ES)
	public static WebElement stateOpcEs;
	
	@FindBy(xpath=OrderShippingConstants.ZIP_CODE_OPC_ES)
	public static WebElement zipCodeOpcEs;
	
	public static double tempSubTot;
	static {new OrderShippingPage();}
	
	public OrderShippingPage() {
		PageFactory.initElements(GenericWebDriverFunctions.driver,this);
	}
	public static void selectShipSameBill() throws InterruptedException
	{
		
		if(!shipSameBill.isSelected())
		{
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, shipSameBill, "");
		}
	    //If same billing and shipping address without any changes 
		setBillCityState();
		
	}
	
	public static void billToProAddOpc()
	{
	 
		 GenericWebDriverFunctions.performAction(StringConstants.SELECTBYVT, sameShipBillOcp, "Bill to Profile Address");
		
	}
	
	public static void deselectShipSameBill()
	{
		if(shipSameBill.isSelected())
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, shipSameBill, "");
	}
	
 
	public static void placeOrderOpc()
	{
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, placeOrderOpc, "");
	}
	
	//To perform Continue checkout 
	public static void continueCheckout_OSP() throws InterruptedException
	{
		System.out.println(shipSameBill.isSelected());
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, checkOut, "");
		Thread.sleep(2000);
	}
	
	public static void setBillCityState() throws InterruptedException
	{
		billState=billZip=billCity="";
		GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, billAdd, "");
		System.out.println(GenericWebDriverFunctions.getText);
		billCity = GenericWebDriverFunctions.getText.split(",")[0];
		billZip = GenericWebDriverFunctions.getText.split(",")[1].trim();
		String arraData [] = billZip.split(" ");
		System.out.println("Bill city"+billCity);
		System.out.println("Bill zip "+billZip);
		for(int counter =0;counter<=(arraData.length-2);counter++)
			billState+=arraData[counter]+" ";
			
		billState = billState.trim();
		billZip = arraData[(arraData.length-1)];
		
		
		System.out.println("Bill State"+billState);
		
		
	} 
	

	
	
	public static void  validateProductSubTotal_OSP() throws InterruptedException
	{
		tempSubTot=0;
		Thread.sleep(4000);
		 String giftSubtotal="";
		Locale locale = new Locale("en", "US");
		NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
 	
		for(int i=0;i<subTotals.size();i++)
			tempSubTot+=Double.parseDouble(subTotals.get(i).getText().replace("$", ""));		
		
		if(GenericWebDriverFunctions.findElementsByXpath(OrderItemDisplayConstants.GIFTSUBTOTAL)>0)
		{
		if(!giftSubTotal.getText().isEmpty())
		{
		giftSubtotal=giftSubTotal.getText();
		
		tempSubTot -=Double.parseDouble(giftSubtotal.replace("$", ""));
		}
		}
		
		CustomReporter.startChild("Subtotal in Shipping and billing page", "");
		CustomReporter.addChildInfo("Subtotal in Shipping and billing page is "+tempSubTot);
//		System.out.println("Subtotal in OSP "+tempSubTot);
		
		if(GenericWebDriverFunctions.findElementsByXpath(OrderShippingConstants.SUBTOTAL)>0)
		{
		if(fmt.format(tempSubTot).equalsIgnoreCase(subTotal.getText()))
		CustomReporter.reportChild("PASS","Subtotals are same in Shipping and billing page" );
//		System.out.println("Subtotals are same in Order Shipping Page");
		else
		CustomReporter.reportChild("FAIL","Subtotals are not same in Shipping and billing page" );	
//		System.out.println("Subtotals are not same in Order Shipping Page");
		Thread.sleep(2000);
		}
		
		CustomReporter.endChildTest();
	}
	public static void orderConfirm(){
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, orderConfirmOpc, "");
	}
	
	public static void  editBillingAdd_OPC() throws InterruptedException, AWTException
	{
		Random r = new Random();
		int cell = r.nextInt(3)+1;
		
		Select add = new Select(sameShipBillOcp);
		
		if(add.getFirstSelectedOption().toString().equals("Bill to Profile Address"))
		{
			String _city = (String) TestClass.excel.getCellData("TestData",20, cell);
			String _state = (String) TestClass.excel.getCellData("TestData",21, cell);
			String  _zipCode= (String) TestClass.excel.getCellData("TestData",22, cell);
			String _phone = (String) TestClass.excel.getCellData("TestData", 23, 1);
//			GenericWebDriverFunctions.performAction(StringConstants., element, data)
//			Thread.sleep(1000);
 
			
			ValidatorsPage.msg=_state;
			GenericWebDriverFunctions.performAction(StringConstants.CLEAR,cityOpc , "");
//			GenericWebDriverFunctions.clearInputFiled();
//			Thread.sleep(1000);
			
			System.out.println(GenericWebDriverFunctions.findElementsByXpath(OrderShippingConstants.CITYOPC));
			billCity =_city;
			GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, cityOpc, _city);
//			Thread.sleep(1400);
			System.out.println(GenericWebDriverFunctions.findElementsByXpath(OrderShippingConstants.STATEOPC));
			billState=_state;
			GenericWebDriverFunctions.performAction(StringConstants.SELECTBYVT, stateOpc, _state);
//			Thread.sleep(1000);
			
	 
			GenericWebDriverFunctions.performAction(StringConstants.CLEAR, zipCodeOpc, "");
		  	
			System.out.println(GenericWebDriverFunctions.findElementsByXpath(OrderShippingConstants.ZIPCODEOPC));
			billZip = _zipCode.replace("-", "");
			GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, zipCodeOpc, _zipCode.replace("-", ""));
			
//			Thread.sleep(4000);
			GenericWebDriverFunctions.performAction(StringConstants.CLEAR, phoneOpc, "");
			GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, phoneOpc, _phone.replace("-", ""));
		 
		}
		
	}
	
	public static void  editBillingAdd() throws InterruptedException, AWTException
	{
		Random r = new Random();
		int cell = r.nextInt(3)+1;
		
		
		if(shipSameBill.isSelected())
		{
			String _city = (String) TestClass.excel.getCellData("TestData",20, cell);
			String _state = (String) TestClass.excel.getCellData("TestData",21, cell);
			String  _zipCode= (String) TestClass.excel.getCellData("TestData",22, cell);
			String _phone = (String) TestClass.excel.getCellData("TestData", 23, 1);
//			GenericWebDriverFunctions.performAction(StringConstants., element, data)
//			Thread.sleep(1000);
			GenericWebDriverFunctions.performAction(StringConstants.CLICK, editBilling, "");
			
			ValidatorsPage.msg=_state;
			GenericWebDriverFunctions.performAction(StringConstants.CLEAR,city , "");
//			GenericWebDriverFunctions.clearInputFiled();
//			Thread.sleep(1000);
			
			System.out.println(GenericWebDriverFunctions.findElementsByXpath(OrderShippingConstants.CITY));
			billCity =_city;
			GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, city, _city);
//			Thread.sleep(1400);
			System.out.println(GenericWebDriverFunctions.findElementsByXpath(OrderShippingConstants.STATE));
			billState=_state;
			GenericWebDriverFunctions.performAction(StringConstants.SELECTBYVT, state, _state);
//			Thread.sleep(1000);
			
	 
			GenericWebDriverFunctions.performAction(StringConstants.CLEAR, zipCode, "");
		  	
			System.out.println(GenericWebDriverFunctions.findElementsByXpath(OrderShippingConstants.ZIPCODE));
			billZip = _zipCode.replace("-", "");
			GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, zipCode, _zipCode.replace("-", ""));
			
//			Thread.sleep(4000);
			GenericWebDriverFunctions.performAction(StringConstants.CLEAR, phone, "");
			GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, phone, _phone.replace("-", ""));
		 
		}
		
	}
	
	public static void editShippingAddOpc()
	{
		Random r = new Random();
		int cell = r.nextInt(3)+1;
		String _city = (String) TestClass.excel.getCellData("TestData",20, cell);
		String _state = (String) TestClass.excel.getCellData("TestData",21, cell);
		String  _zipCode= (String) TestClass.excel.getCellData("TestData",22, cell);
		String _phone = (String) TestClass.excel.getCellData("TestData", 23, 1);
		
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, editShipAddOpc, "");
		ValidatorsPage.msg=_state;
		
		
		
	}

	public static void editShipAdd() throws InterruptedException
	{
//		if(shipSameBill.isSelected())
//		{
		Random r = new Random();
		int cell = r.nextInt(3)+1;
		String _city = (String) TestClass.excel.getCellData("TestData",20, cell);
		String _state = (String) TestClass.excel.getCellData("TestData",21, cell);
		String  _zipCode= (String) TestClass.excel.getCellData("TestData",22, cell);
		String _phone = (String) TestClass.excel.getCellData("TestData", 23, 1);
//			GenericWebDriverFunctions.performAction(StringConstants., element, data)
//			Thread.sleep(1000);
			GenericWebDriverFunctions.performAction(StringConstants.CLICK, editShipping, "");
			
			ValidatorsPage.msg=_state;
			GenericWebDriverFunctions.performAction(StringConstants.CLEAR,shipCity , "");
//			GenericWebDriverFunctions.clearInputFiled();
//			Thread.sleep(1000);
			
			System.out.println(GenericWebDriverFunctions.findElementsByXpath(OrderShippingConstants.CITY));
			billCity =_city;
			GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, shipCity, _city);
			Thread.sleep(1400);
			System.out.println(GenericWebDriverFunctions.findElementsByXpath(OrderShippingConstants.STATE));
			billState=_state;
			GenericWebDriverFunctions.performAction(StringConstants.SELECTVALUE, shipState, _state);
			Thread.sleep(1000);
			
	 
			GenericWebDriverFunctions.performAction(StringConstants.CLEAR, shipCode, "");
		  	
			System.out.println(GenericWebDriverFunctions.findElementsByXpath(OrderShippingConstants.ZIPCODE));
			billZip = _zipCode.replace("-", "");
			GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, shipCode, _zipCode.replace("-", ""));
			
			
			Thread.sleep(4000);
			GenericWebDriverFunctions.scrollToElement(phone);
//			GenericWebDriverFunctions.performAction(StringConstants.CLEAR, phone, "");
			GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, phone, _phone.replace("-", ""));
		 
//		}
		
	}
	
	public static void useMyEntry() throws InterruptedException
	{
		Thread.sleep(1600);
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, useMyEntry, "");
	}
	
	
	public static void validateTax()
	{
		if(shipSameBill.isSelected())
		{
			System.out.println("");
		}
	}
	
	
	
	
	

}
