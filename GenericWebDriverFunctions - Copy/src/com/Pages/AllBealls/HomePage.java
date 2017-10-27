package com.Pages.AllBealls;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericFunctions.WebDriver.GenericWebDriverFunctions;
import com.constants.string.HomePageConstants;
import com.constants.string.StringConstants;

public class HomePage {
	
	@FindBy(xpath=HomePageConstants.MYBAG)
	public static WebElement myBag;
	
	@FindBy(xpath=HomePageConstants.CHECKOUT)
	public static WebElement checkOut;
	
	
	public HomePage() {
		PageFactory.initElements(GenericWebDriverFunctions.driver,this);
	}
	
	//To click on the myBag link in home page
	public static void clickOnMyBag()
	{
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, myBag, "");
	}
	
	//To click on expanded checkout button from the myBag link  
	public static void myBagChekcout()
	{
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, checkOut, "");
	}
	

	
}