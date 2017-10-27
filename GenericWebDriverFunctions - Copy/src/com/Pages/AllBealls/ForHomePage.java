package com.Pages.AllBealls;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericFunctions.WebDriver.GenericFunctionsExtra;
import com.GenericFunctions.WebDriver.GenericWebDriverFunctions;
import com.constants.string.ForHomeConstants;
import com.constants.string.StringConstants;
import com.reports.beallsCustom.CustomReporter;

public class ForHomePage {
	
	@FindBy(linkText=ForHomeConstants.FORHOME)
 public static 	WebElement forHome;
	
	@FindAll({@FindBy(xpath = ForHomeConstants.ESPOTP2)})
	public static List <WebElement> eSpotPart2; 
	
	@FindAll({@FindBy(xpath = ForHomeConstants.ESPOTP3)})
	public static List <WebElement> eSpotPart3;
	
	@FindAll({@FindBy(xpath = ForHomeConstants.ESPOTP4_5)})
	public static List <WebElement>  eSpotPart4_5;
	
	@FindBy(xpath=ForHomeConstants.ITEMSINCART)
	public static WebElement itemsInCart;
	
	@FindBy(xpath=ForHomeConstants.WIDTHIMAGE)
	public static WebElement widthImage; 
	
	@FindBy(xpath=ForHomeConstants.BEALLSLOGO)
	public static WebElement beallsLogo;
	
	@FindBy(xpath=ForHomeConstants.LOGOUT)
	public static WebElement logout;
	
	@FindBy(xpath=ForHomeConstants.CHECKOUT)
	public static WebElement checkOut;
	
	@FindBy(xpath=ForHomeConstants.SEARCHBOX)
	public static WebElement searchBox;
	
	@FindAll({@FindBy(xpath=ForHomeConstants.MAINNAV)})
	public static List <WebElement> topNav;
	
	@FindBy(xpath=ForHomeConstants.TOPNAV)
	public static WebElement topNavLinks;
	
	@FindBy(xpath=ForHomeConstants.SIGNUP)
	public static WebElement signUpButton;
	
	@FindBy(xpath=ForHomeConstants.EMAILADD)
	public static WebElement emailField;
	
	@FindBy(xpath=ForHomeConstants.SIGNUPHOLDER)
	public static WebElement signUpHolder; 
	
	@FindBy(xpath=ForHomeConstants.CSPHONE)
	public static WebElement csPhone;
	
	@FindBy(xpath=ForHomeConstants.CSTIMINGS)
	public static WebElement csTimings;
	
	
	@FindBy(xpath=ForHomeConstants.CUSTOMERSERVICEBOX)
	public static WebElement csBox;
	
	@FindBy(xpath=ForHomeConstants.GETHELP)
	public static WebElement getHelp;
	
	@FindBy(xpath=ForHomeConstants.MOREBEALLS)
	public static WebElement moreBealls;
	
	@FindBy(xpath=ForHomeConstants.BFCREDITCARD)
	public static WebElement bfCreditCard;
	
	@FindBy(xpath=ForHomeConstants.SOCIALBOX)
	public static WebElement socialBox;
	
	@FindBy(xpath=ForHomeConstants.FOOTERLINKS)
	public static WebElement footLinks;
	
	@FindBy(xpath=ForHomeConstants.NORTON)
	public static WebElement norton;
	
	@FindBy(xpath=ForHomeConstants.COPYRIGHT)
	public static WebElement copyright;
	
	@FindBy(xpath=ForHomeConstants.logout)
	public static WebElement logoutOther;
	
	@FindBy(xpath=ForHomeConstants.logout)
	public static List <WebElement> logoutOtherlist;
	
	
	public ForHomePage() {
		PageFactory.initElements(GenericWebDriverFunctions.driver,this);
	}
	
	
	public static void validateForHomeESpots()
	{
		
		
		
		
		GenericWebDriverFunctions.performAction(StringConstants.MOUSEOVER, forHome, "");
		try {
			Thread.sleep(400);
		} catch (InterruptedException e1) {
		 
			e1.printStackTrace();
		}
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, forHome, "");
		
		
		ForHomePage obj = new ForHomePage();
		try {
			ForHomePage.validateESpotsPart2();
			ForHomePage.validateESpotsPart3();
			ForHomePage.validateESpotPart4_5();
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
			ForHomePage.itemsPresent(title);
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
	 
 
			ForHomePage.itemsPresent(title);
			GenericWebDriverFunctions.driver.navigate().back();
 
			//lis = GenericWebDriverFunctions.driver.findElements(By.xpath("//div[contains(@class,'Kitchen')]/a/img"));
			lis = eSpotPart3; 
 
		}
		
	 
		
	}
	
	public static void selectMyBag()
	{
	 GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, itemsInCart, "");
	 int count =Integer.parseInt(GenericWebDriverFunctions.getText);
if(count>0)
{
	 GenericWebDriverFunctions.performAction(StringConstants.CLICK, itemsInCart, "");
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
				ForHomePage.itemsPresent(title);
				GenericWebDriverFunctions.driver.navigate().back();
//			 lis = GenericWebDriverFunctions.driver.findElements(By.xpath("//div[contains(@class,'photo')]/a/img"));
				lis= eSpotPart4_5;
		}
		
		if(widthImgPresent())
		{
		WebElement widtImg = widthImage;
		String title = widtImg.getAttribute("title");
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, widtImg, "");
		ForHomePage.itemsPresent(title);
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
	
	public static void logout() throws InterruptedException
	{
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, logout, "");
		Thread.sleep(4000);
		GenericWebDriverFunctions.deleteAllCookies();
		Thread.sleep(4000);
		CustomReporter.userType=" Guest User";
	}
	public static void returnToHomePage() throws InterruptedException
	{
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, beallsLogo, "");
		Thread.sleep(4000);
	}
	
	public static void returnToHomePageextended() throws InterruptedException
	{
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, beallsLogo, "");
		Thread.sleep(2000);
		if(GenericFunctionsExtra.ElementVisibility(logoutOtherlist)){
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, logout, "");
		Thread.sleep(2000);
		}
		GenericWebDriverFunctions.deleteAllCookies();
	}
	
	 public static String getHTMLLink(String href,String name)
	 {
	 return 	 "<a href=\""+href+"\">"+name+"</a>";
	 }
	 
	public static void checkOutHP()
	{
		
		
		 GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, itemsInCart, "");
		 int count =Integer.parseInt(GenericWebDriverFunctions.getText);
	if(count >0)
	GenericWebDriverFunctions.performAction(StringConstants.CLICK, checkOut, "");
	else
	return;
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
	
	
	
	public static void verifyHomePage() throws InterruptedException
	{
		checkCursor();
		checkBeallsLogo();
		checkTopNav();
		checkSignUp();
		checkCustomerService();
		checkGetHelp();
		checkCreditCard();
		checkMoreBealls();
		checkSocialSites();
		checkFooterLinks();
		checkMortonSecured();
		checkCopyright();
		
	}
	
	
	public static void checkCopyright()
	{
		CustomReporter.startChild("Copyright text  verification ", "");
		
		if(GenericWebDriverFunctions.findElementsByXpath(ForHomeConstants.COPYRIGHT)>0)
		{
			CustomReporter.reportChild("PASS", "Copyright text  is present");
			String filePath= GenericWebDriverFunctions.capture(copyright, System.getProperty("user.dir")+"\\utility\\screenshots\\", "copyright.png");
			CustomReporter.addScreenShot(filePath);
		}
		else
		{
			CustomReporter.reportChild("FAIL", "Copyright text  is not present");
			String filePath= GenericWebDriverFunctions.capture(copyright, System.getProperty("user.dir")+"\\utility\\screenshots\\", "copyright.png");
			CustomReporter.addScreenShot(filePath);
		}
		CustomReporter.endChildTest();	
	}
	
	public static void checkMortonSecured()
	{
		CustomReporter.startChild("Norton secured logo section verification ", "");
		
		if(GenericWebDriverFunctions.findElementsByXpath(ForHomeConstants.NORTON)>0)
		{
			CustomReporter.reportChild("PASS", "Norton secured logo is present");
			String filePath= GenericWebDriverFunctions.capture(norton, System.getProperty("user.dir")+"\\utility\\screenshots\\", "norton.png");
			CustomReporter.addScreenShot(filePath);
		}
		else
		{
			CustomReporter.reportChild("FAIL", "Norton secured logo is not present");
			String filePath= GenericWebDriverFunctions.capture(norton, System.getProperty("user.dir")+"\\utility\\screenshots\\", "norton.png");
			CustomReporter.addScreenShot(filePath);
		}
		CustomReporter.endChildTest();
	}
	
	public static void checkFooterLinks()
	{
		CustomReporter.startChild("Footer links section verification ", "");
		if(GenericWebDriverFunctions.findElementsByXpath(ForHomeConstants.SITEMAP)>0 &&
				GenericWebDriverFunctions.findElementsByXpath(ForHomeConstants.SOCIALRESP)>0 && 
				GenericWebDriverFunctions.findElementsByXpath(ForHomeConstants.RETAIL)>0)
		{
			CustomReporter.reportChild("PASS", "All Footer links are present");
			String filePath= GenericWebDriverFunctions.capture(footLinks, System.getProperty("user.dir")+"\\utility\\screenshots\\", "footLinks.png");
			CustomReporter.addScreenShot(filePath);
		}
		else
		{
			CustomReporter.reportChild("FAIL", "All Footer links are not present");
			String filePath= GenericWebDriverFunctions.capture(footLinks, System.getProperty("user.dir")+"\\utility\\screenshots\\", "footLinks.png");
			CustomReporter.addScreenShot(filePath);
		}
		CustomReporter.endChildTest();
	}
	
	
	public static void checkSocialSites()
	{
		CustomReporter.startChild("Social websites section verification ", "");
		if(GenericWebDriverFunctions.findElementsByXpath(ForHomeConstants.FACEBOOK)>0 && 
				GenericWebDriverFunctions.findElementsByXpath(ForHomeConstants.TWITTER)>0 && 
				GenericWebDriverFunctions.findElementsByXpath(ForHomeConstants.YOUTUBE)>0 && 
				GenericWebDriverFunctions.findElementsByXpath(ForHomeConstants.INSTAGRAM)>0 && 
				GenericWebDriverFunctions.findElementsByXpath(ForHomeConstants.GPLUS)>0 && 
				GenericWebDriverFunctions.findElementsByXpath(ForHomeConstants.PINTEREST)>0)
		{
			CustomReporter.reportChild("PASS", "All Social website links are present");
			String filePath= GenericWebDriverFunctions.capture(socialBox, System.getProperty("user.dir")+"\\utility\\screenshots\\", "socialSites.png");
			CustomReporter.addScreenShot(filePath);
		}
		else
		{
			CustomReporter.reportChild("FAIL", "All Social website links are not present");
			String filePath= GenericWebDriverFunctions.capture(socialBox, System.getProperty("user.dir")+"\\utility\\screenshots\\", "socialSites.png");
			CustomReporter.addScreenShot(filePath);
		}
		CustomReporter.endChildTest();
	}
	
	
	public static void checkCreditCard()
	{
		
		CustomReporter.startChild("Credit card section verification ", "");
		
		if(GenericWebDriverFunctions.findElementsByXpath(ForHomeConstants.APPLYNOW)>0 &&
				GenericWebDriverFunctions.findElementsByXpath(ForHomeConstants.CARDIMAGE)>0 && 
				GenericWebDriverFunctions.findElementsByXpath(ForHomeConstants.REWARDS)>0)
		{
			CustomReporter.reportChild("PASS", "All Credit card contents are present");
			String filePath= GenericWebDriverFunctions.capture(bfCreditCard, System.getProperty("user.dir")+"\\utility\\screenshots\\", "bfcreditCard.png");
			CustomReporter.addScreenShot(filePath);
		}
		else
		{
			CustomReporter.reportChild("FAIL", "All Credit card contents are  not present");
			String filePath= GenericWebDriverFunctions.capture(bfCreditCard, System.getProperty("user.dir")+"\\utility\\screenshots\\", "bfcreditCard.png");
			CustomReporter.addScreenShot(filePath);
		}
			
		CustomReporter.endChildTest();
		
	}
	
	public static void checkMoreBealls()
	{
		
		CustomReporter.startChild("More bealls section verification ", "");
		if(GenericWebDriverFunctions.findElementsByXpath(ForHomeConstants.NEWS)>0 && 
				GenericWebDriverFunctions.findElementsByXpath(ForHomeConstants.BEALLSINC)>0 && 
				GenericWebDriverFunctions.findElementsByXpath(ForHomeConstants.ABOUT)>0 &&
				GenericWebDriverFunctions.findElementsByXpath(ForHomeConstants.STORELOCATOR)>0)
		{
			CustomReporter.reportChild("PASS", "All More bealls contents are present");
			String filePath= GenericWebDriverFunctions.capture(moreBealls, System.getProperty("user.dir")+"\\utility\\screenshots\\", "moreBealls.png");
			CustomReporter.addScreenShot(filePath);
		}
		else
		{
			CustomReporter.reportChild("FAIL", "All More bealls contents are  not present");
			String filePath= GenericWebDriverFunctions.capture(moreBealls, System.getProperty("user.dir")+"\\utility\\screenshots\\", "moreBealls.png");
			CustomReporter.addScreenShot(filePath);
		}
		CustomReporter.endChildTest();
	}
	
	public static void checkGetHelp()
	{
		CustomReporter.startChild("Get help section verification ", "");
		if(GenericWebDriverFunctions.findElementsByXpath(ForHomeConstants.CONTACTUS)>0 && 
				GenericWebDriverFunctions.findElementsByXpath(ForHomeConstants.TRACKORDER)>0 &&
				GenericWebDriverFunctions.findElementsByXpath(ForHomeConstants.FAQ)>0 &&
				GenericWebDriverFunctions.findElementsByXpath(ForHomeConstants.RETURNSEXCHANGES)>0 &&
				GenericWebDriverFunctions.findElementsByXpath(ForHomeConstants.SHIPPING)>0)
		{
			CustomReporter.reportChild("PASS", "All Get help contents are present");
			String filePath= GenericWebDriverFunctions.capture(getHelp, System.getProperty("user.dir")+"\\utility\\screenshots\\", "getHelp.png");
			CustomReporter.addScreenShot(filePath);
		}
		else
		{
			CustomReporter.reportChild("FAIL", "All Get help contents are not present");
			String filePath= GenericWebDriverFunctions.capture(getHelp, System.getProperty("user.dir")+"\\utility\\screenshots\\", "getHelp.png");
			CustomReporter.addScreenShot(filePath);
		}
		CustomReporter.endChildTest();
	}
	
	public static void checkCustomerService()
	{
		CustomReporter.startChild("Customer service section verification ", "");
		
		if(GenericWebDriverFunctions.findElementsByXpath(ForHomeConstants.CSPHONE)>0 && 
				GenericWebDriverFunctions.findElementsByXpath(ForHomeConstants.CSTIMINGS)>0)
		{
			CustomReporter.reportChild("PASS", "Customer service phone number and timings are present");
			String filePath= GenericWebDriverFunctions.capture(csBox, System.getProperty("user.dir")+"\\utility\\screenshots\\", "CustomerService.png");
			CustomReporter.addScreenShot(filePath);
		}
		else
			{
			CustomReporter.reportChild("FAIL", "Customer service phone number and timings are not present");
			String filePath= GenericWebDriverFunctions.capture(csBox, System.getProperty("user.dir")+"\\utility\\screenshots\\", "CustomerService.png");
			CustomReporter.addScreenShot(filePath);
		}
		
		CustomReporter.endChildTest();
	}
	public static void checkSignUp()
	{
		CustomReporter.startChild("Sign Up section verification ", "");
		if(GenericWebDriverFunctions.findElementsByXpath(ForHomeConstants.SIGNUP)>0 && GenericWebDriverFunctions.findElementsByXpath(ForHomeConstants.EMAILADD)>0)
		{
			CustomReporter.reportChild("PASS", "Sign Up button and email fields are present");
			String filePath= GenericWebDriverFunctions.capture(signUpHolder, System.getProperty("user.dir")+"\\utility\\screenshots\\", "signUp.png");
			CustomReporter.addScreenShot(filePath);
		}
		else
		{
			CustomReporter.reportChild("FAIL", "Sign up button and email fields are  not present");
			String filePath= GenericWebDriverFunctions.capture(signUpHolder, System.getProperty("user.dir")+"\\utility\\screenshots\\", "signUp.png");
			CustomReporter.addScreenShot(filePath);
			
		}
		
		CustomReporter.endChildTest();
	}
	
	public static void checkCursor() throws InterruptedException
	{
		Thread.sleep(3000);
		CustomReporter.startChild("Cursor verification ", "");
		if(GenericWebDriverFunctions.findElementsByXpath(ForHomeConstants.SEARCHBOX)>0 && searchBox.equals(GenericWebDriverFunctions.driver.switchTo().activeElement()))
		{
			CustomReporter.reportChild("PASS", "Cursor is in search box");
		 
		}
		else
		{
			CustomReporter.reportChild("FAIL", "Cursor is not in search box");
			CustomReporter.addChildInfo("The focus is in "+GenericWebDriverFunctions.driver.switchTo().activeElement().getTagName());
		 
		}
		CustomReporter.endChildTest();
		
	}
	
	public static void checkBeallsLogo() throws InterruptedException
	{
		CustomReporter.startChild("Bealls Logo verification ", "");
		if(GenericWebDriverFunctions.findElementsByXpath(ForHomeConstants.BEALLSLOGO)>0)
		{
			CustomReporter.reportChild("PASS", "Logo is displayed");
		 
			String filePath= GenericWebDriverFunctions.capture(beallsLogo, System.getProperty("user.dir")+"\\utility\\screenshots\\", "beallsLogo.png");
			CustomReporter.addScreenShot(filePath);
		}
		else
		{
			CustomReporter.reportChild("FAIL", "Logo is not displayed");
			String filePath= GenericWebDriverFunctions.capture(beallsLogo, System.getProperty("user.dir")+"\\utility\\screenshots\\", "beallsLogo.png");
			CustomReporter.addScreenShot(filePath);
		}
		CustomReporter.endChildTest();
	}
	
	public static void checkTopNav() throws InterruptedException
	{
		CustomReporter.startChild("Top navigation verification ", "");
		if(GenericWebDriverFunctions.findElementsByXpath(ForHomeConstants.MAINNAV)>0)
		{
			String filePath= GenericWebDriverFunctions.capture(topNavLinks, System.getProperty("user.dir")+"\\utility\\screenshots\\", "Topnav.png");
			CustomReporter.addScreenShot(filePath);
		 
			CustomReporter.reportChild("PASS", "Top nav is present");
			if(topNav.size()>=10 && topNav.size()<=12)
			{
 
				CustomReporter.addChildInfo("Top Nav has "+topNav.size()+ " links");
				System.out.println("There are "+topNav.size()+" top nav links");
				for(int count=0;count<topNav.size();count++)
				{
 				 
//					if(topNav.get(count).getText().isEmpty())
				 CustomReporter.addChildInfo(topNav.get(count).getText()+"--"+getHTMLLink(topNav.get(count).getAttribute("data-href"),topNav.get(count).getText()));
				}
			}
			
				
		}
		else
		{
			CustomReporter.reportChild("FAIL", "Top nav is not present");
		 
		}
		CustomReporter.endChildTest();
		
	}

}
