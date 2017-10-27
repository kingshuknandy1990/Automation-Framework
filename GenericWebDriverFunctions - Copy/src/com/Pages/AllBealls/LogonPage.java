package com.Pages.AllBealls;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericFunctions.WebDriver.GenericWebDriverFunctions;
import com.classs.usage.TestClass;
import com.constants.string.LogonConstants;
import com.constants.string.StringConstants;
import com.reports.beallsCustom.CustomReporter;

public class LogonPage {

	@FindBy(xpath=LogonConstants.SIGNINOPC)
	public static WebElement SIGNIN;
	
	@FindBy(xpath=LogonConstants.SIGNIN)
	public static WebElement SignInHp;
	
	@FindBy(name=LogonConstants.EADDRESS)
	public static WebElement EADDRESS;
	
	@FindBy(name=LogonConstants.PASSWORD)
	public static WebElement PASSWORD;
	
	@FindBy(xpath=LogonConstants.LOGIN)
	public static WebElement LOGIN;
	
	@FindBy(xpath=LogonConstants.LOGINOPC)
	public static WebElement loginOPC;
	
	static { new LogonPage();}
	
	
	public LogonPage() {
		PageFactory.initElements(GenericWebDriverFunctions.driver, this);
		
	}
	
	
	public static void clickSignIn()
	{
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, SIGNIN, "");
		
	}
	
	public static void clickSignInHP()
	{
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, SignInHp, "");
	}
	
	
	public static void login() throws InterruptedException
	{

		CustomReporter.userType=" Registered User";
		String email = (String) TestClass.excel.getCellData("TestData",13 , 1);
		String password = (String) TestClass.excel.getCellData("TestData",14 , 1);
		GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, EADDRESS, email);
		GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, PASSWORD, password);
		
		if(GenericWebDriverFunctions.findElementsByXpath(LogonConstants.LOGIN)>0)
			GenericWebDriverFunctions.performAction(StringConstants.CLICK,LOGIN, "");
		else
		GenericWebDriverFunctions.performAction(StringConstants.CLICK,loginOPC, "");
		Thread.sleep(2000);
		
	}

	
	
}
