package com.Pages.AllBealls;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import com.GenericFunctions.WebDriver.GenericWebDriverFunctions;
import com.collection.garbage.Garbage;
import com.constants.string.StringConstants;

public class TopNavPage {
	
 	
	public static List <WebElement> espotPart2=null;
	public static int espotCounter;
	
	
	
	
	
	
	public static void selectTopNav() throws InterruptedException
	{
		WebElement topNav	= GenericWebDriverFunctions.findElementByLinkText("For Home");
		GenericWebDriverFunctions.performAction(StringConstants.MOUSEOVER, topNav, "");
		Thread.sleep(400);
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, topNav, "");
	}
	
	
	
	public static void validateESpotsPart2() throws InterruptedException
	{
		 
	
		TopNavPage.populateEspots();
		espotCounter = TopNavPage.espotPart2.size();
//		 espotPart2 = GenericWebDriverFunctions.driver.findElements(By.xpath("//div[contains(@id,'page_wrapper')]/div[2]/div/a/img"));
		int counter =0;
		  while(counter<espotCounter)
		  {
				WebElement el= espotPart2.get(counter);
				System.out.println("Clicked "+el.getAttribute("title"));
				GenericWebDriverFunctions.performAction(StringConstants.CLICK, el, "");
				Thread.sleep(3000);
				GenericWebDriverFunctions.driver.navigate().back();

				TopNavPage.populateEspots();
			  counter++;
		  }
		  
  
		
		
	 
	
	}
	
	public static void populateEspots()
	{
		espotPart2 = GenericWebDriverFunctions.driver.findElements(By.xpath("//div[contains(@id,'page_wrapper')]/div[2]/div/a/img"));	
	}
	
	

}
