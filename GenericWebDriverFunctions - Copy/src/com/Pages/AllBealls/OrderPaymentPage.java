package com.Pages.AllBealls;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericFunctions.WebDriver.GenericWebDriverFunctions;
import com.classs.usage.TestClass;
import com.constants.string.OrderItemDisplayConstants;
import com.constants.string.OrderPaymentConstants;
import com.constants.string.OrderShippingConstants;
import com.constants.string.StringConstants;
import com.reports.beallsCustom.CustomReporter;

public class OrderPaymentPage {
	
	@FindAll({@FindBy(xpath=OrderPaymentConstants.SUBTOTALS)})
	public static List <WebElement> subTotals;
	
	@FindBy(xpath=OrderPaymentConstants.SUBTOTAL)
	public static WebElement subTotal;
	
	@FindBy(xpath=OrderPaymentConstants.CARDTYPE)
	public static WebElement cardType;
	
	@FindBy(xpath=OrderPaymentConstants.CARDTYPEOPC)
	public static WebElement cardTypeOPC;
	
	
	@FindBy(xpath=OrderPaymentConstants.CARDNUMBER)
	public static WebElement cardNum; 
	
	@FindBy(xpath=OrderPaymentConstants.CARDNUMBEROPC)
	public static WebElement cardNumOpc; 
	
	@FindBy(xpath= OrderPaymentConstants.SECCODE)
	public static WebElement secCode;
	
	@FindBy(xpath= OrderPaymentConstants.SECCODEOPC)
	public static WebElement secCodeOpc;
	
	
	@FindBy(xpath=OrderPaymentConstants.EXPIREMONTH)
	public static WebElement exp_Month;
	
	@FindBy(xpath=OrderPaymentConstants.EXPIREMONTHOPC)
	public static WebElement exp_MonthOpc;
	
	@FindBy(xpath=OrderPaymentConstants.COMPLETEORDER)
	public static WebElement completeOrder;
	@FindBy(xpath=OrderPaymentConstants.EXPIRE_YEAR)
	public static WebElement exp_year;
	@FindBy(xpath=OrderPaymentConstants.EXPIRE_YEAROPC)
	public static WebElement exp_yearOpc;
	
	@FindBy(xpath=OrderPaymentConstants.ESTTAX)
	public static WebElement totalTax;
	
	@FindBy(xpath=OrderPaymentConstants.PROMODISCOUNT)
	public static WebElement promoDiscount;
	
	@FindBy(xpath=OrderPaymentConstants.GIFTWRAP)
	public static WebElement giftWrap;
	
	@FindBy(xpath=OrderShippingConstants.GIFTSUBTOTAL)
	public static WebElement giftSubTotal;
	
	@FindBy(xpath=OrderPaymentConstants.SHIPPINGCOST)
	public static WebElement shippingCost;
	
	@FindBy(xpath=OrderPaymentConstants.FREESHIP)
	public static WebElement freeShipping;
	
	
	@FindBy(xpath=OrderPaymentConstants.SHIPSURCHARGE)
	public static WebElement shipSurCahrge;
	
	public static double tempSubTot;
	
	static {new OrderPaymentPage();}
	
	public OrderPaymentPage() {
		PageFactory.initElements(GenericWebDriverFunctions.driver,this);
	}
	
	
	public static void  validateProductSubTotal_OPP() throws InterruptedException
	{
		
		tempSubTot=0;	
		Thread.sleep(3000);
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
		
		CustomReporter.startChild("Subtotal in Order Payment Page ", "");
		CustomReporter.addChildInfo("Subtotal in Order Payment Page is "+tempSubTot);
		
//		System.out.println("Subtotal in OPP "+tempSubTot);
		if(GenericWebDriverFunctions.findElementsByXpath(OrderPaymentConstants.SUBTOTAL)>0)
		{
		if(fmt.format(tempSubTot).equalsIgnoreCase(subTotal.getText()))
		CustomReporter.reportChild("PASS","Subtotals are same in Order Payment Page" );
//		System.out.println("Subtotals are same in Order Payment Page");
		else
		CustomReporter.reportChild("FAIL","Subtotals are not same in Order Payment Page" );
//		System.out.println("Subtotals are not same in Order Payment Page");
		}
		
		CustomReporter.endChildTest();
	}

	public static void validateAllSubtotal()
	{
		if(OrderPaymentPage.tempSubTot == OrderShippingPage.tempSubTot && OrderShippingPage.tempSubTot == OrderItemDisplayPage.tempSubTot)
			System.out.println("Sub totals are same across Cart Page, Order Payment and Order Shipping Page");
		else
			System.out.println("Sub totals are different across Cart Page, Order Payment and Order Shipping Page");
	
	}
	
	public static void completeOrder()
	{
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, completeOrder, "");
	}
	
	public static void fillCardDetails() throws InterruptedException
	{
		 	
		String cardType = (String) TestClass.excel.getCellData("TestData",15 , 1);
		String cardNumber =(String) TestClass.excel.getCellData("TestData",16 , 1);
		String securityCode = (String) TestClass.excel.getCellData("TestData",17 , 1);
		String expire_Month = (String) TestClass.excel.getCellData("TestData",18 , 1);
		String expire_Year = (String) TestClass.excel.getCellData("TestData",19, 1);
		
 
		Thread.sleep(2500);
		GenericWebDriverFunctions.performAction(StringConstants.SELECTBYVT, OrderPaymentPage.cardType, cardType.trim());
		GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS,OrderPaymentPage.cardNum , cardNumber.replaceAll("-", ""));
		GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS,OrderPaymentPage.secCode ,securityCode.replace("-", "") );
		Thread.sleep(1000);
		GenericWebDriverFunctions.performAction(StringConstants.SELECTINDEX, OrderPaymentPage.exp_Month,expire_Month.replace("-", "") );
		Thread.sleep(1000);
		GenericWebDriverFunctions.performAction(StringConstants.SELECTBYVT, OrderPaymentPage.exp_year,expire_Year.replace("-", "") );
 	 
		
	}
	
	public static void fillCardDetails_OPC() throws InterruptedException
	{
		 	
		String cardType = (String) TestClass.excel.getCellData("TestData",15 , 1);
		String cardNumber =(String) TestClass.excel.getCellData("TestData",16 , 1);
		String securityCode = (String) TestClass.excel.getCellData("TestData",17 , 1);
		String expire_Month = (String) TestClass.excel.getCellData("TestData",18 , 1);
		String expire_Year = (String) TestClass.excel.getCellData("TestData",19, 1);
		
 
		Thread.sleep(2500);
		GenericWebDriverFunctions.performAction(StringConstants.SELECTBYVT, OrderPaymentPage.cardTypeOPC, cardType.trim());
		GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS,OrderPaymentPage.cardNumOpc , cardNumber.replaceAll("-", ""));
		GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS,OrderPaymentPage.secCodeOpc ,securityCode.replace("-", "") );
		Thread.sleep(1000);
		GenericWebDriverFunctions.performAction(StringConstants.SELECTINDEX, OrderPaymentPage.exp_MonthOpc,expire_Month.replace("-", "") );
		Thread.sleep(1000);
		GenericWebDriverFunctions.performAction(StringConstants.SELECTBYVT, OrderPaymentPage.exp_yearOpc,expire_Year.replace("-", "") );
 	 
		
	}
	
	public static void getTaxDetails()
	{
		
		Locale locale = new Locale("en", "US");
		NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
		String estTax="";
		double proSubtotal=0, giftWrapd=0,temp=0,proDiscount=0,shipCost=0,shipSurCharg=0,tax=0;
		
		
		
		if(!totalTax.getText().isEmpty())
		{
			GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, totalTax, "");
			estTax=GenericWebDriverFunctions.getText;
			System.out.println("EST in OPP "+estTax);
		}
		
		
		
		if(!subTotal.getText().isEmpty())
		{
		GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, subTotal, "");
		 
		proSubtotal = Double.parseDouble(GenericWebDriverFunctions.getText.replace("$", ""));
		 
		System.out.println("proSubtotal in OPP"+proSubtotal);
		}
		
		
	 
		if(!promoDiscount.getText().isEmpty())
		{
		GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, promoDiscount, "");
		 
		proDiscount  = Double.parseDouble(GenericWebDriverFunctions.getText.replace("$", ""));
		 
		System.out.println("proDiscount in OPP"+proDiscount);
		}
		
		 
		if(!giftWrap.getText().isEmpty())
		{
		GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, giftWrap, "");
		 giftWrapd= Double.parseDouble(GenericWebDriverFunctions.getText.replace("$", ""));
		System.out.println("gifWrap in OPP"+giftWrapd);
		}
		
		if(!shippingCost.getText().isEmpty())
		{
			
			if(GenericWebDriverFunctions.findElementsByXpath(OrderPaymentConstants.FREESHIP)>0)
			{
				GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, freeShipping, "");
				if(GenericWebDriverFunctions.getText.toLowerCase().contains("free"))
			    System.out.println("Free shipping");	
			}
			else
			{
			GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, shippingCost, "");
			 
			shipCost  = Double.parseDouble(GenericWebDriverFunctions.getText.replace("$", ""));
			 
			System.out.println("shipCost in OPP"+shipCost);
			}
		}
		
		if(!shipSurCahrge.getText().isEmpty())
		{
			GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, shipSurCahrge, "");
			 
			shipSurCharg  = Double.parseDouble(GenericWebDriverFunctions.getText.replace("$", ""));
			 
			System.out.println("shipSurCahrge in OPP"+shipSurCharg);
		}
		
		
		
		switch(OrderShippingPage.billState.toLowerCase())
		{
		//***********Tax calculation for California***********
		case "california":
		if(OrderShippingPage.billCity.toLowerCase().contains("sacremento")
				&& OrderShippingPage.billZip.toLowerCase().contains("94232"))
		{
		temp  = (proSubtotal-proDiscount)+giftWrapd;
		tax =8.5;
		temp = (temp*tax)/100;
		DecimalFormat df=new DecimalFormat("0.00");
		String  roundTemp = df.format(temp);
		temp = Double.parseDouble(roundTemp);
		}	
		//****************************************************
		break;
		
		//***********Tax calculation for Florida**************
		case "florida":
			if(OrderShippingPage.billCity.toLowerCase().contains("yblor")
					&& OrderShippingPage.billZip.toLowerCase().contains("33675"))
			{
			temp  = (proSubtotal-proDiscount)+giftWrapd+shipCost+shipSurCharg;
			tax = 7;
			temp = (temp*tax)/100;
			DecimalFormat df=new DecimalFormat("0.00");
			String  roundTemp = df.format(temp);
			temp = Double.parseDouble(roundTemp);
			}
			
		//****************************************************
			break;
			
		case "new york":
			temp=0;
			break;
	 
		default:
			System.out.println("You have selected an Invalid state "+OrderShippingPage.billState);
	 
			break;
		
	 		
		//***********Tax calculation for New York*************
		//****************************************************
		
		}
		
//		temp = Math.round(temp*100)/100;
		
		
		CustomReporter.startChild("Tax calculation ", "");
		CustomReporter.addChildInfo("tax calculation for state "+OrderShippingPage.billState+" at tax rate of "+tax+" is $"+temp);
		CustomReporter.addChildInfo("Gift wrap charges $"+giftWrapd);
		CustomReporter.addChildInfo("Shipping cost $"+shipCost);
		CustomReporter.addChildInfo("Shipping surcharge $"+shipSurCharg);
		try
		{
			if(GenericWebDriverFunctions.findElementsByXpath(OrderShippingConstants.GIFTSUBTOTAL)>0)
			{
			CustomReporter.addChildInfo("Gift card purchased worth "+giftSubTotal.getText());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
		System.out.println("After rounding up to 2 decplaces "+temp);
		
		double taxDiff = Double.parseDouble(estTax.replace("$", ""))- temp ;
		
		
		
		
		if(taxDiff < 0  || taxDiff > 1.0)
			CustomReporter.reportChild("PASS", "The Tax has not been applied properly");
//			System.out.println("The Tax has not been applied properly");
		else
			CustomReporter.reportChild("PASS", "The Tax has been applied properly");
//			System.out.println("The Tax has been applied properly");
		
		CustomReporter.endChildTest();
			
		
		
	}
	
	
}
