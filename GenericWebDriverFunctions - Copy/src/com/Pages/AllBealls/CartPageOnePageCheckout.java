package com.Pages.AllBealls;

import java.util.List;

import org.eclipse.jdt.internal.compiler.impl.StringConstant;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GenericFunctions.WebDriver.GenericFunctionsExtra;
import com.GenericFunctions.WebDriver.GenericWebDriverFunctions;
import com.classs.usage.TestClass;
import com.constants.string.CartPageOnePageCheckoutConstants;
import com.constants.string.PromotionConstants;
import com.constants.string.StringConstants;
import com.excellibrary.bealls.ExcelLibrary;
import com.reports.beallsCustom.CustomReporter;

public class CartPageOnePageCheckout {
	
	@FindBy(xpath=CartPageOnePageCheckoutConstants.GuestCheckout)
	public static WebElement GuestCheckout;
	
	@FindBy(name =CartPageOnePageCheckoutConstants.First_Name)
	public static WebElement fname;
	
	@FindBy(name =CartPageOnePageCheckoutConstants.First_Name)
	public static List <WebElement> fnamelist;
	
	@FindBy(name =CartPageOnePageCheckoutConstants.Last_Name)
	public static WebElement lname;
	
	@FindBy(name =CartPageOnePageCheckoutConstants.Street_Address)
	public static WebElement addr;
	
	@FindBy(name =CartPageOnePageCheckoutConstants.City)
	public static WebElement city;
		
	
	@FindBy(name =CartPageOnePageCheckoutConstants.StateOption)
	public static WebElement stateOption;
	
	@FindBy(name =CartPageOnePageCheckoutConstants.Zip_Code)
	public static WebElement zippp;
	
	@FindBy(name =CartPageOnePageCheckoutConstants.Phone_Number)
	public static WebElement phone;
	
	@FindBy(name =CartPageOnePageCheckoutConstants.Email_Address)
	public static WebElement email;
	
	@FindBy(xpath =CartPageOnePageCheckoutConstants.useEntry)
	public static WebElement useEntry;
	
	@FindBy(xpath=CartPageOnePageCheckoutConstants.billingaddressfeild)
	public static WebElement billingaddressfeild;
	
	
	@FindBy(xpath =CartPageOnePageCheckoutConstants.continue_to_payment)
	public static WebElement continueToPayment;
	
	//===================================
	
	@FindBy(xpath=CartPageOnePageCheckoutConstants.CardOption)
	public static WebElement CardOption;

	
	@FindBy(xpath=CartPageOnePageCheckoutConstants.CardNo)
	public static WebElement CardNoele; 
	
	@FindBy(xpath= CartPageOnePageCheckoutConstants.Security)
	public static WebElement Securityfeild;
	
	
	@FindBy(xpath=CartPageOnePageCheckoutConstants.ExpiresOn)
	public static WebElement expiresOn;
	
	@FindBy(xpath=CartPageOnePageCheckoutConstants.continue_to_confirm_order)
	public static WebElement continueToConfirmOrder;
	
	@FindBy(xpath=CartPageOnePageCheckoutConstants.Year)
	public static WebElement yearlapse;
	
	
	
	@FindBy(xpath=CartPageOnePageCheckoutConstants.confirmorderMsgFeild)
	public static WebElement confirmorderMsgFeild;
	
	@FindBy(xpath=CartPageOnePageCheckoutConstants.Place_Order_now)
	public static WebElement placeOrderNow;
	
	//=====================
	@FindBy(xpath=CartPageOnePageCheckoutConstants.closesurvey)
	public static WebElement closesurvey;
	
	@FindBy(xpath=CartPageOnePageCheckoutConstants.thankUforshopping)
	public static WebElement thankUforshopping;
	
	
	//==========================================
	//div[@class='row user-welcome']
	@FindBy(xpath=CartPageOnePageCheckoutConstants.userwelcome)
	public static List <WebElement> userwelcomelist;
	
	@FindBy(xpath=CartPageOnePageCheckoutConstants.userwelcome)
	public static WebElement userwelcome;
	
	
	//=======================Edit  option of Accounts Login===================
	
	@FindBy(xpath=CartPageOnePageCheckoutConstants.accountloginEdit)
	public static List <WebElement> accountloginEditlist;
	
	@FindBy(xpath=CartPageOnePageCheckoutConstants.accountloginEdit)
	public static WebElement accountloginEdit;
	
	
	//============================================================
	
	//=======================Edit  option of Shipping & Delivery===================
	
		@FindBy(xpath=CartPageOnePageCheckoutConstants.shippingAndDeliveryEdit)
		public static List <WebElement> shippingAndDeliveryEditlist;
		
		@FindBy(xpath=CartPageOnePageCheckoutConstants.shippingAndDeliveryEdit)
		public static WebElement shippingAndDeliveryEdit;
		
		
		//============================================================
		
		@FindBy(xpath=CartPageOnePageCheckoutConstants.shippingoptionFeild)
		public static WebElement shippingoptionFeild;
		
		//===================================================
		
		@FindBy(xpath=CartPageOnePageCheckoutConstants.accLoginSignIn)
		public static WebElement accLoginSignIn;
		
		@FindBy(xpath=CartPageOnePageCheckoutConstants.accLoginSignInLogon)
		public static WebElement accLoginSignInLogon;
		
		@FindBy(xpath=CartPageOnePageCheckoutConstants.accLoginSignInPass)
		public static WebElement accLoginSignInPass;
		
		@FindBy(xpath=CartPageOnePageCheckoutConstants.accLoginSignInButton)
		public static WebElement accLoginSignInButton;
				
				
				
 
	public CartPageOnePageCheckout(){
		PageFactory.initElements(GenericWebDriverFunctions.driver, this);
	}
	
	public static void checkoutOnePage() throws InterruptedException{
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, GuestCheckout, "");
		AddBillingAddressOnePage();
		 GenericWebDriverFunctions.performAction(StringConstants.CLICK, continueToPayment, "");
		 useEntryOnePageCheckout();
		 addingCardDetailsOnePage();
		 Thread.sleep(2000);
		 GenericWebDriverFunctions.performAction(StringConstants.CLICK, continueToConfirmOrder, "");
		 Thread.sleep(1000);
		 
			 if(GenericWebDriverFunctions.isClickable(placeOrderNow)){
				 GenericWebDriverFunctions.performAction(StringConstants.CLICK, placeOrderNow, ""); 
			 }
		 //GenericWebDriverFunctions.performAction(StringConstants.CLICK, placeOrderNow, "");
	}
	
	
	public static void confirmOrdersectionOnePage() throws InterruptedException{
		CustomReporter.startChild("verification of confirm order section", "");
		 /*GenericWebDriverFunctions.performAction(StringConstants.CLICK, continueToConfirmOrder, "");
		
		 Thread.sleep(3000);
			GenericWebDriverFunctions.scrollToElement(confirmorderMsgFeild);
			GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, confirmorderMsgFeild, "");
			
			System.out.println("====:"+GenericWebDriverFunctions.getText);
			if (GenericWebDriverFunctions.getText.contains("Please confirm the items in your shopping bag and all the information above is correct before placing your order.")) {
			CustomReporter.reportChild("pass", "Proper message is displayed::   "+confirmorderMsgFeild.getText());	
			}else{
				CustomReporter.reportChild("fail", "Proper message is not displayed::   "+confirmorderMsgFeild.getText());	
			}*/
		Thread.sleep(3000);
		 if(GenericWebDriverFunctions.isClickable(placeOrderNow)){
			 GenericWebDriverFunctions.performAction(StringConstants.CLICK, placeOrderNow, "");
			 CustomReporter.reportChild("pass", "Clicked on 'Placed Order Now");	
		 }else{
			 CustomReporter.reportChild("fail","Unable to Click 'Placed Order Now");
		 }
		 CustomReporter.endChildTest();
		 //GenericWebDriverFunctions.performAction(StringConstants.CLICK, placeOrderNow, "");
	}
	public static void continueToPaymentOnePage() throws InterruptedException{
		
		 GenericWebDriverFunctions.performAction(StringConstants.CLICK, continueToPayment, "");
		 useEntryOnePageCheckout();
		
		 //GenericWebDriverFunctions.performAction(StringConstants.CLICK, placeOrderNow, "");
	}
	
	public static void clickOnGuestcheckout() throws InterruptedException{
		
		if(CustomReporter.currentTestCase.contains("Verifying various section of Shopping Cart Page")){
			GenericFunctionsExtra.parentReportName="Verifying various section of Shopping Cart Page";
			GenericFunctionsExtra.parentReportDescription="After clicking on Guest Checkout Button, welcome Guest is getting displayed or not. Verification of One-Page Checkout flow.( Account Login section,Shipping & Delivery,Payment & Billing,Confirm Order)";
			
		}
		CustomReporter.startChild("verification of accounts login  section", "");
		try {
			//=================================
			if(GenericFunctionsExtra.ElementVisibility(accountloginEditlist)){
				GenericWebDriverFunctions.performAction(StringConstants.CLICK, accountloginEdit, "");
				Thread.sleep(1000);
			}
			
			//=================================
			GenericWebDriverFunctions.performAction(StringConstants.CLICK, GuestCheckout, "");
			if(GenericFunctionsExtra.ElementVisibility(userwelcomelist)){
				String str=userwelcome.getText();
				if(str.contains("Welcome, Guest")){
					CustomReporter.reportChild("pass", "After clicking on Guest Checkout Button, welcome Guest is getting displayed");
				}else{
					CustomReporter.reportChild("fail", "After clicking on Guest Checkout Button, welcome Guest is not getting displayed");
				}
			}else{
				CustomReporter.reportChild("fail", "After clicking on Guest Checkout Button, welcome Guest is not getting displayed");
			}
		} catch (Exception e) {
			CustomReporter.reportChild("fail", "Error occured while executing Test cases"+e);
		}
		CustomReporter.endChildTest();
	}
	
	public static void VerifyOrderStatus(){
		if(CustomReporter.currentTestCase.contains("Complete flow guest user One Page Check out")){
			GenericFunctionsExtra.parentReportName="Complete Critical Path As Guest User";
			GenericFunctionsExtra.parentReportDescription="Adding product to cart,Checking out as guest,and placing the Order";
			
		}
		
		CustomReporter.startChild("Verification of Order", "Checking status wether order is placed or not");
	try {
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, closesurvey, "");
		GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, thankUforshopping, "");
		String thanku=GenericWebDriverFunctions.getText;
		if(thanku.contains("Thank you for shopping")){
			CustomReporter.reportChild("pass", "Order is Successfully placed");
		}else{
			CustomReporter.reportChild("fail", "Unable to place order");
		}
	} catch (Exception e) {
		CustomReporter.reportChild("fail", "Ëxception Occured:"+e);
	}
		CustomReporter.endChildTest();
	}
	public static void AddBillingAddressOnePage() throws InterruptedException{

		Thread.sleep(3000);
/*		if(GenericFunctionsExtra.ElementVisibility(EditAddress)){
			EditAddressFlag=1;
		}else{
			EditAddressFlag=2;*/
			 CustomReporter.startChild("Adding Billing Address", "");
			 
		    
			try {
				if(GenericFunctionsExtra.ElementVisibility(shippingAndDeliveryEditlist)){
					GenericWebDriverFunctions.performAction(StringConstants.CLICK, shippingAndDeliveryEdit, "");
					Thread.sleep(1000);
					GenericWebDriverFunctions.performAction(StringConstants.SELECTVALUE, shippingoptionFeild, "-1");
					Thread.sleep(1000);
				}
				
				if (fname.getText().isEmpty() && lname.getText().isEmpty() && addr.getText().isEmpty() && city.getText().isEmpty() &&
					zippp.getText().isEmpty() && phone.getText().isEmpty() && email.getText().isEmpty()	) 
				{
					CustomReporter.addChildInfo("All the feilds are initially empty");
				} else{
					CustomReporter.addChildInfo("All the feilds are not initially empty");
				}
				
				
				ExcelLibrary exe=new ExcelLibrary(PromotionConstants.filepath);
				String FirstName=(String) exe.getCellData(PromotionConstants.TestData, PromotionConstants.FirstNameRow, PromotionConstants.cellno);
			    String LastName=(String) exe.getCellData(PromotionConstants.TestData, PromotionConstants.LastNameRow, PromotionConstants.cellno);
			    String StreetAddress=(String) exe.getCellData(PromotionConstants.TestData, PromotionConstants.StreetAddressRow, PromotionConstants.cellno);
			    String City=(String) exe.getCellData(PromotionConstants.TestData, PromotionConstants.CityRow, PromotionConstants.cellno);
			    String State=(String) exe.getCellData(PromotionConstants.TestData, PromotionConstants.StateRow, PromotionConstants.cellno);
			   
			    Double Zip=(Double) exe.getCellData(PromotionConstants.TestData,PromotionConstants.ZipRow , PromotionConstants.cellno);
				String v = Zip.toString().trim();
				String ZipCode=v.substring(0, v.indexOf("."));
			    
				Long Phone=Double.valueOf( exe.getCellData(PromotionConstants.TestData, PromotionConstants.PhoneRow, 1).toString()).longValue();
				String PhoneNo=Phone.toString();
				
				String Email=(String) exe.getCellData(PromotionConstants.TestData, PromotionConstants.EmailRow, PromotionConstants.cellno);

				GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, fname, FirstName);
				GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, lname, LastName);
				GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, addr, StreetAddress);


				
				GenericWebDriverFunctions.scrollToElement(city);
				GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, city, City);
				
				
				GenericWebDriverFunctions.performAction(StringConstants.SELECTBYVT, stateOption, State);
				GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, zippp, ZipCode);
				
				GenericWebDriverFunctions.scrollToElement(phone);
				GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, phone, PhoneNo);
				//if(email.getText().isEmpty()){
					email.clear();
					GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, email, Email);
				//}
				
				
				String str= "<br>"+"Name:     "+FirstName+"\t"+LastName+
					    "<br>"+"Address:  "+StreetAddress+"\t"+","+"\t"+State+","+City+"-"+Zip+
					    "<br>"+"Phone No: "+PhoneNo+
					    "<br>"+"Email   : "+Email
					;
				CustomReporter.reportChild("pass", "Billing Address Added successfully");
				CustomReporter.addChildInfo(str);
			} catch (Exception e) {
				CustomReporter.reportChild("fail", "Unable to add Billing Address");
			}
			CustomReporter.endChildTest();
		}
	public static void useEntryOnePageCheckout() throws InterruptedException{
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, useEntry, "");
		Thread.sleep(3000);
	}
	
	public static void addingCardDetailsOnePage(){
		
		 CustomReporter.startChild("Adding Card Details", "");
	     WebDriverWait   wait = new WebDriverWait(GenericWebDriverFunctions.driver, 9);	
    	
	     
    	
	try {
		
		if (CardNoele.getText().isEmpty() && Securityfeild.getText().isEmpty() ) {
			CustomReporter.addChildInfo("All the feilds are empty in Card details section");
		} else {
			CustomReporter.addChildInfo("All the feilds are not empty in Card details section");
		}
		ExcelLibrary exe=new ExcelLibrary(PromotionConstants.filepath);
	    String CardType=(String) exe.getCellData(PromotionConstants.TestData, PromotionConstants.CardTypeRow, PromotionConstants.cellno);
	    Long CardNumber=Double.valueOf( exe.getCellData(PromotionConstants.TestData, PromotionConstants.CardNumberRow, PromotionConstants.cellno).toString()).longValue();
		String CardNo=CardNumber.toString();
	    
	    
		Double Security11=(Double) exe.getCellData(PromotionConstants.TestData, PromotionConstants.Security11Row, PromotionConstants.cellno);
		String sec = Security11.toString().trim();
	
		String Security=sec.substring(0, sec.indexOf("."));
		
	    String ExpiresOn=(String) exe.getCellData(PromotionConstants.TestData, PromotionConstants.ExpiresOnRow, PromotionConstants.cellno);
	  
	    
	    Double Year11=(Double) exe.getCellData(PromotionConstants.TestData, PromotionConstants.Year11Row, PromotionConstants.cellno);
	    String ye = Year11.toString().trim();
		
	    String Year=ye.substring(0, ye.indexOf("."));
		

		Thread.sleep(2500);

		GenericWebDriverFunctions.performAction(StringConstants.SELECTBYVT, CardOption, CardType.trim());
		
		
		GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, CardNoele, CardNo);
		GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, Securityfeild, Security);
		Thread.sleep(1000);
		GenericWebDriverFunctions.performAction(StringConstants.SELECTVALUE, expiresOn, ExpiresOn);
		Thread.sleep(1000);
		GenericWebDriverFunctions.performAction(StringConstants.SELECTVALUE, yearlapse, Year);
		GenericWebDriverFunctions.performAction(StringConstants.SELECTVALUE, billingaddressfeild, "same");
		
		CustomReporter.reportChild("pass", "Card details Added Successfully");
		
		String str11= "<br>"+"Type of Card: "+CardType+"\t"+
			    "<br>"+"Card No     : "+CardNo+"\t"+
			    "<br>"+"Security    : "+Security11+
			    "<br>"+"Expires On  : "+ExpiresOn+
			    "<br>"+"Year  		: "+Year11
		;
	CustomReporter.addChildInfo(str11);
	} catch (Exception e) {
		CustomReporter.reportChild("fail", "Unable to add Card Details");
		CustomReporter.addChildInfo("Error::"+e);
	}
	
	CustomReporter.endChildTest();
	}
	
/*	public static void clickOnsignInOnePage(){

	System.out.println("inside clickOnsignInOnePage=================");
		 if(CustomReporter.currentTestCase.contains("Verification of SignIn option in Shopping Cart Page")){
				GenericFunctionsExtra.parentReportName="Verification of SignIn option in the Accounts Login section of Shopping Cart Page";
				GenericFunctionsExtra.parentReportDescription="After giving a proper email Id and password and clicking  on 'Sign-In & Checkout button' user should be taken to payment and billing section ";
				
			}
		 CustomReporter.startChild("Accounts Login section  SignIn option verification", "");
	try {
		String email=(String) TestClass.excel.getCellData("TestData", 2, 1);
		String pass=(String) TestClass.excel.getCellData("TestData", 3, 1);
		String print="Email Address:"+email+"<br>"+
				 "Password     :"+pass;
		CustomReporter.addChildInfo(print);
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, accLoginSignIn,"" );
		GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, accLoginSignInLogon, email);
		
		GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, accLoginSignInPass, pass);
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, accLoginSignInButton, "");
		CustomReporter.addChildInfo("'Sign-In & Checkout button' was successfully clicked");
		Thread.sleep(3000);
		
		if(GenericFunctionsExtra.ElementVisibility(fnamelist)){
			CustomReporter.reportChild("pass", "Landed To Shipping & Delivery Section");
		}else{
			CustomReporter.reportChild("fail", "Did not land in Shipping & Delivery Section");
		}
		

	
	} catch (Exception e) {
		CustomReporter.reportChild("fail", "Unable to add Card Details");
		CustomReporter.addChildInfo("Error::"+e);
	}
	
	CustomReporter.endChildTest();
	System.out.println("Ending===================");
		
	}*/
	
	



public static void SignInOptionClickinOnePage(){
	
	if(CustomReporter.currentTestCase.contains("Accounts Login section  SignIn option verification")){
		GenericFunctionsExtra.parentReportName="Verification of SignIn option in the Accounts Login section of Shopping Cart Page";
		
		GenericFunctionsExtra.parentReportDescription="After giving a proper email Id and password and clicking  on Sign-In & Checkout button user should be taken to payment and billing section";
		
	}
	
	if(CustomReporter.currentTestCase.contains("Complete flow as Sign In User")){
		GenericFunctionsExtra.parentReportName="Verification of SignIn option in the Accounts Login section of Shopping Cart Page, and placing a order(Complete flow)";
		
		GenericFunctionsExtra.parentReportDescription="Searching an item,adding the item from QV,Secure checkout,clicking Sign-In Option,and Placing an order as Registered user";
		
	}
	
	CustomReporter.startChild("Accounts Login section  SignIn option verification", "");
	
	
	
		try {
			if(GenericFunctionsExtra.ElementVisibility(accountloginEditlist)){
				GenericWebDriverFunctions.performAction(StringConstants.CLICK, accountloginEdit, "");
				Thread.sleep(1000);
			}
			String email=(String) TestClass.excel.getCellData("TestData", 2, 1);
			String pass=(String) TestClass.excel.getCellData("TestData", 3, 1);
			String print11="Email Address:"+email+"<br>"+
					 "Password     :"+pass;
			CustomReporter.addChildInfo(print11);
			GenericWebDriverFunctions.performAction(StringConstants.CLICK, accLoginSignIn,"" );
			GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, accLoginSignInLogon, email);
			
			GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, accLoginSignInPass, pass);
			GenericWebDriverFunctions.performAction(StringConstants.CLICK, accLoginSignInButton, "");
			CustomReporter.addChildInfo("Sign-In & Checkout button was successfully clicked");
			Thread.sleep(3000);
			
			if(GenericFunctionsExtra.ElementVisibility(fnamelist)){
				System.out.println("yess------------------");
				CustomReporter.reportChild("pass", "Landed To Shipping & Delivery Section");
			}else{
				System.out.println("no------------------");
				CustomReporter.reportChild("fail", "Did not land in Shipping & Delivery Section");
//				if(){
//					
//				}else{
//					
//				}
			}	
		} catch (Exception e) {
				CustomReporter.reportChild("fail", "Environment error:"+e);
				//CustomReporter.reportChild("fail", "Unable to add Card Details");
				
			}
	
		CustomReporter.endChildTest();
	}


}


