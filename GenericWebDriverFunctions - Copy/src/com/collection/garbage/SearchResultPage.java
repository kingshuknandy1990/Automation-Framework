package com.collection.garbage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.GenericFunctions.WebDriver.GenericFunctionsExtra;

public class SearchResultPage {

	static WebDriver driver=new FirefoxDriver();
	static int cellno=1;
	
	public static void LandingPage(String url){
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void searchUsingkeyWord(String cat){
		driver.findElement(By.xpath(Constants.keyWordSearchbox)).sendKeys(cat);
		driver.findElement(By.xpath("//a[@id='search-btn']")).click();
	}
	
	public static void ValidateDiscounts(){
		String OfferPrice=null;
		String ListPrice=null;
		String DiscountPercent=null;
		if(driver.findElement(By.xpath(Constants.SRP_price)).isDisplayed()){
			String offerprice=" "+driver.findElement(By.xpath(Constants.SRP_price)).getText();
			String OfferPrice1[]=offerprice.split("\\$");
			OfferPrice=OfferPrice1[1];
			System.out.println("OfferPrice:$"+OfferPrice);
		}else{
			System.out.println("Offer Price is not Displayed");
		}
		
		if(driver.findElement(By.xpath(Constants.SRP_price_reg)).isDisplayed()){
			String st=driver.findElement(By.xpath(Constants.SRP_price_reg)).getText();
			
			String starr[]=st.split("\\$");
			ListPrice=starr[1];
			System.out.println("List Price:$"+ListPrice);
		}else{
			System.out.println("List Price is not Displayed");
		}
		
		if(driver.findElement(By.xpath(Constants.SRP_price_save)).isDisplayed()){
			if(driver.findElement(By.xpath(Constants.SRP_price_save)).getText().equalsIgnoreCase("")){
				
			}else{
			String st2[]=driver.findElement(By.xpath(Constants.SRP_price_save)).getText().split("\\:");
			String Save1[]=(st2[1]+" ").split("\\%");
			DiscountPercent=Save1[0];
			System.out.println("Save :"+DiscountPercent+"%");
			}
		}else{
			System.out.println("Save % is not Displayed");
		}
		
		Double OfferPriceFormattet=Double.valueOf(OfferPrice);
		double listPriceFormattet=Double.valueOf(ListPrice);
		double DiscountPercentFormattet=Double.valueOf(DiscountPercent);
		
		Double calculatedOfferPriceFormattet=listPriceFormattet*(1-(DiscountPercentFormattet/100));
		int OfferPriceint=OfferPriceFormattet.intValue();
	    int result=calculatedOfferPriceFormattet.intValue();
	    System.out.println("//////"+OfferPriceint+"//////"+result);
	    if(OfferPriceint==result){
	    	System.out.println("proper offer price is displayed in SRP");
	    }else{
	    	System.out.println("proper offer price is not displayed in SRP");
	    }
		
		
	}
	
	public static void ClickOnquickView() throws InterruptedException{

		    Actions actions = new Actions(driver);
		    //Hover on Mens Catagory
		    WebElement mainMenu = driver.findElement(By.xpath("(//img[@class='item-img'])[1]"));
		    actions.moveToElement(mainMenu).build().perform();
		
		driver.findElement(By.xpath(Constants.QVButton)).click();
		Thread.sleep(2000);
	}
	
	public static void ValidateDiscountsImQV() throws InterruptedException{
		
		Thread.sleep(1000);
		String OfferPrice=null;
		String ListPrice=null;
		String DiscountPercent=null;
		if(driver.findElement(By.xpath(Constants.QV_price)).isDisplayed()){
			String offerprice=" "+driver.findElement(By.xpath(Constants.QV_price)).getText();
			String OfferPrice1[]=offerprice.split("\\$");
			OfferPrice=OfferPrice1[1];
			System.out.println("OfferPrice:$"+OfferPrice);
		}else{
			System.out.println("Offer Price is not Displayed");
		}
		
		if(driver.findElement(By.xpath(Constants.QV_price_reg)).isDisplayed()){
			String st=driver.findElement(By.xpath(Constants.QV_price_reg)).getText();
			
			String starr[]=st.split("\\$");
			ListPrice=starr[1];
			System.out.println("List Price:$"+ListPrice);
		}else{
			System.out.println("List Price is not Displayed");
		}
		
		if(driver.findElement(By.xpath(Constants.QV_price_save)).isDisplayed()){
			String st2[]=driver.findElement(By.xpath(Constants.QV_price_save)).getText().split("\\:");
			String Save1[]=(st2[1]+" ").split("\\%");
			DiscountPercent=Save1[0];
			System.out.println("Save :"+DiscountPercent+"%");
		}else{
			System.out.println("Save % is not Displayed");
		}
		
		Double OfferPriceFormattet=Double.valueOf(OfferPrice);
		double listPriceFormattet=Double.valueOf(ListPrice);
		double DiscountPercentFormattet=Double.valueOf(DiscountPercent);
		
		Double calculatedOfferPriceFormattet=listPriceFormattet*(1-(DiscountPercentFormattet/100));
		int OfferPriceint=OfferPriceFormattet.intValue();
	    int result=calculatedOfferPriceFormattet.intValue();
	    System.out.println("//////"+OfferPriceint+"//////"+result);
	    if(OfferPriceint==result){
	    	System.out.println("proper offer price is displayed in Quick View");
	    }else{
	    	System.out.println("proper offer price is not displayed in Quick View");
	    }
		
	}
	
public static void ValidateDiscountsInCP() throws InterruptedException{
		
		Thread.sleep(1000);
		String OfferPrice=null;
		String ListPrice=null;
		String DiscountPercent=null;
		if(driver.findElement(By.xpath(Constants.CP_price)).isDisplayed()){
			String offerprice=" "+driver.findElement(By.xpath(Constants.CP_price)).getText();
			String OfferPrice1[]=offerprice.split("\\$");
			OfferPrice=OfferPrice1[1];
			System.out.println("OfferPrice:$"+OfferPrice);
		}else{
			System.out.println("Offer Price is not Displayed");
		}
		
		if(driver.findElement(By.xpath(Constants.CP_price_reg)).isDisplayed()){
			String st=driver.findElement(By.xpath(Constants.CP_price_reg)).getText();
			
			String starr[]=st.split("\\$");
			ListPrice=starr[1];
			System.out.println("List Price:$"+ListPrice);
		}else{
			System.out.println("List Price is not Displayed");
		}
		
		if(driver.findElement(By.xpath(Constants.CP_price_save)).isDisplayed()){
			String st2[]=driver.findElement(By.xpath(Constants.CP_price_save)).getText().split("\\:");
			String Save1[]=(st2[1]+" ").split("\\%");
			DiscountPercent=Save1[0];
			System.out.println("Save :"+DiscountPercent+"%");
		}else{
			System.out.println("Save % is not Displayed");
		}
		
		Double OfferPriceFormattet=Double.valueOf(OfferPrice);
		double listPriceFormattet=Double.valueOf(ListPrice);
		double DiscountPercentFormattet=Double.valueOf(DiscountPercent);
		
		Double calculatedOfferPriceFormattet=listPriceFormattet*(1-(DiscountPercentFormattet/100));
		int OfferPriceint=OfferPriceFormattet.intValue();
	    int result=calculatedOfferPriceFormattet.intValue();
	    System.out.println("//////"+OfferPriceint+"//////"+result);
	    if(OfferPriceint==result){
	    	System.out.println("proper offer price is displayed in Cart Page");
	    }else{
	    	System.out.println("proper offer price is not displayed in Cart Page");
	    }
		
	}
	
	@FindBy(xpath=Constants.CheckOutButton)
	static List<WebElement> CheckOutButtonList;
	
	public static void addToCart(){
		try {
			System.out.println("Inside add to cart function==========");
			///Modified by kingshuk
			Select select = new Select(driver.findElement(By.xpath("//select[@id='dd-Size']")));
			select.selectByIndex(1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		driver.findElement(By.xpath(Constants.AddToCartButton)).click();
		/*if(GenericFunctionsExtra.ElementVisibility(CheckOutButtonList)){
		driver.findElement(By.xpath(Constants.AddToCartButton)).click();	
		}*/
		try {
			Thread.sleep(1000);
			System.out.println("inside try Catch");
			driver.findElement(By.xpath(Constants.AddToCartButton)).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		driver.findElement(By.xpath(Constants.CheckOutButton)).click();
	}
	
	
	public static void ValidateDiscountsnew(){
		String OfferPrice=null;
		String ListPrice=null;
		String DiscountPercent=null;
		if(driver.findElement(By.xpath(Constants.SRP_price)).isDisplayed()){
			String offerprice=" "+driver.findElement(By.xpath(Constants.SRP_price)).getText();
			String OfferPrice1[]=offerprice.split("\\$");
			OfferPrice=OfferPrice1[1];
			System.out.println("OfferPrice:$"+OfferPrice);
		}else{
			System.out.println("Offer Price is not Displayed");
		}
		
		
		if(driver.findElement(By.xpath(Constants.SRP_price_save)).isDisplayed()){
			if(driver.findElement(By.xpath(Constants.SRP_price_save)).getText().equalsIgnoreCase("")){
				
				System.out.println("No discount applicable");
			}else{
				
				//Write code here
			}
		}else{
			System.out.println("No discount applicable");
		}
		System.out.println("---------------------------");
/*		if(driver.findElement(By.xpath(Constants.SRP_price_save)).getText().equalsIgnoreCase("")){
			System.out.println("No discount applicable");
		}else{
			System.out.println("Discount applicable");
		}*/
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		SearchResultPage.LandingPage("https://www.beallsflorida.com");
		SearchResultPage.searchUsingkeyWord("shirts");
		
		SearchResultPage.ValidateDiscountsnew();
		SearchResultPage.searchUsingkeyWord("Sub Urban Riot Womens");
		Thread.sleep(1000);
		SearchResultPage.ValidateDiscountsnew();
		//driver.navigate().refresh();
		
/*		SearchResultPage.ValidateDiscounts();
		SearchResultPage.ClickOnquickView();
		SearchResultPage.ValidateDiscountsImQV();
		SearchResultPage.addToCart();*/
		//SearchResultPage.ValidateDiscountsInCP();
	/*	driver.close();
		driver.quit();*/
		
	}
	
	public static void NavigatingToCartFromMinicart() throws InterruptedException{

		try {
			System.out.println("Inside add to cart function==========");
			///Modified by kingshuk
			Select select = new Select(driver.findElement(By.xpath("//select[@id='dd-Size']")));
			select.selectByIndex(1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		driver.findElement(By.xpath(Constants.AddToCartButton)).click();
		System.out.println("11----------------");
		/*if(GenericFunctionsExtra.ElementVisibility(CheckOutButtonList)){
		driver.findElement(By.xpath(Constants.AddToCartButton)).click();	
		}*/
		try {
			Thread.sleep(1000);
			System.out.println("inside try Catch");
			driver.findElement(By.xpath(Constants.AddToCartButton)).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		//driver.findElement(By.xpath(Constants.CheckOutButton)).click();
		Thread.sleep(1000);
		System.out.println("1----------------");
		driver.findElement(By.xpath(Constants.ContinueShoppingButton)).click();
		System.out.println("2----------------");
	
	}
}
