package com.Pages.AllBealls;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericFunctions.WebDriver.GenericWebDriverFunctions;
import com.constants.string.BedAndBathConstants;
import com.constants.string.StringConstants;

public class BedAndBathPage {

	@FindBy(linkText=BedAndBathConstants.BEDANDBATH)
 public static 	WebElement bedAndBath;
	
	@FindAll({@FindBy(xpath = BedAndBathConstants.ESPOTP2)})
	public static List <WebElement> eSpotPart2; 
	
	@FindAll({@FindBy(xpath = BedAndBathConstants.ESPOTP3)})
	public static List <WebElement> eSpotPart3;
	
	@FindAll({@FindBy(xpath = BedAndBathConstants.ESPOTP4_5)})
	public static List <WebElement>  eSpotPart4_5;
	
	
	@FindBy(xpath=BedAndBathConstants.WIDTHIMAGE)
	public static WebElement widthImage; 
	
	
	public   BedAndBathPage() {
	
		PageFactory.initElements(GenericWebDriverFunctions.driver,this);
	}
	
	
	public static void validateBedAndBathESpots()
	{
		
		
		
		
		GenericWebDriverFunctions.performAction(StringConstants.MOUSEOVER, bedAndBath, "");
		try {
			Thread.sleep(400);
		} catch (InterruptedException e1) {
		 
			e1.printStackTrace();
		}
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, bedAndBath, "");
		
		
		BedAndBathPage obj = new BedAndBathPage();
		try {
			BedAndBathPage.validateESpotsPart2();
			BedAndBathPage.validateESpotsPart3();
			BedAndBathPage.validateESpotPart4_5();
		} catch (InterruptedException e) {
			 
			e.printStackTrace();
		}
	
	}
	

	public static void validateESpotsPart2() throws InterruptedException
	{
		 
	 
		List <WebElement> lis = eSpotPart2;
		
		for(int i=0;i<lis.size();i++)
		{
			WebElement el= lis.get(i);
			String title = el.getAttribute("title");
			GenericWebDriverFunctions.performAction(StringConstants.CLICK, el, "");
			BedAndBathPage.itemsPresent(title);
			GenericWebDriverFunctions.driver.navigate().back();
//			lis = GenericWebDriverFunctions.driver.findElements(By.xpath("//div[contains(@id,'page_wrapper')]/div[2]/div/a/img"));
			lis =  eSpotPart2;
		}
		
		 
		
	}
	
	
	
	public static void validateESpotsPart3()
	{
		
		
    List <WebElement> lis = eSpotPart3;
		
		for(int i=0;i<lis.size();i++)
		{
			WebElement el= lis.get(i);
			String title = el.getAttribute("title");
			GenericWebDriverFunctions.performAction(StringConstants.CLICK, el, "");
	 
 
			BedAndBathPage.itemsPresent(title);
			GenericWebDriverFunctions.driver.navigate().back();
 
			//lis = GenericWebDriverFunctions.driver.findElements(By.xpath("//div[contains(@class,'Kitchen')]/a/img"));
			lis = eSpotPart3; 
 
		}
		
	 
		
	}
	
	
	public static void validateESpotPart4_5()
	{
		List <WebElement> lis =eSpotPart4_5;
		
		for(int i=0;i<lis.size();i++)
		{
		 
				WebElement el= lis.get(i);
				String title = el.getAttribute("title");
				GenericWebDriverFunctions.performAction(StringConstants.CLICK, el, "");
				BedAndBathPage.itemsPresent(title);
				GenericWebDriverFunctions.driver.navigate().back();
//			 lis = GenericWebDriverFunctions.driver.findElements(By.xpath("//div[contains(@class,'photo')]/a/img"));
				lis= eSpotPart4_5;
		}
		
		if(widthImgPresent())
		{
		WebElement widtImg = widthImage;
		String title = widtImg.getAttribute("title");
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, widtImg, "");
		BedAndBathPage.itemsPresent(title);
		}
		GenericWebDriverFunctions.driver.navigate().back();
	}
	
	public static void itemsPresent(String title)
	{
		if(GenericWebDriverFunctions.findElementsByXpath("//div[contains(@class,'search-results-container')]/div[1]/div[contains(@class,'item-block')]")>0)
			System.out.println(title+" has items in its results page");
		else
		System.out.println(title+" has no items in its results page");
	}
	
	public static boolean widthImgPresent()
	{
		if(GenericWebDriverFunctions.findElementsByXpath("//div[contains(@class,'FullWidthImg')]/a")>0)
			return true;
		else
			return false;
	}
	
	
	
	//Code for validating the 4th espot  part
	/*public static void validateESpotsPart4()
	{
		
	    List <WebElement> lis = GenericWebDriverFunctions.driver.findElements(By.xpath("//div[contains(@id,'bds_trends')]/div[1]/div[contains(@class,'bds_4x')]/div[1]/a/img"));
		
			for(int i=0;i<lis.size();i++)
			{
			 
					WebElement el= lis.get(i);
					GenericWebDriverFunctions.performAction(StringConstants.CLICK, el, "");
					GenericWebDriverFunctions.driver.navigate().back();
				 lis = GenericWebDriverFunctions.driver.findElements(By.xpath("//div[contains(@id,'bds_trends')]/div[1]/div[contains(@class,'bds_4x')]/div[1]/a/img"));
			}
			
			GenericWebDriverFunctions.driver.navigate().back();

		
	}*/
}
