package com.spi;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowHandlingDemo {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		
		System.out.println("\nBefore Click on Flight Tickets");
		printWindowDetails(driver);
		driver.findElement(By.linkText("Flight Tickets")).click();
		System.out.println("\nAfter Click on Flight Tickets");
		printWindowDetails(driver);
		
		String fTWindowUC = getWindowUniqueCode(driver, 1);
		driver.switchTo().window(fTWindowUC);
		driver.findElement(By.linkText("FAQs")).click();
		
		
		System.out.println("\nAfter Click on FAQs in Flight Tickets Window");
		printWindowDetails(driver);
		
		String FAQsUC = getWindowUniqueCode(driver, 2);
		driver.switchTo().window(FAQsUC);
		
		
		
		System.out.println("\nAfter Switch to FAQs Window");
		printWindowDetails(driver);
		Thread.sleep(3000);
		driver.close();
		
		System.out.println("\nAfter closing FAQs Window");
		
		driver.switchTo().window(fTWindowUC);
		printWindowDetails(driver);
		
		driver.quit();

	}
	
	
	public static void printWindowDetails(WebDriver driver){
		Set<String> windowDetails = driver.getWindowHandles();
		System.out.println("Current Window Unique Code = "+driver.getWindowHandle());
		System.out.println("No of Windows = "+windowDetails.size());
		
		
		for(String str : windowDetails){
			System.out.println(str);
		}
	}
	
	public static String getWindowUniqueCode(WebDriver driver,int indexOfWindow){
		Set<String> windowDetails = driver.getWindowHandles();
		if(indexOfWindow >= 0 && indexOfWindow<windowDetails.size()){
			return (String) windowDetails.toArray()[indexOfWindow];
		}
		return null;
	}

}
