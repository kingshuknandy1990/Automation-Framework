package com.Pages.AllBealls;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericFunctions.WebDriver.GenericWebDriverFunctions;
import com.constants.string.StringConstants;

public class PopUpPage {

	@FindBy(className=StringConstants.POPUP)
	public static WebElement popUp;
	
	public PopUpPage() {
	 
	PageFactory.initElements(GenericWebDriverFunctions.driver,this);
	}
				
	
	public static void closePopUp()
	{
		if(popUp!=null)
		{
		popUp.click();
		}
	}
	
	
 
}
