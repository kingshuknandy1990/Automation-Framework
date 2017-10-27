package com.collection.garbage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GenericFunctions.WebDriver.GenericWebDriverFunctions;
import com.Pages.AllBealls.PopUpPage;
import com.constants.string.StringConstants;

public class Garbage {

//	Method[] ar=	cls.getDeclaredMethods();
//	for(int counter=0;counter<ar.length;counter++)
//	{
//		Class params[] =ar[counter].getParameterTypes();
//		for(int innCounter=0;innCounter<params.length;innCounter++)
//		{
//		System.out.println(params[innCounter]);
//		}
//	}
	static public WebDriver firefox ;
	static public 	WebDriverWait wait ;
	static public List <WebElement> elements;
	static public List <WebElement> leftNavElements ;
	public static PopUpPage pup = null;
	public static void main(String[] args) throws InterruptedException {
		
//	 System.setProperty("webdriver.chrome.driver", System.getProperty("user"));
		
//		firefox = new FirefoxDriver();
//		firefox.manage().window().maximize();
//		firefox.get("http://beallsflorida.com");
		
		
		GenericWebDriverFunctions.loadDriver("firefox");
		GenericWebDriverFunctions.startServer("http://beallsflorida.com");
//		GenericWebDriverFunctions.driver.get("http://beallsflorida.com");
	//	pup = new PopUpPage();
//		Garbage.selectTopNav();
		
		Garbage.validateTopNav();
 

		 
		 
		GenericWebDriverFunctions.driver.quit();
 
		
 
		
	}
	
	public static void selectTopNav() throws InterruptedException
	{
		WebElement topNav	= GenericWebDriverFunctions.findElementByLinkText("For Home");
		GenericWebDriverFunctions.performAction(StringConstants.MOUSEOVER, topNav, "");
		Thread.sleep(400);
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, topNav, "");
	}
	
	public static boolean validateString(String textContent,String comparator)
	{
		textContent = textContent.toLowerCase();
		comparator = comparator.toLowerCase();
		return comparator.contains(textContent);
	}
	
	
	
	public static void validateTopNav( ) throws InterruptedException
	{  
		wait=new WebDriverWait(GenericWebDriverFunctions.driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@class='main-nav primary']/a")));
		elements = GenericWebDriverFunctions.driver.findElements(By.xpath("//nav[@class='main-nav primary']/a"));


		for(int i=2;i<elements.size();i++)
		{
			 
		WebElement element =  elements.get(i);
		 
	
		if(element.isDisplayed())
		{
		GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, element, "");
		String topNavText = GenericWebDriverFunctions.getText;
		GenericWebDriverFunctions.performAction(StringConstants.MOUSEOVER, element, "");
		Thread.sleep(4000);
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, element, "");

		
		
		
//		if(topNavText ==null || topNavText.isEmpty())
//		{
//		System.out.println("No Top navigation ");
//		}
//		else
//		{
//			WebElement  elem= wait.until(ExpectedConditions.visibilityOf(GenericWebDriverFunctions.driver.findElement(By.xpath("//h1"))));
//			GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, elem, "");
//			String comparator =  GenericWebDriverFunctions.getText;
//			if(topNavText.contains(" "))
//			{
//				int count=0;
//				
//
//				String ar []  = topNavText.split(" ");
//				for(int counter =0 ;counter<ar.length;counter++)
//				{
//				if(Garbage.validateString(ar[counter],comparator))
//				{
//				System.out.println(topNavText +" L1 Category  has a proper landing page");
////				break;
//				}
//				else
//				{
//				count++;
//				}
//				}
//				
//				if(count == ar.length)
//				{
//					System.out.println(topNavText+" L1 Category doesn't have a proper landing page");
//				}
//			}
//			else
//			{
//				if (Garbage.validateString(topNavText,comparator))
//				{
//					System.out.println(topNavText +" L1 Category  has a proper landing page");
//				}
//				else
//				{
//					System.out.println(topNavText+" L1 Category doesn't have a proper landing page");
//				}
//			}
//		
////			Garbage.validateSubCat();
//		}
//		
		
//		Garbage.validateImgScroller();
//		Garbage.validateESpotsPart2();
//		Garbage.validateESpotsPart3();
//		Garbage.validateESpotPart5();
		
		wait=new WebDriverWait(GenericWebDriverFunctions.driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@class='main-nav primary']/a")));
		elements = GenericWebDriverFunctions.driver.findElements(By.xpath("//nav[@class='main-nav primary']/a"));
		break;
		}
	 
	}
	}
	
	
	public static void validateImgScroller()
	{
		
		List <WebElement> lis = GenericWebDriverFunctions.driver.findElements(By.xpath("//ul[contains(@id,'scroller')]/span"));
		
		for (int i = 0; i < lis.size(); i++) {
			
			WebElement scrollImg = GenericWebDriverFunctions.driver.findElement(By.xpath("//div[contains(@class,'cycle-slide-active')]/a/img"));
			if(lis.get(i).isSelected())
			{
			
				String title = scrollImg.getAttribute("title");
				GenericWebDriverFunctions.performAction(StringConstants.CLICK, scrollImg, "");
				Garbage.itemsPresent(title);
			}
			else
			{
				GenericWebDriverFunctions.performAction(StringConstants.CLICK, lis.get(i), "");
				String title = scrollImg.getAttribute("title");
				GenericWebDriverFunctions.performAction(StringConstants.CLICK, scrollImg, "");
				Garbage.itemsPresent(title);
			}
			
				GenericWebDriverFunctions.driver.navigate().back();
		 
			 lis = GenericWebDriverFunctions.driver.findElements(By.xpath("//ul[contains(@id,'scroller')]/span"));	
		}
		
	}
	
	
	public static void validateESpotsPart2() throws InterruptedException
	{
		 
	 
		List <WebElement> lis = GenericWebDriverFunctions.driver.findElements(By.xpath("//div[contains(@id,'page_wrapper')]/div[2]/div/a/img"));
		
		for(int i=0;i<lis.size();i++)
		{
			WebElement el= lis.get(i);
			String title = el.getAttribute("title");
			GenericWebDriverFunctions.performAction(StringConstants.CLICK, el, "");
			Garbage.itemsPresent(title);
			GenericWebDriverFunctions.driver.navigate().back();
			lis = GenericWebDriverFunctions.driver.findElements(By.xpath("//div[contains(@id,'page_wrapper')]/div[2]/div/a/img"));
		}
		
		 
		
	}
	
	
	public static void validateESpotsPart4()
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

		
	}
	
	public static void validateESpotPart5()
	{
		List <WebElement> lis = GenericWebDriverFunctions.driver.findElements(By.xpath("//div[contains(@class,'photo')]/a/img"));
		
		for(int i=0;i<lis.size();i++)
		{
		 
				WebElement el= lis.get(i);
				String title = el.getAttribute("title");
				GenericWebDriverFunctions.performAction(StringConstants.CLICK, el, "");
				Garbage.itemsPresent(title);
				GenericWebDriverFunctions.driver.navigate().back();
			 lis = GenericWebDriverFunctions.driver.findElements(By.xpath("//div[contains(@class,'photo')]/a/img"));
		}
		
		if(GenericWebDriverFunctions.findElementsByXpath("//div[contains(@class,'FullWidthImg')]/a")>0)
		{
		WebElement widtImg = GenericWebDriverFunctions.driver.findElement(By.xpath("//div[contains(@class,'FullWidthImg')]/a"));
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, widtImg, "");
		}
		GenericWebDriverFunctions.driver.navigate().back();
	}
	public static void validateESpotsPart3()
	{
		
		
    List <WebElement> lis = GenericWebDriverFunctions.driver.findElements(By.xpath("//div[contains(@class,'Kitchen')]/a/img"));
		
		for(int i=0;i<lis.size();i++)
		{
			WebElement el= lis.get(i);
			String title = el.getAttribute("title");
			GenericWebDriverFunctions.performAction(StringConstants.CLICK, el, "");
	 
 
			Garbage.itemsPresent(title);
			GenericWebDriverFunctions.driver.navigate().back();
 
			lis = GenericWebDriverFunctions.driver.findElements(By.xpath("//div[contains(@class,'Kitchen')]/a/img"));
			
 
		}
		
	 
		
	}
	
	
	public static void itemsPresent(String title)
	{
		if(GenericWebDriverFunctions.findElementsByXpath("//div[contains(@class,'search-results-container')]/div[1]/div[contains(@class,'item-block')]")>0)
			System.out.println(title+" has items in its results page");
		else
		System.out.println(title+" has no items in its results page");
	}
	
	
	
	
	public static void validateEspotLanding(String title)
	{
		
		wait =  new WebDriverWait(GenericWebDriverFunctions.driver, 10);
		WebElement  elem= wait.until(ExpectedConditions.visibilityOf(GenericWebDriverFunctions.driver.findElement(By.xpath("//h1"))));
		GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, elem, "");
		String comparator =  GenericWebDriverFunctions.getText;
	 
		if(title.contains(" "))
		{
			int count=0;
			

			String ar []  = title.split(" ");
			for(int counter =0 ;counter<ar.length;counter++)
			{
			if(Garbage.validateString(ar[counter],comparator))
			{
			System.out.println(title +"  has a proper landing page");
			 
			break;
			}
			else
			{
			count++;
			}
			}
			
			if(count == ar.length)
			{
				System.out.println(title+"   doesn't have a proper landing page");
			}
		}
		else
		{
			if (Garbage.validateString(title,comparator))
			{
				System.out.println(title +"    has a proper landing page");
			 
			}
			else
			{
				System.out.println(title+"   doesn't have a proper landing page");
			}
		}
		
	}
	
	
	
	
	public static void validateESpotsPart1() throws InterruptedException

	{
		
		
		
		
		wait = new WebDriverWait(GenericWebDriverFunctions.driver, 10);
		WebElement ele = wait.until(ExpectedConditions.visibilityOf( GenericWebDriverFunctions.driver.findElement(By.xpath("//ul[contains(@id,'scroller_pager')]/span"))));
	    
		List<WebElement> ulList =   GenericWebDriverFunctions.driver.findElements(By.xpath("//ul[contains(@id,'scroller_pager')]/span"));
//		List <WebElement> spots = GenericWebDriverFunctions.driver.findElements(By.xpath("//div[contains(@id,'scroller')]/div/a/img"));
		
		WebElement scrollImage=wait.until(ExpectedConditions.visibilityOf( GenericWebDriverFunctions.driver.findElement(By.xpath("//div[contains(@id,'main_scroller')]/div[3]/a"))));
//		 = GenericWebDriverFunctions.driver.findElement(By.xpath("//div[contains(@id,'main_scroller')]/div[3]/a"));
		
		int counter =0;
		
		System.out.println(ulList.size());

		while(counter <ulList.size())
		{
		ulList.get(counter).click();
		scrollImage.click();
		counter++;
		GenericWebDriverFunctions.driver.navigate().back();
		
		
		wait = new WebDriverWait(GenericWebDriverFunctions.driver, 10);
		  ele = wait.until(ExpectedConditions.visibilityOf( GenericWebDriverFunctions.driver.findElement(By.xpath("//ul[contains(@id,'scroller_pager')]/span"))));
	  ulList =   GenericWebDriverFunctions.driver.findElements(By.xpath("//ul[contains(@id,'scroller_pager')]/span"));
	      scrollImage=wait.until(ExpectedConditions.visibilityOf( GenericWebDriverFunctions.driver.findElement(By.xpath("//div[contains(@id,'main_scroller')]/div[3]/a"))));
		}
		
 		
//		System.out.println(spots.size());
//		
//		
//	
//		for(int i=2,spanCount=1;i<=spots.size();i++,spanCount++)
//		{
// 
//			 
//			
//			WebElement ul = GenericWebDriverFunctions.findElementsBy("//ul[contains(@id,'scroller')]/span["+spanCount+"]");
//			if(!ul.isSelected())
//			GenericWebDriverFunctions.performAction(StringConstants.CLICK, ul, "");
////		System.out.println(GenericWebDriverFunctions.driver.findElement(By.xpath("//div[contains(@id,'scroller')]/div["+i+"]/a/img")).getAttribute("title"));			
//
//			WebElement element  = GenericWebDriverFunctions.findElementsBy("//div[contains(@id,'scroller')]/div["+i+"]/a/img");
//			System.out.println("Clicked "+element.getAttribute("title"));	
//			GenericWebDriverFunctions.performAction(StringConstants.CLICK,element ,"");
//
// 
//			GenericWebDriverFunctions.driver.navigate().back();
//			spots =  GenericWebDriverFunctions.driver.findElements(By.xpath("//div[contains(@id,'scroller')]/div"));
//			System.out.println(spots.size());
////			Garbage.selectTopNav();
////			Thread.sleep(millis)
//		}
		

		
	}
	
	public static void gotoSubCatPage()
	{
		if(GenericWebDriverFunctions.findElementsByXpath("(//a[contains(@id,'show-more')])[1]")>0)
		{
		WebElement eleme =  GenericWebDriverFunctions.driver.findElement(By.xpath("(//a[contains(@id,'show-more')])[1]"));
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, eleme, "");
		}
		
		
		Garbage.leftNavElements= GenericWebDriverFunctions.driver.findElements(By.xpath("//div[@class='left-nav']/div[1]/div/a"));
		List <WebElement> list2= GenericWebDriverFunctions.driver.findElements(By.xpath("//div[@class='left-nav']/div[1]/div/div/a"));
		Garbage.leftNavElements.addAll(list2);
		System.out.println(Garbage.leftNavElements.size());
	}
	
	
	
	
	public static void validateSubCat() throws InterruptedException
	{

		leftNavElements= GenericWebDriverFunctions.driver.findElements(By.xpath("//div[@class='left-nav']/div[1]/div/a"));
//		List <WebElement> list2= GenericWebDriverFunctions.driver.findElements(By.xpath("//div[@class='left-nav']/div[1]/div/div/a"));
//		leftNavElements.addAll(list2);
	 
//		leftNavElements.remove(leftNavElements.size()-1);
//		List <WebElement> tempLeftNav  = leftNavElements; 
		for(int i=8;i< leftNavElements.size();i++)
		{
			
			WebElement element =   leftNavElements.get(i);
			 System.out.println(element.getText());
			if(GenericWebDriverFunctions.findPopUpBy(StringConstants.POPUP)>0)
			PopUpPage.popUp.click();
			
			GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, element, "");
			String leftNavText = GenericWebDriverFunctions.getText;
	 
			GenericWebDriverFunctions.performAction(StringConstants.CLICK, element, "");

			
			
			
			if(leftNavText ==null || leftNavText.isEmpty())
			{
			System.out.println("No category page available ");
			}
			else
			{
				WebElement  elem= wait.until(ExpectedConditions.visibilityOf(GenericWebDriverFunctions.driver.findElement(By.xpath("//h1"))));
				GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, elem, "");
				String comparator =  GenericWebDriverFunctions.getText;
				if(leftNavText.contains(" "))
				{
					int count=0;
					

					String ar []  = leftNavText.split(" ");
					for(int counter =0 ;counter<ar.length;counter++)
					{
					if(Garbage.validateString(ar[counter],comparator))
					{
					System.out.println(leftNavText +" subcategory has a proper landing page");
					if(GenericWebDriverFunctions.driver.findElements(By.xpath("//div[@class='left-nav']/div[1]/div/a")).size()>0)
					{
						System.out.println(leftNavText +" subcategory has a again subcategories in it");
						
//						Garbage.validateLevel3Cat("//div[@class='left-nav']/div[1]/div/a");
					}
					else
					{
						System.out.println(leftNavText +" subcategory has no subcategories in it");
					}
					break;
					}
					else
					{
					count++;
					}
					}
					
					if(count == ar.length)
					{
						System.out.println(leftNavText+" subcategory doesn't have a proper landing page");
					}
				}
				else
				{
					if (Garbage.validateString(leftNavText,comparator))
					{
						System.out.println(leftNavText +" subcategory  has a proper landing page");
						if(GenericWebDriverFunctions.driver.findElements(By.xpath("//div[@class='left-nav']/div[1]/div/a")).size()>0)
						{
							System.out.println(leftNavText +" subcategory has a again subcategories in it");
//							Garbage.validateLevel3Cat("//div[@class='left-nav']/div[1]/div/a");
						}
						else
						{
							System.out.println(leftNavText +" subcategory has no subcategories in it");
						}
					}
					else
					{
						System.out.println(leftNavText+" subcategory doesn't have a proper landing page");
					}
				}
			
//				Garbage.validateSubCat();
				
			}
		 
			GenericWebDriverFunctions.driver.navigate().back();
			Thread.sleep(3000);
			leftNavElements= GenericWebDriverFunctions.driver.findElements(By.xpath("//div[@class='left-nav']/div[1]/div/a"));
//			if(GenericWebDriverFunctions.findElementsByXpath("(//a[contains(@id,'show-more')])[1]")>0)
//			{
//			WebElement eleme =  GenericWebDriverFunctions.driver.findElement(By.xpath("(//a[contains(@id,'show-more')])[1]"));
//			GenericWebDriverFunctions.performAction(StringConstants.CLICK, eleme, "");
//			}
			
//			  leftNavElements = GenericWebDriverFunctions.driver.findElements(By.xpath("//div[@class='left-nav']/div[1]/div/a"));
//		 list2= GenericWebDriverFunctions.driver.findElements(By.xpath("//div[@class='left-nav']/div[1]/div/div/a"));
//			leftNavElements.addAll(list2);
//			leftNavElements.remove(leftNavElements.size()-1);
		}
			
			
	}
	
	
//	public static void validateLevel3Cat(String locator) throws InterruptedException
//	{
//		leftNavElements= GenericWebDriverFunctions.driver.findElements(By.xpath(locator));
//		for(int i=0;i< (leftNavElements.size()-1);i++)
//		{
//			
//			WebElement element =   leftNavElements.get(i);
//			  
//			if(GenericWebDriverFunctions.findPopUpBy(StringConstants.POPUP)>0)
//			PopUpPage.popUp.click();
//			
//			GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, element, "");
//			String leftNavText = GenericWebDriverFunctions.getText;
//	 
//			GenericWebDriverFunctions.performAction(StringConstants.CLICK, element, "");
// 
//			if(leftNavText ==null || leftNavText.isEmpty())
//			{
//			System.out.println("No categoryL3 page available ");
//			}
//			else
//			{
//				WebElement  elem= wait.until(ExpectedConditions.visibilityOf(GenericWebDriverFunctions.driver.findElement(By.xpath("//h1"))));
//				GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, elem, "");
//				String comparator =  GenericWebDriverFunctions.getText;
//				if(leftNavText.contains(" "))
//				{
//					int count=0;
//					
//
//					String ar []  = leftNavText.split(" ");
//					for(int counter =0 ;counter<ar.length;counter++)
//					{
//					if(Garbage.validateString(ar[counter],comparator))
//					{
//					System.out.println(leftNavText +" categoryL3 has a proper landing page");
//					if(GenericWebDriverFunctions.driver.findElements(By.xpath("//div[@class='left-nav']/div[1]/div/a")).size()>0)
//					{
//						System.out.println(leftNavText +" categoryL3 has a again subcategories in it");
//					}
//					else
//					{
//						System.out.println(leftNavText +" categoryL3 has no subcategories in it");
//					}
//					break;
//					}
//					else
//					{
//					count++;
//					}
//					}
//					
//					if(count == ar.length)
//					{
//						System.out.println(leftNavText+" categoryL3 doesn't have a proper landing page");
//					}
//				}
//				else
//				{
//					if (Garbage.validateString(leftNavText,comparator))
//					{
//						System.out.println(leftNavText +" categoryL3  has a proper landing page");
//						if(GenericWebDriverFunctions.driver.findElements(By.xpath("//div[@class='left-nav']/div[1]/div/a")).size()>0)
//						{
//							System.out.println(leftNavText +" categoryL3 has a again subcategories in it");
//						}
//						else
//						{
//							System.out.println(leftNavText +" categoryL3 has no subcategories in it");
//						}
//					}
//					else
//					{
//						System.out.println(leftNavText+" categoryL3 doesn't have a proper landing page");
//					}
//				}
//			
////				Garbage.validateSubCat();
//			}
//		 
//			GenericWebDriverFunctions.driver.navigate().back();
//		 
//			leftNavElements= GenericWebDriverFunctions.driver.findElements(By.xpath(locator));
//		}
//		if(GenericWebDriverFunctions.findElementsByXpath("//div[contains(@class,'left-nav')]/div[1]/div/div/a")>0)
//		{
////			Garbage.viewMoreItems();
//		}
//		else
//		{
//		GenericWebDriverFunctions.driver.navigate().back();
//		}
//	}
	
	
//	public static void viewMoreItems()
//	{
//		WebElement viewMore = GenericWebDriverFunctions.driver.findElement(By.xpath("(//a[contains(@id,'show-more')])[1]"));
//		GenericWebDriverFunctions.performAction(StringConstants.CLICK, viewMore, "");
//		leftNavElements= GenericWebDriverFunctions.driver.findElements(By.xpath("//div[contains(@class,'left-nav')]/div[1]/div/div/a"));
//		for(int i=0;i< (leftNavElements.size()-1);i++)
//		{
//			
//			WebElement element =   leftNavElements.get(i);
//			  
//			if(GenericWebDriverFunctions.findPopUpBy(StringConstants.POPUP)>0)
//			PopUpPage.popUp.click();
//			
//			GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, element, "");
//			String leftNavText = GenericWebDriverFunctions.getText;
//	 
//			GenericWebDriverFunctions.performAction(StringConstants.CLICK, element, "");
// 
//			if(leftNavText ==null || leftNavText.isEmpty())
//			{
//			System.out.println("No categoryL3 page available ");
//			}
//			else
//			{
//				WebElement  elem= wait.until(ExpectedConditions.visibilityOf(GenericWebDriverFunctions.driver.findElement(By.xpath("//h1"))));
//				GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, elem, "");
//				String comparator =  GenericWebDriverFunctions.getText;
//				if(leftNavText.contains(" "))
//				{
//					int count=0;
//					
//
//					String ar []  = leftNavText.split(" ");
//					for(int counter =0 ;counter<ar.length;counter++)
//					{
//					if(Garbage.validateString(ar[counter],comparator))
//					{
//					System.out.println(leftNavText +" categoryL3 has a proper landing page");
//					if(GenericWebDriverFunctions.driver.findElements(By.xpath("//div[@class='left-nav']/div[1]/div/a")).size()>0)
//					{
//						System.out.println(leftNavText +" categoryL3 has a again subcategories in it");
//					}
//					else
//					{
//						System.out.println(leftNavText +" categoryL3 has no subcategories in it");
//					}
//					break;
//					}
//					else
//					{
//					count++;
//					}
//					}
//					
//					if(count == ar.length)
//					{
//						System.out.println(leftNavText+" categoryL3 doesn't have a proper landing page");
//					}
//				}
//				else
//				{
//					if (Garbage.validateString(leftNavText,comparator))
//					{
//						System.out.println(leftNavText +" categoryL3  has a proper landing page");
//						if(GenericWebDriverFunctions.driver.findElements(By.xpath("//div[@class='left-nav']/div[1]/div/a")).size()>0)
//						{
//							System.out.println(leftNavText +" categoryL3 has a again subcategories in it");
//						}
//						else
//						{
//							System.out.println(leftNavText +" categoryL3 has no subcategories in it");
//						}
//					}
//					else
//					{
//						System.out.println(leftNavText+" categoryL3 doesn't have a proper landing page");
//					}
//				}
//			
//				Garbage.validateSubCat();
//			}
//		 
//			GenericWebDriverFunctions.driver.navigate().back();
//		 
//			leftNavElements= GenericWebDriverFunctions.driver.findElements(By.xpath("//div[contains(@class,'left-nav')]/div[1]/div/div/a"));
//		}
//		
//		 
//	}
	
	
	
//	public static void mouseOverClick(WebElement element) throws InterruptedException
//	{
//		Actions builder = new Actions(GenericWebDriverFunctions.driver);
//		Action mouseOver = builder.moveToElement(
//				element).build();
//		mouseOver.perform();
//		Thread.sleep(500);
//	 
//		element.click();
//	}
	
	public static void viewMore()
	{
		
	}
	
}
