package com.Pages.AllBealls;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericFunctions.WebDriver.GenericFunctionsExtra;
import com.GenericFunctions.WebDriver.GenericWebDriverFunctions;
import com.constants.string.OrderSuccessPageConstants;
import com.constants.string.StringConstants;
import com.reports.beallsCustom.CustomReporter;

public class OrderSuccessPage {
	
	@FindBy(xpath=OrderSuccessPageConstants.checkoutTitleBlock)
	static WebElement checkoutTitleBlock;
	
	@FindBy(xpath=OrderSuccessPageConstants.shoppersAccountsection)
	static WebElement shoppersAccountsection;
	
	@FindBy(xpath=OrderSuccessPageConstants.beallsLogoFeild)
	static WebElement beallsLogoFeild;
	
	@FindBy(xpath=OrderSuccessPageConstants.chatLink)
	static WebElement chatLink;
	
	@FindBy(xpath=OrderSuccessPageConstants.customerCareNo)
	static WebElement customerCareNo;
	
	
	@FindBy(xpath=OrderSuccessPageConstants.footerMiddleLinks)
	static WebElement footerMiddleLinks;
	
	@FindBy(xpath=OrderSuccessPageConstants.footerMiddleLinks)
	static List <WebElement> footerMiddleLinkslist;

	@FindBy(xpath=OrderSuccessPageConstants.copyRightFeild)
	static WebElement copyRightFeild;
	
	@FindBy(xpath=OrderSuccessPageConstants.checkoutisSafeAndsecurefeild)
	static WebElement checkoutisSafeAndsecurefeild;
	
	@FindBy(xpath=OrderSuccessPageConstants.emailSA)
	static WebElement emailSA;
	
	@FindBy(xpath=OrderSuccessPageConstants.passSA)
	static List <WebElement> passSA;
	
	@FindBy(xpath=OrderSuccessPageConstants.createAcc)
	static WebElement createAccount;
	
	
	
	public OrderSuccessPage()
	{
		PageFactory.initElements(GenericWebDriverFunctions.driver,this);
	}
	public static void verifyingPageAttributes() throws InterruptedException{
		Thread.sleep(1000);
		if(CustomReporter.currentTestCase.contains("Verifying Page Attributes")){
			GenericFunctionsExtra.parentReportName="Verifying Page Attributes of CheckoutPage";
			GenericFunctionsExtra.parentReportDescription="Page Attributes(Checkout,Shoppers Account Section) are Present in Checkout-Page or not ";
			
		}
		CustomReporter.startChild("Verifying Page attributes of Checkout Pages", "");
		
		try {
			GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, checkoutTitleBlock, "");
			if(GenericWebDriverFunctions.getText.equalsIgnoreCase("checkout")){
				GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, shoppersAccountsection, "");
				
				if(GenericWebDriverFunctions.getText.contains("Shopper Account")){
					
					CustomReporter.addChildInfo(" BeallsFlorida.com Shopper Account Section on Right hand side.");
					CustomReporter.reportChild("pass", "Page Attributes(Checkout,Shoppers Account Section) are Present in respective Pages");
				}else{
					CustomReporter.reportChild("fail", "Page Attributes are not Present in respective Pages");
				}
			}else{
				CustomReporter.reportChild("fail", "Page Attributes are not Present in respective Pages");
			}
			
		} catch (Exception e) {
			CustomReporter.reportChild("fail", "");
		}
		
		CustomReporter.endChildTest();
	}
	
	
	public static void footerVerificationCheckOutPages(){
		String status="pass";
		if(CustomReporter.currentTestCase.contains("Verify the Footer for Checkout Pages")){
			GenericFunctionsExtra.parentReportName="Verify the Footer for Checkout Pages";
			GenericFunctionsExtra.parentReportDescription="In the footer section,all links should be displayed(Live Chat ,Shipping, Returns & Exchanges, Privacy & Security  ,"+
			                    " ,Copyright 2016 Bealls, Inc. All rights reserved, Check out is safe & Secure Message and next to it Norton Secured logo should displayed"+")";
			
		}
		
		CustomReporter.startChild("Verifying  footer Content of Checkout Page is properly displayed or not", "");
		
		try {
		
			if(footerMiddleLinks.isDisplayed()){
				System.out.println("\\"+footerMiddleLinkslist.get(0).getText());
				System.out.println("\\"+footerMiddleLinkslist.get(1).getText());
				System.out.println("\\"+footerMiddleLinkslist.get(2).getText());
				System.out.println("\\"+footerMiddleLinkslist.get(3).getText());
				if(footerMiddleLinkslist.get(0).getText().contains("Live Chat") && footerMiddleLinkslist.get(1).getText().contains("Shipping") && footerMiddleLinkslist.get(2).getText().contains("Returns & Exchanges")  && footerMiddleLinkslist.get(3).getText().contains("Privacy & Security")){
					StringBuffer str=new StringBuffer();
					for (int i = 0; i < footerMiddleLinkslist.size(); i++) {
						str.append(footerMiddleLinkslist.get(i).getText()+ "  , ");
					}
					CustomReporter.addChildInfo(footerMiddleLinks.getText()+" is displayed in the centre of footer section ");
				}else{
					CustomReporter.addChildInfo("'Live Chat Shipping Returns & Exchanges Privacy & Security' is not properly displayed  ");
					status="fail";
				}
			}else{
				CustomReporter.addChildInfo("Footer middle links is not populated");
				status="fail";
			}
			
			if(copyRightFeild.isDisplayed()){
				if(copyRightFeild.getText().contains("Copyright 2016 Bealls") && copyRightFeild.getText().contains("All rights reserved")){
					CustomReporter.addChildInfo(copyRightFeild.getText() +"   is getting displayed");
				}else{
					CustomReporter.addChildInfo("Copyright 2016 Bealls, Inc. All rights reserved   is not getting displayed");
					status="fail";
				}
			}else{
				CustomReporter.addChildInfo("Footer 'Copyright 2016 Bealls, Inc. All rights reserved' is not populated");
				status="fail";
			}
			
			if(checkoutisSafeAndsecurefeild.isDisplayed()){
				if(checkoutisSafeAndsecurefeild.getText().contains("Checkout is")  && checkoutisSafeAndsecurefeild.getText().contains("safe & secure")  ){
					CustomReporter.addChildInfo(checkoutisSafeAndsecurefeild.getText() + "is getting displayed");
				}else{
					CustomReporter.addChildInfo("Footer 'safe & Secure Message'" + "is not getting displayed");
					status="fail";
				}
			}else{
				CustomReporter.addChildInfo("Footer 'safe & Secure Message' is not populated");
				status="fail";
			}
			
			
			
			if(status.contains("fail")){
			CustomReporter.reportChild(status, "Page Footer feilds are not Properly displayed in Checkout Pages.");
			}else{
				CustomReporter.reportChild("pass", "Page Footer feilds are Properly displayed in Checkout Pages.");	
			}
		} catch (Exception e) {
			CustomReporter.reportChild("fail", "Environment error:"+e);
		}
		
		CustomReporter.endChildTest();
	}
	
	public static void headerVerificationCheckOutPages() throws InterruptedException{
		Thread.sleep(1000);
		if(CustomReporter.currentTestCase.contains("Verify the header for Checkout Pages")){
			GenericFunctionsExtra.parentReportName="Verify the header for Checkout Pages";
			GenericFunctionsExtra.parentReportDescription="Checkout Page Headers(Bealls logo,Chat Links & Customer Care No) are Properly displayed or not";
			
		}
		
		CustomReporter.startChild("Verifying Header of Checkout Pages", "");
		
		
		
		try {
		
			if(beallsLogoFeild.isDisplayed()){
				String Logo=beallsLogoFeild.getAttribute("href");
				if(Logo.contains("beallsflorida.com")){
					if(customerCareNo.isDisplayed() && chatLink.isDisplayed()){
						CustomReporter.reportChild("pass", "Checkout Page Headers(Bealls logo,Chat Links & Customer Care No) are Properly displayed ");	
					}else{
						CustomReporter.reportChild("fail", "Chat Links & Customer Care No feilds are not Properly displayed in Checkout Pages.");	
					}
				}else{
					CustomReporter.reportChild("fail", "Page Headers feilds are not Properly displayed in Checkout Pages.");
				}
			}else{
				CustomReporter.reportChild("fail", "Page Headers feilds are not Properly displayed in Checkout Pages."+"Bealls logo feild not visible");
			}
			
		} catch (Exception e) {
			CustomReporter.reportChild("fail", "Environment error:"+e);
		}
		
		CustomReporter.endChildTest();
	}
	
	
	public static void VerifyshoppersAccSec(){
		
		if(CustomReporter.currentTestCase.contains("Verify Shopper Account Section in CheckOutPage")){
			GenericFunctionsExtra.parentReportName="Verify Shopper Account Section in CheckOutPage";
			GenericFunctionsExtra.parentReportDescription="Checkout Page Shopper Account Section(Email , Password ,Confirm Password & Create Account Button Is getting displayed or not)";
			
		}
		
		CustomReporter.startChild("Verify Shopper Account Section", "");
		
		
		
		try {
		
			if(emailSA.isDisplayed() && passSA.get(0).isDisplayed() && passSA.get(1).isDisplayed() && createAccount.isDisplayed() ){
				CustomReporter.reportChild("pass", "Checkout Page Shopper Account Section(Email , Password ,Confirm Password & Create Account Button Is getting displayed");
				
			}else{
				CustomReporter.reportChild("fail", "Checkout Page Shopper Account Section(Email , Password ,Confirm Password & Create Account Button Is not getting displayed");
			}
			
		} catch (Exception e) {
			CustomReporter.reportChild("fail", "Environment error:"+e);
		}
		
		CustomReporter.endChildTest();
	}
	
	
}

