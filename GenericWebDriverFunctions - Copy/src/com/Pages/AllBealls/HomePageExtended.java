package com.Pages.AllBealls;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.GenericFunctions.WebDriver.GenericWebDriverFunctions;
import com.collection.garbage.Constants;
import com.constants.string.HomePageExtendedConstands;
import com.constants.string.PromotionConstants;
import com.constants.string.StringConstants;
import com.constants.string.TopNavigationConstands;

 public class HomePageExtended {

	@FindBy(xpath=HomePageExtendedConstands.ShoppingBagButton)
	public static WebElement ShoppingBagButton;
	
	@FindBy(xpath=HomePageExtendedConstands.ChecOutButton)
	public static WebElement ChecOutButton;
	
	@FindBy(xpath=HomePageExtendedConstands.Remove)
	public static List <WebElement> RemoveItems;
	
	@FindBy(xpath=HomePageExtendedConstands.Remove)
	public static WebElement RemoveButton;
	
	@FindBy(xpath=PromotionConstants.CheckOutInPDP)
	public static WebElement checkOut;

 public HomePageExtended(){
	PageFactory.initElements(GenericWebDriverFunctions.driver,this);
}

	
	public static void removeFromCart() throws InterruptedException{
		//GenericWebDriverFunctions.driver.findElement(By.xpath("")).click();
		///GenericWebDriverFunctions.performAction(StringConstants.CLICK, checkOut, "");
		
		GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, ShoppingBagButton, "");
		int NoOfItems=Integer.parseInt(GenericWebDriverFunctions.getText);
		if(NoOfItems>0){
			System.out.println("inside =======================");
			GenericWebDriverFunctions.performAction(StringConstants.CLICK, ShoppingBagButton, "");	
			GenericWebDriverFunctions.performAction(StringConstants.CLICK, ChecOutButton, "");
			Thread.sleep(1000);
			for (int i = 1; i <=RemoveItems.size(); i++) {
				System.out.println("removong"+i+"==th item");
				//GenericWebDriverFunctions.performAction(StringConstants.CLICK, RemoveButton, "");
				WebElement ele=GenericWebDriverFunctions.driver.findElement(By.xpath("(//a[contains(text(),'Remove')])["+i+"]"));
				GenericWebDriverFunctions.performAction(StringConstants.CLICK, ele, "");
				//Thread.sleep(1000);
			}
			
			//Thread.sleep(10000);
			ForHomePage.returnToHomePage();
		}
	}

}
