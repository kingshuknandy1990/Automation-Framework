package com.Pages.AllBealls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.GenericFunctions.WebDriver.GenericWebDriverFunctions;
import com.constants.string.StringConstants;
import com.reports.beallsCustom.CustomReporter;

public class NavigationChecker {

	
	public NavigationChecker(){
		PageFactory.initElements(GenericWebDriverFunctions.driver, this);
	}
	
	public static void topNavigationFormatChecker() throws InterruptedException{
				int index=1;
				WebElement elementName=GenericWebDriverFunctions.findElementsBy("(//a[@class='main-nav-link'])["+index+"]");
				//L1catagoryName=elementName.getText();
				//CustomReporter.startChild("L1 Navigation Check '"+elementName.getText()+"' Catagory", "");
		    	GenericWebDriverFunctions.performAction(StringConstants.MOUSEOVER, elementName, "");
				Thread.sleep(2000);
				int size=GenericWebDriverFunctions.driver.findElements(By.xpath("//div[@class='generivESpot']//div[@class='LeftColumn']//span")).size();
				System.out.println("==="+size);
	}
}
