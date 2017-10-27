package com.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckBoxDemo {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();//up casting
		driver.manage().window().maximize();//maximize the browser
		driver.get("https://www.irctc.co.in");
		
		WebElement otpIdCheckBoxElement = driver.findElement(By.id("otpId"));
		
		
		System.out.println("Before Check = "+otpIdCheckBoxElement.getAttribute("checked"));
		System.out.println("Before Check using isSelected = "+otpIdCheckBoxElement.isSelected());//return true if its checked else false
		otpIdCheckBoxElement.click();//Uncheck/check the checkbox
		System.out.println("After Check = "+otpIdCheckBoxElement.getAttribute("checked"));
		System.out.println("After Check using isSelected = "+otpIdCheckBoxElement.isSelected());
		Thread.sleep(2000);
		otpIdCheckBoxElement.click();
		
	
		

	}

}
